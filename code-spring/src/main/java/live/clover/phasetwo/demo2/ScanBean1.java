package live.clover.phasetwo.demo2;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author weibb
 * @date 2023-09-28
 */
@ComponentScan
public class ScanBean1 {

    @Test
    void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScanBean1.class);
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName + "-> " + context.getBean(beanDefinitionName));
        }
    }
}
