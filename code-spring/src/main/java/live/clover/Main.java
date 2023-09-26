package live.clover;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author weibb
 * @date 2023-09-26
 */
public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("beans.xml");
        String[] beanDefinitionNames = factory.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.print(beanDefinitionName + "####");
            System.out.println(factory.getBean(beanDefinitionName));
        }
    }
}