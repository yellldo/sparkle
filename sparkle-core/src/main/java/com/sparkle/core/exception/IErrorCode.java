package com.sparkle.core.exception;

/**
 * ClassName : IErrorCode<br>
 * Description : 错误码接口抽象，供枚举实现来做全局异常统一处理使用<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/2/16
 */
public interface IErrorCode {


    /**
     * 获取错误码
     *
     * @return
     */
    String getErrorCode();

    /**
     * 获取错误描述
     *
     * @return
     */
    String getErrorMessage();

}
