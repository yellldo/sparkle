package io.github.yellldo.starter.genid.service.impl.provider;

/**
 * ClassName: PropertyMachineIdsProvider<br>
 * Description: PropertyMachineIdsProvider <br>
 * Company: rrtx
 *
 * @author xugz
 * @version v1.0.0    2019/2/24 10:49 AM  xugz    文件初始创建
 */
public class PropertyMachineIdsProvider implements MachineIdsProvider {
	private long[] machineIds;
	private int currentIndex;

	@Override
	public long getNextMachineId() {
		return getMachineId();
	}

	@Override
	public long getMachineId() {
		return machineIds[currentIndex++ % machineIds.length];
	}

	public void setMachineIds(long[] machineIds) {
		this.machineIds = machineIds;
	}
}
