package live.clover.phasetwo.demo1;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author weibb
 * @date 2023-09-27
 */
@Configuration //configBean: live.clover.phasetwo.demo1.ConfigBean$$EnhancerBySpringCGLIB$$509a79f6@15713d56
// Configuration // 不加 Configuration 时，生成的 Bean 是没有被 EnhancerSpringCGLib 代理的 configBean: live.clover.phasetwo.demo1.ConfigBean@536dbea0
public class ConfigBean {

    @Bean
    public User user1() {
        return new User();
    }

    @Bean("user2Bean")
    public User user2() {
        return new User();
    }

    @Bean({"user3Bean", "user3BeanAlias1", "user3BeanAlias2"})
    public User user3() {
        return new User();
    }

    @Test
    void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigBean.class);
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.print(beanDefinitionName + ": ");
            System.out.println(context.getBean(beanDefinitionName));
            System.out.println(Arrays.toString(context.getAliases(beanDefinitionName)));
        }
    }
}
