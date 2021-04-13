package com.sparkle.starter.mybatis.plus.filter;

import org.springframework.boot.autoconfigure.AutoConfigurationImportFilter;
import org.springframework.boot.autoconfigure.AutoConfigurationMetadata;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * ClassName : AutoConfigurationExclusionFilter<br>
 * Description : AutoConfigurationExclusionFilter<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/4/13
 */
public class AutoConfigurationExclusionFilter implements AutoConfigurationImportFilter {

    private static final Set<String> SHOULD_SKIP = new HashSet<>(
            Arrays.asList("com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure"));

    @Override
    public boolean[] match(String[] classNames, AutoConfigurationMetadata autoConfigurationMetadata) {
        boolean[] matches = new boolean[classNames.length];

        for(int i = 0; i< classNames.length; i++) {
            matches[i] = !SHOULD_SKIP.contains(classNames[i]);
        }
        return matches;
    }
}
