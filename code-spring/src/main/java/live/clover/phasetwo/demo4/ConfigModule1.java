package live.clover.phasetwo.demo4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author weibb
 * @date 2023-09-28
 */
@Configuration
public class ConfigModule1 {

    @Bean
    public String module1() {
        return "我是模块一配置类";
    }
}
