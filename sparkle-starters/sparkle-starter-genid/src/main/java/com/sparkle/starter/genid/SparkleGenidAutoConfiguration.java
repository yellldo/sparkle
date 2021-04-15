package com.sparkle.starter.genid;

import com.sparkle.starter.genid.configuration.GenidConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName : SparkleGenidAutoConfiguration<br>
 * Description : 分布式id自动配置<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/4/15
 */
@Slf4j
@Configuration
@EnableConfigurationProperties({GenidConfiguration.class})
public class SparkleGenidAutoConfiguration {


    @Autowired
    private GenidConfiguration genidConfiguration;



}
