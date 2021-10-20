package io.github.yellldo.starter.genid.service.impl.converter;

import io.github.yellldo.starter.genid.service.Id;
import io.github.yellldo.starter.genid.service.impl.bean.IdMeta;
import org.springframework.stereotype.Service;

/**
 * ClassName : IdConverterImpl<br>
 * Description : IdConverterImpl<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/4/26
 */
@Service
public class IdConverterImpl implements IdConverter {

    public IdConverterImpl() {

    }

    @Override
    public long convert(Id id, IdMeta idMeta) {
        return doConvert(id, idMeta);
    }

    /**
     * 将id反解为ID对象
     *
     * @param id
     * @param idMeta
     * @return
     */
    @Override
    public Id convert(long id, IdMeta idMeta) {
        return doConvert(id, idMeta);
    }

    protected long doConvert(Id id, IdMeta idMeta) {
        long ret = 0;
        ret |= id.getSeq();
        ret |= id.getMachine() << idMeta.getMachineBits();
        ret |= id.getTime() << idMeta.getTimeBits();
        ret |= id.getGenMethod() << idMeta.getGenMethodBits();
        ret |= id.getType() << idMeta.getTypeBits();
        ret |= id.getVersion() << idMeta.getVersionBits();
        return ret;
    }


    protected Id doConvert(long id, IdMeta idMeta) {
        Id ret = new Id();
        ret.setSeq(id & idMeta.getSeqBitsMask());
        ret.setMachine(id >>> idMeta.getMachineBitsStartPos() & idMeta.getMachineBitsMask());
        ret.setTime(id >>> idMeta.getTimeBitsStartPos() & idMeta.getTimeBitsMask());
        ret.setGenMethod(id >>> idMeta.getGenMethodBitsStartPos() & idMeta.getGenMethodBitsMask());
        ret.setType(id >>> idMeta.getTypeBitsStartPos() & idMeta.getTypeBitsMask());
        ret.setVersion(id >>> idMeta.getVersionBitsStartPos() & idMeta.getVersionBitsMask());
        return ret;
    }

}
