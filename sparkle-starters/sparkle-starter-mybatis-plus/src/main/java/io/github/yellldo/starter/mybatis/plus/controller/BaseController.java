package io.github.yellldo.starter.mybatis.plus.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.yellldo.starter.mybatis.plus.service.IBaseService;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName : BaseController<br>
 * Description : 基础Controller<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/4/13
 */
public class BaseController<Service extends IBaseService, Entity, PK extends Serializable> {

    protected Map<String, Object> getDataTable(IPage<?> page) {
        Map<String, Object> map = new HashMap<>(4);
        map.put("rows", page.getRecords());
        map.put("total", page.getTotal());
        return map;
    }
}
