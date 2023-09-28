package live.clover.phasetwo.demo1;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * 被 @Configuration 修饰的类，spring 容器中会通过 cglib 给这个类创建一个代理，代理会拦截所有被 @Bean 修饰的方法，
 * 默认情况下（bean 为单例）下确保这些方法只被调用一次，从而确保这些 bean 是同一个 bean，即单例的。
 *
 * 不管 @Bean 所在的类是否有 @Configuration 注解，都可以将 @Bean 修饰的方法作为一个 bean 注册到 spring 容器中。
 *
 * @author weibb
 * @date 2023-09-28
 */
@Configuration
public class ConfigBean2 {

    @Bean
    public ServiceA serviceA() {
        System.out.println("invoke serviceA() method");
        return new ServiceA();
    }

    @Bean
    public ServiceB serviceB() {
        System.out.println("invoke serviceB() method");
        return new ServiceB(this.serviceA());
    }

    @Bean
    ServiceB serviceB2() {
        System.out.println("invoke serviceB2() method");
        return new ServiceB(this.serviceA());
    }

    @Test
    void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigBean2.class);
        for (String beanName : context.getBeanDefinitionNames()) {
            //别名
            String[] aliases = context.getAliases(beanName);
            System.out.printf("bean名称:%s,别名:%s,bean对象:%s%n",
                    beanName,
                    Arrays.asList(aliases),
                    context.getBean(beanName));
        }
    }
}
