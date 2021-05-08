package com.rrtx.adm.system.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.sparkle.generator.common.controller.BaseController;
import com.sparkle.core.entity.R;
import com.sparkle.starter.mybatis.plus.entity.QueryRequest;
import com.sparkle.core.exception.base.BusinessException;
import ${basePackage}.${entityPackage}.${className};
import ${basePackage}.${servicePackage}.I${className}Service;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import cn.hutool.core.io.resource.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
* ClassName: ${className}Controller<br>
* Description: ${tableComment} Controller <br>
*
* @author ${author}
* @version v1.0.0    ${date}  ${author}    由Generator自动创建
*/
@Slf4j
@Controller
public class ${className}Controller extends BaseController {

@Autowired
private I${className}Service ${className?uncap_first}Service;

@GetMapping("${className?uncap_first}")
private String ${className?uncap_first}Index(){
return "${className?uncap_first}/${className?uncap_first}";
}

@GetMapping("${className?uncap_first}")
@ResponseBody
public R getAll${className}s(${className} ${className?uncap_first}) {
return R.ok(${className?uncap_first}Service.find${className}s(${className?uncap_first}));
}

@GetMapping("${className?uncap_first}/list")
@ResponseBody
public R ${className?uncap_first}List(QueryRequest request, ${className} ${className?uncap_first}) {
Map<String, Object> dataTable = getDataTable(this.${className?uncap_first}Service.find${className}s(request, ${className?uncap_first}));
return R.ok(dataTable);
}

@PostMapping("${className?uncap_first}")
@ResponseBody
public R add${className}(@Valid ${className} ${className?uncap_first}) throws BusinessException {
try {
this.${className?uncap_first}Service.create${className}(${className?uncap_first});
return R.ok();
} catch (Exception e) {
String message = "新增${className}失败";
log.error(message, e);
throw new BusinessException(message);
}
}

@GetMapping("${className?uncap_first}/delete")
@ResponseBody
public R delete${className}(${className} ${className?uncap_first}) throws BusinessException {
try {
this.${className?uncap_first}Service.delete${className}(${className?uncap_first});
return R.ok();
} catch (Exception e) {
String message = "删除${className}失败";
log.error(message, e);
throw new BusinessException(message);
}
}

@PostMapping("${className?uncap_first}/update")
@ResponseBody
public R update${className}(${className} ${className?uncap_first}) throws BusinessException {
try {
this.${className?uncap_first}Service.update${className}(${className?uncap_first});
return R.ok();
} catch (Exception e) {
String message = "修改${className}失败";
log.error(message, e);
throw new BusinessException(message);
}
}

@PostMapping("${className?uncap_first}/excel")
@ResponseBody
public void export(QueryRequest queryRequest, ${className} ${className?uncap_first}, HttpServletResponse response) throws BusinessException {
//TODO 模板名称需根据实际情况配置
String templateName = "";
ClassPathResource classPathResource = new ClassPathResource(templateName);
TemplateExportParams params = new TemplateExportParams(classPathResource.getPath());
//TODO LambdaQueryWrapper 根据需求构建
    List<${className}> ${className?uncap_first}s = this.${className?uncap_first}Service.find${className}s(queryRequest, ${className?uncap_first}).getRecords();

        //TODO ${className} 转换为模板实际需要的数据类型
        Map<String, Object> data = new HashMap<>();

        //获取workbook
        Workbook workbook = ExcelExportUtil.exportExcel(params, data);
        //TODO 下载文件名 需根据实际情况设置
        String fileName = "";
        //TODO 文件导出
        //        ReportUtil.export(response, workbook, fileName);
}
}
