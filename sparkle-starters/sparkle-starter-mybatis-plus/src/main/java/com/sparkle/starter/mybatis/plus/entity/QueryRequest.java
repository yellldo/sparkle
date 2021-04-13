package com.sparkle.starter.mybatis.plus.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * ClassName : QueryRequest<br>
 * Description : QueryRequest<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/4/13
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class QueryRequest implements Serializable {

    private static final long serialVersionUID = -4869594085374385813L;
    /**
     * 当前页面数据量
     */
    private int pageSize = 10;
    /**
     * 当前页码
     */
    private int pageNum = 1;
    /**
     * 排序字段
     */
    private String field;
    /**
     * 排序规则，asc升序，desc降序
     */
    private String order;

    public QueryRequest(int pageSize, int pageNum) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

}
