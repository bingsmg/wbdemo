package live.clover.phasetwo.demo4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author weibb
 * @date 2023-09-28
 */
@Configuration
public class ConfigModule2 {

    @Bean
    public String module2() {
        return "我是模块2配置类！";
    }
}
