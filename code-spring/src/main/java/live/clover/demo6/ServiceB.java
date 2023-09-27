package live.clover.demo6;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author weibb
 * @date 2023-09-27
 */
class ServiceB implements ApplicationContextAware {

    private ServiceA serviceA;

    public ServiceA getServiceA() {
        return null;
    }

    public void say() {
        ServiceA serviceA1 = this.getServiceA();
        System.out.println("this: " + this + ", serviceA: " + serviceA1);
    }

    public void setServiceA(ServiceA serviceA) {
        this.serviceA = serviceA;
    }

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
