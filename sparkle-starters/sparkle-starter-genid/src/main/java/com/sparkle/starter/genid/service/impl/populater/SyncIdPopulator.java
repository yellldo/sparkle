package com.sparkle.starter.genid.service.impl.populater;


import com.sparkle.starter.genid.service.Id;
import com.sparkle.starter.genid.service.impl.bean.IdMeta;
import com.sparkle.starter.genid.service.impl.timer.Timer;

/**
 * ClassName: SyncIdPopulator<br>
 * Description: SyncIdPopulator <br>
 * Company: rrtx
 *
 * @author xugz
 * @version v1.0.0    2019/2/24 10:48 AM  xugz    文件初始创建
 */
public class SyncIdPopulator extends BasePopulator {

	public SyncIdPopulator() {
		super();
	}

	@Override
	public synchronized void populateId(Timer timer, Id id, IdMeta idMeta) {
		super.populateId(timer, id, idMeta);
	}

}
