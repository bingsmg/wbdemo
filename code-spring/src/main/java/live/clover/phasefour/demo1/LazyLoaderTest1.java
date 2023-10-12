package live.clover.phasefour.demo1;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.LazyLoader;

/**
 * @author weibb
 * @date 2023-10-11
 */
public class LazyLoaderTest1 {

    public static class UserModel {

        private String name;

        public UserModel(String name) {
            this.name = name;
        }

        public void say() {
            System.out.println("Hello! " + name);
        }
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserModel.class);
        LazyLoader lazyLoader = new LazyLoader() {
            @Override
            public Object loadObject() throws Exception {
                System.out.println("invoke LazyLoader.loadObject() method.");
                return new UserModel("clover");
            }
        };
        enhancer.setCallback(lazyLoader);
        Object proxy = enhancer.create();
        UserModel userModel = (UserModel) proxy;
        System.out.println("first invoke say method.");
        userModel.say();
        System.out.println("second invoke say method");
        userModel.say();


    }
}
