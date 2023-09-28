package live.clover.phasetwo.demo5;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author weibb
 * @date 2023-09-28
 */
@ComponentScan
@EnableMethodCostTime
public class MainConfig6 {


    @Test
    void test1() {
        //1.通过AnnotationConfigApplicationContext创建spring容器，参数为@Import标注的类
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig6.class);
        Service1 service1 = context.getBean(Service1.class);
        Service2 service2 = context.getBean(Service2.class);
        service1.m1();
        service2.m1();
    }
}
