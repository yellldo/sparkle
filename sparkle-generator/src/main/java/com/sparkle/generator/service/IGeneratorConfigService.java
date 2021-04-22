package com.sparkle.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sparkle.generator.entity.GeneratorConfig;

/**
 * ClassName : IGeneratorConfigService<br>
 * Description : IGeneratorConfigService<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/4/22
 */
public interface IGeneratorConfigService extends IService<GeneratorConfig> {

    /**
     * 查询
     *
     * @return GeneratorConfig
     */
    GeneratorConfig findGeneratorConfig();

    /**
     * 修改
     *
     * @param generatorConfig generatorConfig
     */
    void updateGeneratorConfig(GeneratorConfig generatorConfig);

}
