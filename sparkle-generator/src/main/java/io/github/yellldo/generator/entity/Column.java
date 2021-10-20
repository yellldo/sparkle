package io.github.yellldo.generator.entity;

import lombok.Data;

/**
 * ClassName : Column<br>
 * Description : Column<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/4/22
 */
@Data
public class Column {

    /**
     * 名称
     */
    private String name;

    /**
     * 是否为主键
     */
    private boolean isKey;

    /**
     * 类型
     */
    private String type;

    /**
     * 备注
     */
    private String remark;

    /**
     * 属性名称
     */
    private String field;
}
