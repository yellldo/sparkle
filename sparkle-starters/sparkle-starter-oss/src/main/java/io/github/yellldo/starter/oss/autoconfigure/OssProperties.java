package io.github.yellldo.starter.oss.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * ClassName : OssProperties<br>
 * Description : oss 配置<br>
 *
 * @author : sj
 * @date : 2021/12/28
 */
@Data
@ConfigurationProperties(prefix = "sparkle.cos")
public class OssProperties {


}
