package live.clover.phasetwo.demo4;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * 目前已知的批量注册 bean 的方式有：1，@Configuration 结合 @Bean 注解的方式；2，@ComponentScan
 * 扫描包的方式，如果需要注册的类在 第三方 jar 里，那些类没有标明 @Component，所以 @ComponentScan
 * 是无能为力的，那么必须自定义 @ComponentScan 中的过滤器来实现。或者用 @Bean 标注方法一个一个创建
 * 这两种方法在有变化的时候，都需要调整很多代码，并不是很好。
 * 所以基于此，我们有 @Import 注解来帮忙扫描注册 bean。可以用来批量导入需要注册的各种类，如普通的类，配置类
 * 完后完成普通类和配置类中 bean 的注册。
 *
 * @author weibb
 * @date 2023-09-28
 */
@Import({Service1.class, Service2.class})
public class MainConfig1 {


    @Test
    void test1() {
        //1.通过AnnotationConfigApplicationContext创建spring容器，参数为@Import标注的类
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig1.class);
        //2.输出容器中定义的所有bean信息
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(String.format("%s->%s", beanName, context.getBean(beanName)));
        }
    }
}
