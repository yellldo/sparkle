package com.sparkle.starter.genid.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName : GenidConfiguration<br>
 * Description : GenidConfiguration<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/4/15
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "sparkle.genid")
public class GenidConfiguration {

    /**
     * 机器id
     */
    private long machine;

    /**
     * type为0, 表示最大峰值型，如果想要使用最小粒度型，则设置为1
     */
    private long type = 0;

    /**
     * 0:ReentrantLock 使用concurrent包的ReentrantLock进行互斥，这是缺省的实现方式，也是追求性能和稳定两个目标的妥协方案
     * 1:synchronized 使用传统的synchronized进行互斥，这种方式的性能稍微逊色一些
     * 2:ReentrantLock 使用concurrent包的ReentrantLock进行互斥，这种实现方式的性能非常高，但是在高并发环境下CPU负载会很高
     */
    private long lockType = 0;


}
