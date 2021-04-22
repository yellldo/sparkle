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


    VALIDATION_ERROR("-11", ""),
    GENERA_EMPTY("-2", "代码生成配置为空"),
    FILE_DOWNLOAD_ERROR("-3", "文件下载异常"),
    ;
    private String code;
    private String msg;

    SysErrorEnum(final String code, final String msg) {
        this.code = code;
        this.msg = msg;
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
