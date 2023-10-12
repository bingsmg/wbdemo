package live.clover.phasetwo.demo6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author weibb
 * @date 2023-10-09
 */
@Configuration
public class BeanConfig1 {

    @Conditional(OnMissingBeanCondition.class)
    @Bean
    public IService service1() {
        return new Service1();
    }
}
