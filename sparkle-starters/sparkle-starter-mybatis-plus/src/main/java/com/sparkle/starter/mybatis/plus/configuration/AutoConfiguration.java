package com.sparkle.starter.mybatis.plus.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName : AutoConfiguration<br>
 * Description : AutoConfiguration<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/4/13
 */
@Configuration
@MapperScan("com.sparkle.starter.mybatis.plus.mapper")
@ComponentScan("com.sparkle.starter.mybatis.plus")
public class AutoConfiguration {
}
