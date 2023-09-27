package live.clover.phaseone.demo3;

import org.springframework.beans.factory.DisposableBean;

/**
 * @author weibb
 * @date 2023-09-27
 */
public class NormalBean {

    public static class Bean1 implements DisposableBean {

        public Bean1() {
            System.out.println(this.getClass() + " constructor1");
        }

        @Override
        public void destroy() throws Exception {
            System.out.println(this.getClass() + " destroy()");
        }
    }

    public static class Bean2 implements DisposableBean {

        public Bean2() {
            System.out.println(this.getClass() + " constructor2");
        }

        public Bean2(Bean1 bean1) {
            System.out.println(this.getClass() + " constructor2");
        }

        @Override
        public void destroy() throws Exception {
            System.out.println(this.getClass() + " destroy()");

        }
    }
}
