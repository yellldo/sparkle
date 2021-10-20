package io.github.yellldo.starter.genid.service.impl;

import io.github.yellldo.starter.genid.configuration.GenidConfiguration;
import io.github.yellldo.starter.genid.service.Id;
import io.github.yellldo.starter.genid.service.impl.converter.IdConverter;
import io.github.yellldo.starter.genid.service.impl.populater.IdPopulator;
import io.github.yellldo.starter.genid.service.impl.timer.Timer;

/**
 * ClassName : IdServiceImpl<br>
 * Description : IdServiceImpl<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/4/15
 */
public class IdServiceImpl  extends AbstractIdServiceImpl{

    protected IdPopulator idPopulator;

    public IdServiceImpl(IdConverter idConverter, Timer timer, GenidConfiguration genidConfiguration, IdPopulator idPopulator) {
        super(idConverter, timer, genidConfiguration);
        this.idPopulator = idPopulator;
    }


    @Override
    protected void populateId(Id id) {
        idPopulator.populateId(timer, id, idMeta);
    }

    public void setIdPopulator(IdPopulator idPopulator) {
        this.idPopulator = idPopulator;
    }
}
