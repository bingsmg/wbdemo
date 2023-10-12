package live.clover.phasetwo.demo6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author weibb
 * @date 2023-10-09
 */
//@Conditional(MyCondition1.class)
@Configuration
public class MainConfig3 {

    @Bean
    public String name() {
        return "clover Java";
    }
}
