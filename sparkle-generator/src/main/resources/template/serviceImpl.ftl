package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${entity}Mapper;
import ${package.Service}.I${entity}Service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.beans.factory.annotation.Autowired;
import com.rrtx.fap.starter.mybatis.plus.entity.QueryRequest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



import java.util.List;

/**
 * ClassName: ${entity}ServiceImpl<br>
 * Description: I${entity}Service实现 <br>
 * Company: rrtx
 *
 * @author ${author}
 * @version v1.0.0    ${date}  ${author}    由Generator自动创建
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ${entity}ServiceImpl extends ServiceImpl<${entity}Mapper, ${entity}> implements I${entity}Service {

    @Autowired
    private ${entity}Mapper ${entity?uncap_first}Mapper;

    @Override
    public IPage<${entity}> find${entity}s(QueryRequest request, LambdaQueryWrapper<${entity}> wrapper) {
        Page<${entity}> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, wrapper);
    }

    @Override
    public List<${entity}> find${entity}s(LambdaQueryWrapper<${entity}> wrapper) {
		return this.list(wrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create${entity}(${entity} ${entity?uncap_first}) {
        this.save(${entity?uncap_first});
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update${entity}(${entity} ${entity?uncap_first}) {
        this.saveOrUpdate(${entity?uncap_first});
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete${entity}(LambdaQueryWrapper<${entity}> wrapper) {
	    this.remove(wrapper);
	}
}
