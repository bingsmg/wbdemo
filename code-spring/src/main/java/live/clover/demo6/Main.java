package live.clover.demo6;

import live.clover.util.ReadUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author weibb
 * @date 2023-09-26
 */
class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext factory = ReadUtils.getContext("beans.xml");
        System.out.println("Spring application start finished.");

        System.out.println(factory.getBean(ServiceA.class));
        System.out.println(factory.getBean(ServiceB.class));

        System.out.println("ServiceB 中的 ServiceA");
        System.out.println(factory.getBean(ServiceB.class).getServiceA());
        System.out.println(factory.getBean(ServiceB.class).getServiceA());
        ServiceB bean = factory.getBean(ServiceB.class);
        bean.say();
        bean.say();
        factory.close();
    }
}