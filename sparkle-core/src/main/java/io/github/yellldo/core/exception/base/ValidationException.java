package io.github.yellldo.core.exception.base;

import io.github.yellldo.core.exception.BaseException;
import io.github.yellldo.core.exception.SysErrorEnum;

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
