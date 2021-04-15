package ${package.Entity};

<#--<#if table.hasDate>-->
<#--import java.util.Date;-->
<#--</#if>-->
<#--<#if table.hasBigDecimal>-->
<#--import java.math.BigDecimal;-->
<#--</#if>-->

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * ClassName: ${entity}<br>
 * Description: ${entity} Entity <br>
 * Company: rrtx
 *
 * @author ${author}
 * @version v1.0.0    ${date}  ${author}    由Generator自动创建
 */
@Data
@TableName("${table.name}")
public class ${entity} {

<#if table.fields??>
    <#list table.fields as field>
    /**
     * ${field.comment}
     */
        <#if field.keyFlag>
    @TableId(value = "${field.name}", type = IdType.AUTO)
        <#else>
    @TableField("${field.name}")
        </#if>
    private ${field.propertyType} ${field.propertyName?uncap_first};
    </#list>
</#if>
}