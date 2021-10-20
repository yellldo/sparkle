package io.github.yellldo.generator.controller;

import io.github.yellldo.core.entity.R;
import io.github.yellldo.core.exception.base.BusinessException;
import io.github.yellldo.generator.entity.GeneratorConfig;
import io.github.yellldo.generator.service.IGeneratorConfigService;
import io.github.yellldo.starter.mybatis.plus.controller.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
 * ClassName : GeneratorConfigController<br>
 * Description : TODO<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/4/22
 */
@Slf4j
@RestController
@RequestMapping("generatorConfig")
public class GeneratorConfigController extends BaseController {

    @Autowired
    private IGeneratorConfigService generatorConfigService;

    @GetMapping
    public R getGeneratorConfig() {
        return R.ok().data(generatorConfigService.findGeneratorConfig());
    }

    @PostMapping("update")
    public R updateGeneratorConfig(@Valid GeneratorConfig generatorConfig) throws BusinessException {
        try {
            if (StringUtils.isBlank(generatorConfig.getId())) {
                throw new BusinessException("配置id不能为空");
            }
            this.generatorConfigService.updateGeneratorConfig(generatorConfig);
            return R.ok();
        } catch (Exception e) {
            String message = "修改GeneratorConfig失败";
            log.error(message, e);
            throw new BusinessException(message);
        }
    }

}
