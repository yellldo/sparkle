package io.github.yellldo.core.exception.base;

import io.github.yellldo.core.entity.R;
import io.github.yellldo.core.exception.BaseException;
import io.github.yellldo.core.exception.IErrorCode;
import lombok.Getter;

/**
 * ClassName : BusinessException<br>
 * Description : 业务异常 <br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/2/16
 */
public class BusinessException extends BaseException {

    @Getter
    private String[] args;

    public BusinessException(IErrorCode iErrorCode) {
        super(iErrorCode);
    }

    public BusinessException(IErrorCode iErrorCode, String... args) {
        super(iErrorCode);
        this.args = args;
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(R r) {
        super(r);
    }
}
