package com.sparkle.generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sparkle.generator.entity.GeneratorConfig;
import com.sparkle.generator.mapper.GeneratorConfigMapper;
import com.sparkle.generator.service.IGeneratorConfigService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName : GeneratorConfigServiceImpl<br>
 * Description : GeneratorConfigServiceImpl<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/4/22
 */
@Service
public class GeneratorConfigServiceImpl extends ServiceImpl<GeneratorConfigMapper, GeneratorConfig> implements IGeneratorConfigService {


    @Override
    public GeneratorConfig findGeneratorConfig() {
        List<GeneratorConfig> list = this.baseMapper.selectList(null);
        return CollectionUtils.isNotEmpty(list) ? list.get(0) : null;
    }

    @Override
    public void updateGeneratorConfig(GeneratorConfig generatorConfig) {
        this.saveOrUpdate(generatorConfig);
    }
}
