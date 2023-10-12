package live.clover.phasethree.demo2;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author weibb
 * @date 2023-10-10
 */
public class ValueTest {

    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig1.class);
        context.refresh();

        DBConfig dbConfig = context.getBean(DBConfig.class);
        System.out.println(dbConfig);
    }
}
