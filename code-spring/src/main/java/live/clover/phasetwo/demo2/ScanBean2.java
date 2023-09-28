package live.clover.phasetwo.demo2;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 指定包名的方式扫描会有一些隐患，若包被重名了，引入 jar 包那种，会导致扫描失败，一般情况我们可以
 * 使用 basePackageClasses 的方式来指定需要扫描的包，这个参数可以指定一些类型，默认会扫描这些类
 * 所在的包及包中的所有类，这种方式可以有效避免这种问题。
 *
 * @author weibb
 * @date 2023-09-28
 */
@ComponentScan({
        "live.clover.phasetwo.demo2.controller",
        "live.clover.phasetwo.demo2.service"
})
public class ScanBean2 {

    @Test
    void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScanBean2.class);
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName + " -> " + context.getBean(beanDefinitionName));
        }
    }
}
