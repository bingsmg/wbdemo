package live.clover.phasethree.demo5;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author weibb
 * @date 2023-10-10
 */
public class CircularDepencyTest {

    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        Object serviceA = context.getBean("serviceA");
        Object serviceB = context.getBean("serviceB");
        System.out.println(serviceB);
        System.out.println(serviceA);
    }
}
