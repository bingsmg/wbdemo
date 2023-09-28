package live.clover.phasetwo.demo5;

import org.springframework.stereotype.Service;

/**
 * @author weibb
 * @date 2023-09-28
 */
@Service
public class Service2 {

    private Service1 service1;

    public void m1() {
        System.out.println(this.getClass() + ".m1()");
    }

    public Service1 getService1() {
        return service1;
    }

    public void setService1(Service1 service1) {
        this.service1 = service1;
    }

    @Override
    public String toString() {
        return "Service2{" +
                "service1=" + service1 +
                '}';
    }
}
