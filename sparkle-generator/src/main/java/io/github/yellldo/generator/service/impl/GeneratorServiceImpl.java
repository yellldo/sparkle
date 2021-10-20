package io.github.yellldo.generator.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.yellldo.generator.constant.Constant;
import io.github.yellldo.generator.entity.Column;
import io.github.yellldo.generator.entity.Table;
import io.github.yellldo.generator.mapper.GeneratorMapper;
import io.github.yellldo.generator.service.IGeneratorService;
import io.github.yellldo.generator.utils.SortUtil;
import io.github.yellldo.starter.mybatis.plus.entity.QueryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName : GeneratorServiceImpl<br>
 * Description : TODO<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/4/22
 */
@Service
public class GeneratorServiceImpl implements IGeneratorService {

    @Autowired
    private GeneratorMapper generatorMapper;

    @Override
    public List<String> getDataBases(String databaseType) {
        return generatorMapper.getDatabases(databaseType);
    }

    @Override
    public IPage<Table> getTables(String tableName, QueryRequest queryRequest, String databaseType, String schemaName) {
        Page<Table> page = new Page(queryRequest.getPageNum(), queryRequest.getPageSize());
        SortUtil.handlePageSort(queryRequest, page, "createTime", Constant.ORDER_ASC, false);
        return generatorMapper.getTables(page, tableName, databaseType, schemaName);
    }

    @Override
    public List<Column> getColumns(String databaseType, String tableName, String schemaName) {
        return generatorMapper.getColumns(databaseType, schemaName, tableName);
    }
}
