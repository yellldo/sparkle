package com.sparkle.starter.genid.service.impl.timer;

import com.sparkle.starter.genid.service.impl.bean.IdMeta;
import com.sparkle.starter.genid.service.impl.bean.IdType;

import java.util.Date;

/**
 * ClassName : Timer<br>
 * Description : Timer<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/4/15
 */
public interface Timer {

    long EPOCH = 1316016000000L;

    void init(IdMeta idMeta, IdType idType);

    Date transTime(long time);

    void validateTimestamp(long lastTimestamp, long timestamp);

    long tillNextTimeUnit(long lastTimestamp);

    long genTime();
}
