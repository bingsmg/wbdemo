package live.clover.phasetwo.demo5;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author weibb
 * @date 2023-09-28
 */
public class MethodCostTimeProxyBPP implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().getName().toLowerCase().contains("service")) {
            return CostTimeProxy.createProxy(bean);
        } else {
            return bean;
        }
    }
}
