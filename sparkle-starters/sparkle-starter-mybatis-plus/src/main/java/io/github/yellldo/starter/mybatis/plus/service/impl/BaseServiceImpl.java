package io.github.yellldo.starter.mybatis.plus.service.impl;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.yellldo.starter.mybatis.plus.mapper.CommonMapper;
import io.github.yellldo.starter.mybatis.plus.service.IBaseService;
import io.github.yellldo.starter.mybatis.plus.util.ObjectMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * ClassName : BaseServiceImpl<br>
 * Description : TODO<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/4/13
 */
public class BaseServiceImpl<M extends CommonMapper<T>, T> extends ServiceImpl<M, T> implements IBaseService<T> {

    @Autowired
    protected M mapper;

    @Override
    public T selectOne(T entity) {
        QueryWrapper<T> queryWrapper = entity2QueryWrapper(entity);
        return mapper.selectOne(queryWrapper);
    }

    @Override
    public List<T> selectList(T entity) {
        QueryWrapper<T> queryWrapper = entity2QueryWrapper(entity);
        return mapper.selectList(queryWrapper);
    }

    @Override
    public List<T> selectListAll() {
        return mapper.selectList(new QueryWrapper<>());
    }

    @Override
    public Long selectCount(T entity) {
        QueryWrapper<T> queryWrapper = entity2QueryWrapper(entity);
        return new Long(mapper.selectCount(queryWrapper));
    }
    @Override
    public int insertSelective(T entity) {
        return mapper.insert(entity);
    }
    @Override
    public int delete(T entity) {
        QueryWrapper<T> queryWrapper = entity2QueryWrapper(entity);
        return mapper.delete(queryWrapper);
    }
    @Override
    public int updateSelectiveById(T entity) {
        return mapper.updateById(entity);

    }
    @Override
    public IPage<T> selectPage(IPage<T> page, T entity){
        QueryWrapper<T> queryWrapper = entity2QueryWrapper(entity);
        return mapper.selectPage(page, queryWrapper);
    }

    /**
     * mybatis-plus 不支持联合主键 Deprecated此方法
     * @param entity
     * @return
     */
    @Override
    public boolean saveOrUpdate(T entity){
        return super.saveOrUpdate(entity);
    }

    protected QueryWrapper<T> entity2QueryWrapper(T entity) {
        String entityString = ObjectMapperUtil.toJsonString(entity);
        Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        T queryEntity = JSONUtil.toBean(entityString, entityClass);
        return new QueryWrapper<>(queryEntity);
    }
}
