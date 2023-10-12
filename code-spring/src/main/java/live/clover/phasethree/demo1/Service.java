package live.clover.phasethree.demo1;

import org.springframework.beans.factory.InitializingBean;

/**
 * @author weibb
 * @date 2023-10-10
 */
public class Service implements InitializingBean {

    public void init() {
        System.out.println("invoke init() method");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("invoke afterPropertiesSet() ");
    }
}
