package io.github.yellldo.starter.genid.service.impl.populater;


import io.github.yellldo.starter.genid.service.Id;
import io.github.yellldo.starter.genid.service.impl.bean.IdMeta;
import io.github.yellldo.starter.genid.service.impl.timer.Timer;

import java.util.concurrent.atomic.AtomicReference;

/**
 * ClassName: AtomicIdPopulator<br>
 * Description: AtomicIdPopulator <br>
 * Company: rrtx
 *
 * @author xugz
 * @version v1.0.0    2019/2/24 10:48 AM  xugz    文件初始创建
 */
public class AtomicIdPopulator implements IdPopulator, ResetPopulator {

	private AtomicReference<Variant> variant = new AtomicReference<Variant>(new Variant());

	public AtomicIdPopulator() {
		super();
	}

	@Override
	public void populateId(Timer timer, Id id, IdMeta idMeta) {
		Variant varOld, varNew;
		long timestamp, sequence;

		while (true) {

			// Save the old variant
			varOld = variant.get();

			// populate the current variant
			timestamp = timer.genTime();
			timer.validateTimestamp(varOld.lastTimestamp, timestamp);

			sequence = varOld.sequence;

			if (timestamp == varOld.lastTimestamp) {
				sequence++;
				sequence &= idMeta.getSeqBitsMask();
				if (sequence == 0) {
					timestamp = timer.tillNextTimeUnit(varOld.lastTimestamp);
				}
			} else {
				sequence = 0;
			}

			// Assign the current variant by the atomic tools
			varNew = new Variant();
			varNew.sequence = sequence;
			varNew.lastTimestamp = timestamp;

			if (variant.compareAndSet(varOld, varNew)) {
				id.setSeq(sequence);
				id.setTime(timestamp);

				break;
			}

		}
	}

	@Override
	public void reset() {
		variant = new AtomicReference<Variant>(new Variant());
	}

	class Variant {

		private long sequence = 0;
		private long lastTimestamp = -1;

	}

}
