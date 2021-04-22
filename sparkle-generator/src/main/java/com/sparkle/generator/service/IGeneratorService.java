package com.sparkle.generator.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sparkle.generator.entity.Column;
import com.sparkle.generator.entity.Table;
import com.sparkle.starter.mybatis.plus.entity.QueryRequest;

import java.util.List;

/**
 * ClassName : IGeneratorService<br>
 * Description : IGeneratorService<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/4/22
 */
public interface IGeneratorService {

    /**
     * 获取database
     *
     * @param databaseType
     * @return
     */
    List<String> getDataBases(String databaseType);

    /**
     * 获取table
     *
     * @param databaseType
     * @param queryRequest
     * @param schemaName
     * @param tableName
     * @return
     */
    IPage<Table> getTables(String tableName, QueryRequest queryRequest, String databaseType, String schemaName);

    /**
     * 获取列
     *
     * @param databaseType
     * @param tableName
     * @param schemaName
     * @return
     */
    List<Column> getColumns(String databaseType, String tableName, String schemaName);

}
