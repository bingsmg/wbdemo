package live.clover.phasetwo.demo6;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author weibb
 * @date 2023-10-09
 */
@Configuration
@Import({BeanConfig1.class, BeanConfig2.class})
public class MainConfig1 {
}
