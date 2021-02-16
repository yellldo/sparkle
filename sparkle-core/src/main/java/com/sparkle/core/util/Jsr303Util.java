package com.sparkle.core.util;

import cn.hutool.core.util.StrUtil;
import com.sparkle.core.exception.base.ValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * ClassName : Jsr303Util<br>
 * Description : Jsr303校验工具类<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/2/16
 */
public class Jsr303Util {

    /**
     * 线程安全，可以全局复用，无需多次构建，严重浪费性能
     */
    private static final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public static void check(Object obj) throws ValidationException {
        if (null == obj) {
            throw new ValidationException("入参vo不能为空");
        }
        Set<ConstraintViolation<Object>> validResult = validator.validate(obj);
        if (null != validResult && validResult.size() > 0) {
            StringBuilder sb = new StringBuilder();
            validResult.forEach(violation -> {
                if (StrUtil.isNotEmpty(violation.getMessage())) {
                    sb.append(violation.getMessage()).append("、");
                } else {
                    sb.append(violation.getPropertyPath().toString()).append("不合法、");
                }
            });
            if (sb.lastIndexOf("、") == sb.length() - 1) {
                sb.delete(sb.length() - 1, sb.length());
            }
            throw new ValidationException(sb.toString());
        }

    }

}
