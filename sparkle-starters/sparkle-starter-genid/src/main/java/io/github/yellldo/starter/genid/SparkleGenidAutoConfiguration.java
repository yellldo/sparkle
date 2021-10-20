package io.github.yellldo.starter.genid;

import io.github.yellldo.starter.genid.configuration.GenidConfiguration;
import io.github.yellldo.starter.genid.service.IdService;
import io.github.yellldo.starter.genid.service.impl.IdServiceImpl;
import io.github.yellldo.starter.genid.service.impl.converter.IdConverter;
import io.github.yellldo.starter.genid.service.impl.converter.IdConverterImpl;
import io.github.yellldo.starter.genid.service.impl.populater.AtomicIdPopulator;
import io.github.yellldo.starter.genid.service.impl.populater.IdPopulator;
import io.github.yellldo.starter.genid.service.impl.populater.LockIdPopulator;
import io.github.yellldo.starter.genid.service.impl.populater.SyncIdPopulator;
import io.github.yellldo.starter.genid.service.impl.timer.SimpleTimer;
import io.github.yellldo.starter.genid.service.impl.timer.Timer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName : SparkleGenidAutoConfiguration<br>
 * Description : 分布式id自动配置<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/4/15
 */
@Slf4j
@Configuration
@EnableConfigurationProperties({GenidConfiguration.class})
public class SparkleGenidAutoConfiguration {


    @Autowired
    private GenidConfiguration genidConfiguration;

    @Bean
    @ConditionalOnMissingBean(IdConverter.class)
    public IdConverter idConverter() {
        return new IdConverterImpl();
    }

    @Bean
    @ConditionalOnMissingBean(Timer.class)
    public Timer timer() {
        return new SimpleTimer();
    }

    @Bean
    @ConditionalOnMissingBean(IdPopulator.class)
    public IdPopulator idPopulator() {
        if (genidConfiguration.getLockType() == 0) {
            log.info("The default LockIdPopulator is used.");
            return new LockIdPopulator();
        } else if (genidConfiguration.getLockType() == 1) {
            log.info("The SyncIdPopulator is used.");
            return new SyncIdPopulator();
        } else if (genidConfiguration.getLockType() == 2) {
            log.info("The AtomicIdPopulator is uesd.");
            return new AtomicIdPopulator();
        }
        throw new IllegalStateException("the config locktype " + genidConfiguration.getLockType() + "is not in value 0,1,2");
    }


    @Bean
    @ConditionalOnMissingBean(IdService.class)
    public IdService idService(IdConverter idConverter, Timer timer, IdPopulator idPopulator) {
        return new IdServiceImpl(idConverter, timer, genidConfiguration, idPopulator);
    }

}
