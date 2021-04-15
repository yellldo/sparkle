package com.sparkle.starter.genid.service.impl.populater;


import com.sparkle.starter.genid.service.Id;
import com.sparkle.starter.genid.service.impl.bean.IdMeta;
import com.sparkle.starter.genid.service.impl.timer.Timer;

/**
 * ClassName: IdPopulator<br>
 * Description: IdPopulator <br>
 * Company: rrtx
 *
 * @author xugz
 * @version v1.0.0    2019/2/24 10:47 AM  xugz    文件初始创建
 */
public interface IdPopulator {

	void populateId(Timer timer, Id id, IdMeta idMeta);

}
