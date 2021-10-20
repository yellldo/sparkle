package io.github.yellldo.generator.entity;

import lombok.Data;

/**
 * ClassName : Table<br>
 * Description : Table<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/4/22
 */
@Data
public class Table {

    /**
     * 名称
     */
    private String name;

    /**
     * 备注
     */
    private String remark;

    /**
     * 数据量
     */
    private Long dataRows;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 修改时间
     */
    private String updateTime;

}
