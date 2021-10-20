package io.github.yellldo.starter.genid.service.impl.provider;

/**
 * ClassName: PropertyMachineIdProvider<br>
 * Description: PropertyMachineIdProvider <br>
 * Company: rrtx
 *
 * @author xugz
 * @version v1.0.0    2019/2/24 10:48 AM  xugz    文件初始创建
 */
public class PropertyMachineIdProvider implements MachineIdProvider {
	private long machineId;

	@Override
	public long getMachineId() {
		return machineId;
	}

	public void setMachineId(long machineId) {
		this.machineId = machineId;
	}
}
