package live.clover.phasetwo.demo6;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * 配置类的加载过程有两个：配置类解析阶段和 Bean 注册阶段，条件判断默认会在两者都生效
 * @author weibb
 * @date 2023-10-09
 */
public class ConditionTest {

    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig3.class);
        Map<String, String> serviceMap = context.getBeansOfType(String.class);
        serviceMap.forEach((beanName, bean) -> System.out.println(String.format("%s -> %s", beanName, bean)));
    }

    @Test
    public void test2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig4.class);
        Map<String, String> serviceMap = context.getBeansOfType(String.class);
        serviceMap.forEach((beanName, bean) -> System.out.println(String.format("%s -> %s", beanName, bean)));
    }

    @Test
    public void test3() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig1.class);
        Map<String, IService> serviceMap = context.getBeansOfType(IService.class);
        serviceMap.forEach((beanName, bean) -> System.out.println(String.format("%s -> %s", beanName, bean)));
    }
}
