package com.sparkle.starter.genid.service.impl.provider;

/**
 * ClassName: MachineIdsProvider<br>
 * Description: MachineIdsProvider <br>
 * Company: rrtx
 *
 * @author xugz
 * @version v1.0.0    2019/2/24 10:48 AM  xugz    文件初始创建
 */
public interface MachineIdsProvider extends MachineIdProvider {

	long getNextMachineId();

}
