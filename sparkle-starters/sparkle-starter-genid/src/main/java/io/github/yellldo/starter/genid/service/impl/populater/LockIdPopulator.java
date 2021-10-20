package io.github.yellldo.starter.genid.service.impl.populater;


import io.github.yellldo.starter.genid.service.Id;
import io.github.yellldo.starter.genid.service.impl.bean.IdMeta;
import io.github.yellldo.starter.genid.service.impl.timer.Timer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName: LockIdPopulator<br>
 * Description: LockIdPopulator <br>
 * Company: rrtx
 *
 * @author xugz
 * @version v1.0.0    2019/2/24 10:48 AM  xugz    文件初始创建
 */
public class LockIdPopulator extends BasePopulator {

	private Lock lock = new ReentrantLock();

	public LockIdPopulator() {
		super();
	}

	@Override
	public void populateId(Timer timer, Id id, IdMeta idMeta) {
		lock.lock();
		try {
			super.populateId(timer, id, idMeta);
		} finally {
			lock.unlock();
		}
	}

}
