package com.sparkle.generator.common.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sparkle.generator.constant.Constant;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName : BaseController<br>
 * Description : TODO<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/4/22
 */
public class BaseController {

    protected Map<String, Object> getDataTable(IPage<?> pageInfo) {
        return getDataTable(pageInfo, Constant.DATA_MAP_INITIAL_CAPACITY);
    }

    protected Map<String, Object> getDataTable(IPage<?> pageInfo, int dataMapInitialCapacity) {
        Map<String, Object> data = new HashMap<>(dataMapInitialCapacity);
        data.put("rows", pageInfo.getRecords());
        data.put("total", pageInfo.getTotal());
        return data;
    }
}
