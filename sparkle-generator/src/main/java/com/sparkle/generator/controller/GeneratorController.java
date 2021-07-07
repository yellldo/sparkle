package com.sparkle.generator.controller;

import com.sparkle.core.entity.R;
import com.sparkle.core.exception.SysErrorEnum;
import com.sparkle.core.exception.base.BusinessException;
import com.sparkle.core.exception.base.FileDownloadException;
import com.sparkle.generator.entity.Column;
import com.sparkle.generator.entity.GeneratorConfig;
import com.sparkle.generator.entity.GeneratorConstant;
import com.sparkle.generator.helper.GeneratorHelper;
import com.sparkle.generator.service.IGeneratorConfigService;
import com.sparkle.generator.service.IGeneratorService;
import com.sparkle.generator.utils.AdmUtil;
import com.sparkle.generator.utils.FileUtil;
import com.sparkle.starter.mybatis.plus.controller.BaseController;
import com.sparkle.starter.mybatis.plus.entity.QueryRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

/**
 * ClassName : GeneratorController<br>
 * Description : TODO<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/4/22
 */
@Slf4j
@RestController
@RequestMapping("generator")
public class GeneratorController extends BaseController {

    private static final String SUFFIX = "_code.zip";

    @Autowired
    private IGeneratorConfigService generatorConfigService;
    @Autowired
    private IGeneratorService generatorService;
    @Autowired
    private GeneratorHelper generatorHelper;

    @PostMapping("tables/info")
    public R tableInfo(String tableName, QueryRequest queryRequest) {
        Map<String, Object> map = getDataTable(generatorService.getTables(tableName, queryRequest, GeneratorConstant.DATABASE_TYPE, GeneratorConstant.DATABASE_NAME));
        return R.ok().data(map);
    }


    @PostMapping
    public void generate(@NotBlank(message = "{required}") String name, String remark, HttpServletResponse response) throws FileDownloadException {
        try {
            GeneratorConfig generatorConfig = generatorConfigService.findGeneratorConfig();
            if (generatorConfig == null) {
                throw new BusinessException(SysErrorEnum.GENERA_EMPTY);
            }

            String className = name;
            if (GeneratorConfig.TRIM_YES.equals(generatorConfig.getIsTrim())) {
                className = name.replace(generatorConfig.getTrimValue(), "");
            }

            generatorConfig.setTableName(name);
            generatorConfig.setClassName(AdmUtil.underscoreToCamel(className));
            generatorConfig.setTableComment(remark);
            // 生成代码到临时目录
            List<Column> columns = generatorService.getColumns(GeneratorConstant.DATABASE_TYPE, name, GeneratorConstant.DATABASE_NAME);
            generatorHelper.generateEntityFile(columns, generatorConfig);
            generatorHelper.generateMapperFile(columns, generatorConfig);
            generatorHelper.generateMapperXmlFile(columns, generatorConfig);
            generatorHelper.generateServiceFile(columns, generatorConfig);
            generatorHelper.generateServiceImplFile(columns, generatorConfig);
            generatorHelper.generateControllerFile(columns, generatorConfig);
            // 打包
            String zipFile = System.currentTimeMillis() + SUFFIX;
            FileUtil.compress(GeneratorConstant.TEMP_PATH + "src", zipFile);
            // 下载
            FileUtil.download(zipFile, name + SUFFIX, true, response);
            // 删除临时目录
            FileUtil.delete(GeneratorConstant.TEMP_PATH);
        } catch (Exception e) {
            String message = "代码生成失败，" + e.getMessage();
            log.error(message, e);
            throw new FileDownloadException(message);
        }
    }


}
