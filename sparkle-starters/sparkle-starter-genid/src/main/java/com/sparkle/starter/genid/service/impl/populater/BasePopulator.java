package com.sparkle.starter.genid.service.impl.populater;


import com.sparkle.starter.genid.service.Id;
import com.sparkle.starter.genid.service.impl.bean.IdMeta;
import com.sparkle.starter.genid.service.impl.timer.Timer;

/**
 * ClassName: BasePopulator<br>
 * Description: BasePopulator <br>
 * Company: rrtx
 *
 * @author xugz
 * @version v1.0.0    2019/2/24 10:48 AM  xugz    文件初始创建
 */
public abstract class BasePopulator implements IdPopulator, ResetPopulator {
	protected long sequence = 0;
	protected long lastTimestamp = -1;

	public BasePopulator() {
		super();
	}

	@Override
	public void populateId(Timer timer, Id id, IdMeta idMeta) {
		long timestamp = timer.genTime();
		timer.validateTimestamp(lastTimestamp, timestamp);

		if (timestamp == lastTimestamp) {
			sequence++;
			sequence &= idMeta.getSeqBitsMask();
			if (sequence == 0) {
				timestamp = timer.tillNextTimeUnit(lastTimestamp);
			}
		} else {
			lastTimestamp = timestamp;
			sequence = 0;
		}

		id.setSeq(sequence);
		id.setTime(timestamp);
	}

	@Override
	public void reset() {
		this.sequence = 0;
		this.lastTimestamp = -1;
	}
}
