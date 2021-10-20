package io.github.yellldo.starter.mybatis.plus;

import io.github.yellldo.starter.mybatis.plus.configuration.AutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * ClassName : EnableMybatisPlus<br>
 * Description : <br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/4/13
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(AutoConfiguration.class)
@Documented
@Inherited
public @interface EnableMybatisPlus {
}
