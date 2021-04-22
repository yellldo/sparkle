package com.sparkle.generator.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sparkle.generator.entity.Column;
import com.sparkle.generator.entity.Table;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName : GeneratorMapper<br>
 * Description : GeneratorMapper<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/4/22
 */
public interface GeneratorMapper {

    List<String> getDatabases(@Param("databaseType") String databaseType);

    IPage<Table> getTables(Page page, @Param("tableName") String tableName, @Param("databaseType") String databaseType, @Param("schemaName") String schemaName);

    List<Column> getColumns(@Param("databaseType") String databaseType, @Param("schemaName") String schemaName, @Param("tableName") String tableName);
}
