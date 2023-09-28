package live.clover.phasetwo.demo5;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author weibb
 * @date 2023-09-28
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        AbstractBeanDefinition service1Definition = BeanDefinitionBuilder.genericBeanDefinition(Service1.class).getBeanDefinition();
        registry.registerBeanDefinition("service1", service1Definition);
        AbstractBeanDefinition service2Definition = BeanDefinitionBuilder.genericBeanDefinition(Service2.class)
                .addPropertyReference("service1", "service1")
                .getBeanDefinition();
        registry.registerBeanDefinition("service2", service2Definition);
    }
}
