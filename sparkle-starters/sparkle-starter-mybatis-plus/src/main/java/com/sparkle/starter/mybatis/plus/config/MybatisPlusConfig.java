package com.sparkle.starter.mybatis.plus.config;

import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName : MybatisPlusConfig<br>
 * Description : <br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/4/13
 */
@Configuration
public class MybatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        List<ISqlParser> sqlParsers = new ArrayList<>();
        // 攻击 sql阻断解析器、加入解析链
        sqlParsers.add(new BlockAttackSqlParser());
        paginationInterceptor.setSqlParserList(sqlParsers);
        paginationInterceptor.setLimit(-1);
        return paginationInterceptor;
    }
}

