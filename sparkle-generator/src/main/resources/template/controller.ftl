package ${package.Controller};

import com.rrtx.fap.starter.mybatis.plus.controller.BaseController;
import com.rrtx.fap.core.entity.R;
import com.rrtx.fap.starter.mybatis.plus.entity.QueryRequest;
import com.rrtx.fap.core.exception.base.BusinessException;
import ${package.Entity}.${entity};
import ${package.Service}.I${entity}Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import org.apache.poi.ss.usermodel.Workbook;
import cn.hutool.core.io.resource.ClassPathResource;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;




import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * ClassName: ${entity}Controller<br>
 * Description: ${entity} Controller <br>
 * Company: rrtx
 *
 * @author ${author}
 * @version v1.0.0    ${date}  ${author}    由Generator自动创建
 */
@Slf4j
@RestController
public class ${entity}Controller extends BaseController {

    @Autowired
    private I${entity}Service ${entity?uncap_first}Service;

    @GetMapping("${entity?uncap_first}")
    public R getAll${entity}s(${entity} ${entity?uncap_first}) {
        //TODO LambdaQueryWrapper 根据需求构建
        LambdaQueryWrapper<${entity}> queryWrapper = new LambdaQueryWrapper();
        return R.ok(${entity?uncap_first}Service.find${entity}s(queryWrapper));
    }

    @GetMapping("${entity?uncap_first}/list")
    public R ${entity?uncap_first}List(QueryRequest request, ${entity} ${entity?uncap_first}) {
        //TODO LambdaQueryWrapper 根据需求构建
        LambdaQueryWrapper<${entity}> queryWrapper = new LambdaQueryWrapper();
        Map<String, Object> dataTable = getDataTable(this.${entity?uncap_first}Service.find${entity}s(request, queryWrapper));
        return R.ok(dataTable);
    }

    @PostMapping("${entity?uncap_first}")
    public R add${entity}(@Valid ${entity} ${entity?uncap_first}) throws BusinessException {
        this.${entity?uncap_first}Service.create${entity}(${entity?uncap_first});
        return R.ok();
    }

    @GetMapping("${entity?uncap_first}/delete")
    public R delete${entity}(${entity} ${entity?uncap_first}) throws BusinessException {
        //TODO LambdaQueryWrapper 根据需求构建
        LambdaQueryWrapper<${entity}> queryWrapper = new LambdaQueryWrapper();
        this.${entity?uncap_first}Service.delete${entity}(queryWrapper);
        return R.ok();
    }

    @PostMapping("${entity?uncap_first}/update")
    public R update${entity}(${entity} ${entity?uncap_first}) throws BusinessException {
        this.${entity?uncap_first}Service.update${entity}(${entity?uncap_first});
        return R.ok();
    }

    @PostMapping("${entity?uncap_first}/excel")
    public void export(QueryRequest queryRequest, ${entity} ${entity?uncap_first}, HttpServletResponse response) throws BusinessException {

        //TODO 模板名称需根据实际情况配置
        String templateName = "";
        ClassPathResource classPathResource = new ClassPathResource(templateName);
        TemplateExportParams params = new TemplateExportParams(classPathResource.getPath());

        //TODO LambdaQueryWrapper 根据需求构建
        LambdaQueryWrapper<${entity}> queryWrapper = new LambdaQueryWrapper();
        List<${entity}> ${entity?uncap_first}s = this.${entity?uncap_first}Service.find${entity}s(queryRequest, queryWrapper).getRecords();

        //TODO ${entity?uncap_first}s 转换为模板实际需要的数据类型
        Map<String, Object> data = new HashMap<>();

        //获取workbook
        Workbook workbook = ExcelExportUtil.exportExcel(params, data);
        //TODO 下载文件名 需根据实际情况设置
        String fileName = "";
        //TODO 文件导出
        //        ReportUtil.export(response, workbook, fileName);

    }
}
