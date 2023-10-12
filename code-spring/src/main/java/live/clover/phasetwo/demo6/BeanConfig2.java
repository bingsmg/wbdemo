package live.clover.phasetwo.demo6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author weibb
 * @date 2023-10-09
 */
@Configuration
public class BeanConfig2 {

    @Conditional(OnMissingBeanCondition.class)
    @Bean
    public IService service2() {
        return new Service2();
    }
}
