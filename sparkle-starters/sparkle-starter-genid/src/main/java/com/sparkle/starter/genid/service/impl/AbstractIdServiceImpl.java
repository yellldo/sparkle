package com.sparkle.starter.genid.service.impl;

import com.sparkle.starter.genid.configuration.GenidConfiguration;
import com.sparkle.starter.genid.service.Id;
import com.sparkle.starter.genid.service.IdService;
import com.sparkle.starter.genid.service.impl.bean.IdMeta;
import com.sparkle.starter.genid.service.impl.bean.IdMetaFactory;
import com.sparkle.starter.genid.service.impl.bean.IdType;
import com.sparkle.starter.genid.service.impl.converter.IdConverter;
import com.sparkle.starter.genid.service.impl.timer.Timer;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * ClassName : AbstractIdService<br>
 * Description : AbstractIdServiceImpl<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/4/15
 */
@Data
@Slf4j
public abstract class AbstractIdServiceImpl implements IdService {

    protected long machineId = -1;
    protected long genMethod = 0;
    protected long version = 0;

    protected IdType idType;
    protected IdMeta idMeta;


    protected GenidConfiguration genidConfiguration;

    protected IdConverter idConverter;

    protected Timer timer;


    public AbstractIdServiceImpl(IdConverter idConverter, Timer timer, GenidConfiguration genidConfiguration) {
        this.idType = IdType.parse(genidConfiguration.getType());
        this.idConverter = idConverter;
        this.timer = timer;
        this.genidConfiguration = genidConfiguration;
        if (this.idMeta == null) {
            setIdMeta(IdMetaFactory.getIdMeta(idType));
        }

        this.timer.init(idMeta, idType);

        this.machineId = genidConfiguration.getMachine();
    }


    @Override
    public long genId() {
        Id id = new Id();

        id.setMachine(machineId);
        id.setGenMethod(genMethod);
        id.setType(idType.value());
        id.setVersion(version);

        populateId(id);

        long ret = idConverter.convert(id, this.idMeta);

        // Use trace because it cause low performance
        if (log.isTraceEnabled()) {
            log.trace(String.format("Id: %s => %d", id, ret));
        }

        return ret;
    }

    public void validateMachineId(long machineId) {
        if (machineId < 0) {
            log.error("The machine ID is not configured properly (" + machineId + " < 0) so that Vesta Service refuses to start.");

            throw new IllegalStateException(
                    "The machine ID is not configured properly (" + machineId + " < 0) so that Vesta Service refuses to start.");

        } else if (machineId >= (1 << this.idMeta.getMachineBits())) {
            log.error("The machine ID is not configured properly ("
                    + machineId + " >= " + (1 << this.idMeta.getMachineBits()) + ") so that Vesta Service refuses to start.");

            throw new IllegalStateException("The machine ID is not configured properly ("
                    + machineId + " >= " + (1 << this.idMeta.getMachineBits()) + ") so that Vesta Service refuses to start.");

        }
    }

    protected abstract void populateId(Id id);

    @Override
    public Date transTime(final long time) {
        return timer.transTime(time);
    }


    @Override
    public Id expId(long id) {
        return idConverter.convert(id, this.idMeta);
    }

    @Override
    public long makeId(long time, long seq) {
        return makeId(time, seq, machineId);
    }

    @Override
    public long makeId(long time, long seq, long machine) {
        return makeId(genMethod, time, seq, machine);
    }

    @Override
    public long makeId(long genMethod, long time, long seq, long machine) {
        return makeId(idType.value(), genMethod, time, seq, machine);
    }

    @Override
    public long makeId(long type, long genMethod, long time,
                       long seq, long machine) {
        return makeId(version, type, genMethod, time, seq, machine);
    }

    @Override
    public long makeId(long version, long type, long genMethod,
                       long time, long seq, long machine) {
        Id id = new Id(machine, seq, time, genMethod, type, version);
        return idConverter.convert(id, this.idMeta);
    }
}
