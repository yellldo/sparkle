package com.sparkle.core.exception.base;

import com.sparkle.core.exception.BaseException;
import com.sparkle.core.exception.SysErrorEnum;

/**
 * ClassName : ValidationException<br>
 * Description : TODO<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/2/16
 */
public class ValidationException extends BaseException {

    public ValidationException(String message) {
        super(SysErrorEnum.VALIDATION_ERROR);
        this.setErrorMessage(message);
    }

}
