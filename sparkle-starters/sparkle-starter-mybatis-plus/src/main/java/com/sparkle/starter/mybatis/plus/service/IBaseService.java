package com.sparkle.starter.mybatis.plus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * ClassName : IBaseService<br>
 * Description : 公共service<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/4/13
 */
public interface IBaseService<T> extends IService<T> {

    /**
     * 查询单个实体
     *
     * @param entity
     * @return
     */
    T selectOne(T entity);

    /**
     * 根据实体查集合
     *
     * @param entity
     * @return
     */
    List<T> selectList(T entity);

    /**
     * 查询所有
     *
     * @return
     */
    List<T> selectListAll();

    /**
     * count
     *
     * @param entity
     * @return
     */
    Long selectCount(T entity);

    /**
     * 插入实体
     *
     * @param entity
     * @return
     */
    int insertSelective(T entity);

    /**
     * 删除
     *
     * @param entity
     * @return
     */
    int delete(T entity);

    /**
     * 更新
     * mybatis-plus 不支持联合主键 Deprecated此方法 在使用联合主键时会存在问题
     *
     * @param entity
     * @return
     */
    int updateSelectiveById(T entity);

    /**
     * 查询分页
     *
     * @param page
     * @param entity
     * @return
     */
    IPage<T> selectPage(IPage<T> page, T entity);
}
