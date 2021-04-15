package com.sparkle.starter.genid.service.impl.converter;

import com.sparkle.starter.genid.service.Id;
import com.sparkle.starter.genid.service.impl.bean.IdMeta;

/**
 * ClassName : IdConverter<br>
 * Description : IdConverter<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/4/15
 */
public interface IdConverter {

    /***
     * 方法描述：将ID对象生成id
     *
     */

    long convert(Id id, IdMeta idMeta);

    /***
     * 方法描述：将id反解为ID对象
     */

    Id convert(long id, IdMeta idMeta);

}
