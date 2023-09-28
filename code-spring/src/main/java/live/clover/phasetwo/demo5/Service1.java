package live.clover.phasetwo.demo5;

import org.springframework.stereotype.Service;

/**
 * @author weibb
 * @date 2023-09-28
 */
@Service
public class Service1 {

    public void m1() {
        System.out.println(this.getClass() + ".m1()");
    }
}
