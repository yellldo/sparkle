package ${package.Service};

import ${package.Entity}.${entity};

import com.rrtx.fap.starter.mybatis.plus.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;



import java.util.List;

/**
 * ClassName: I${entity}Service<br>
 * Description: ${entity}Service接口 <br>
 * Company: rrtx
 *
 * @author ${author}
 * @version v1.0.0    ${date}  ${author}    由Generator自动创建
 */
public interface I${entity}Service extends IService<${entity}> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param wrapper LambdaQueryWrapper<${entity}>
     * @return IPage<${entity}>
     */
    IPage<${entity}> find${entity}s(QueryRequest request, LambdaQueryWrapper<${entity}> wrapper);

    /**
     * 查询（所有）
     *
     * @param wrapper LambdaQueryWrapper<${entity}>
     * @return List<${entity}>
     */
    List<${entity}> find${entity}s(LambdaQueryWrapper<${entity}> wrapper);

    /**
     * 新增
     *
     * @param ${entity?uncap_first} ${entity?uncap_first}
     */
    void create${entity}(${entity} ${entity?uncap_first});

    /**
     * 修改
     *
     * @param ${entity?uncap_first} ${entity?uncap_first}
     */
    void update${entity}(${entity} ${entity?uncap_first});

    /**
     * 删除
     *
     * @param wrapper LambdaQueryWrapper<${entity}>
     */
    void delete${entity}(LambdaQueryWrapper<${entity}> wrapper);
}
