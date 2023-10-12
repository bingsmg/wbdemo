package live.clover.phasethree.demo3;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author weibb
 * @date 2023-10-10
 */
public class MessageSourceTest {

    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig1.class);
        context.refresh();

        System.out.println(context.getMessage("name", null, null));
    }
}
