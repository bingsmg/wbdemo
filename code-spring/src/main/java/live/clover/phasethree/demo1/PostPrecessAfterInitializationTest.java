package live.clover.phasethree.demo1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author weibb
 * @date 2023-10-10
 */
public class PostPrecessAfterInitializationTest {

    @Test
    public void test1() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        factory.addBeanPostProcessor(new BeanPostProcessor() {
            @Override
            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                System.out.println("postProcessAfterInitialization: " + beanName);
                return bean;
            }
        });

        factory.registerBeanDefinition("name", BeanDefinitionBuilder
                .genericBeanDefinition(String.class)
                .addConstructorArgValue("clover")
                .getBeanDefinition());

        factory.registerBeanDefinition("personInformation", BeanDefinitionBuilder
                .genericBeanDefinition(String.class)
                .addConstructorArgValue("live")
                .getBeanDefinition());

        System.out.println("print bean infos: ");
        for (String beanDefinitionName : factory.getBeanDefinitionNames()) {
            System.out.println(String.format("%s->%s", beanDefinitionName, factory.getBean(beanDefinitionName)));
        }
    }
}
