package live.clover.phasethree.demo1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author weibb
 * @date 2023-10-10
 */
public class InitMethodTest {

    @Test
    public void test1() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        AbstractBeanDefinition service = BeanDefinitionBuilder.genericBeanDefinition(Service.class)
                .setInitMethodName("init")
                .getBeanDefinition();
        factory.registerBeanDefinition("service", service);
        System.out.println(factory.getBean("service"));
    }
}
