package com.sparkle.core.exception;

/**
 * ClassName : SysErrorEnum<br>
 * Description : <br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/2/16
 */
public enum SysErrorEnum implements IErrorCode {

    /**
     * 未知错误
     */
    UNKNOWN_ERROR("-1"),
    VALIDATION_ERROR("-11"),
    ;
    private String code;

    SysErrorEnum(final String code) {
        this.code = code;
    }


    @Override
    public String getErrorCode() {
        return this.code;
    }

    @Override
    public String getErrorMessage() {
        return this.code;
    }
}
