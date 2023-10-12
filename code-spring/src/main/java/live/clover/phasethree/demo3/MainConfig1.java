package live.clover.phasethree.demo3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * @author weibb
 * @date 2023-10-10
 */
@Configuration
public class MainConfig1 {

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource result = new ResourceBundleMessageSource();
        result.setBasenames("live/message");
        return result;
    }
}
