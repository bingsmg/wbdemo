package live.clover.phasetwo.demo3;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author weibb
 * @date 2023-09-28
 */
@ComponentScan(basePackageClasses = ScanClass.class)
public class ScanClassTest {

    @Test
    void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScanClassTest.class);
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName + "->" + context.getBean(beanName));
        }
    }
}
