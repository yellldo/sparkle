package io.github.yellldo.core.mask;

/**
 * ClassName : LogMask<br>
 * Description : 标注于 DTO/VO 类的字段上，被标注的参数在进行日志输出会进行掩码处理<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/2/16
 */
public @interface LogMask {

    MaskType value() default MaskType.DEFAULT;

}
