package com.sparkle.core.exception;

import com.sparkle.core.entity.R;
import lombok.Data;

/**
 * ClassName : BaseException<br>
 * Description : 基础异常类<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/2/16
 */
@Data
public class BaseException extends RuntimeException {

    private IErrorCode iErrorCode;

    private String errorCode;

    private String errorMessage;

    public BaseException(IErrorCode iErrorCode) {
        super(iErrorCode.getErrorMessage());
        this.iErrorCode = iErrorCode;
        this.errorCode = iErrorCode.getErrorCode();
        this.errorMessage = iErrorCode.getErrorMessage();
    }

    public BaseException(R r) {
        super();
        this.setErrorCode(r.getStatus());
        this.setErrorMessage(r.getMessage());
    }
}
