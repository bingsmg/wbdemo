package live.clover.phasetwo.demo6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author weibb
 * @date 2023-10-09
 */
@Configuration
public class MainConfig4 {

    @Conditional(MyCondition1.class)
    @Bean
    public String name() {
        return "clover java";
    }

    @Bean
    public String address() {
        return "beijing";
    }
}
