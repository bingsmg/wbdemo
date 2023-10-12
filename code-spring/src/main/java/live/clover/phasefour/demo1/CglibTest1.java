package live.clover.phasefour.demo1;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author weibb
 * @date 2023-10-11
 */
public class CglibTest1 {

    interface IService1 {
        void m1();
    }

    interface IService2 {
        void m2();
    }


    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setInterfaces(new Class[]{IService1.class, IService2.class});
        // 为什么叫 callback 呢？可以这么理解，代理类在什么时候执行？是你将它按照原对象的结构去调用的时候
        // 代理类的你的代理重写逻辑才会生效，所以其实就是一个回调的过程，当你执行那个方法的时候，回调生效，
        // 设置了回调方法，即代理了原来的方法。在调用原来的方法时回调代理
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("the method : " + method.getName());
                return null;
            }
        });

        Object proxy = enhancer.create();
        if (proxy instanceof IService1) {
            ((IService1)proxy).m1();
        }
        if (proxy instanceof IService2) {
            ((IService2)proxy).m2();
        }
        System.out.println(proxy.getClass());
        System.out.println("created proxy class has implement follow interfaces: ");
        for (Class<?> anInterface : proxy.getClass().getInterfaces()) {
            System.out.println(anInterface);
        }
    }
}
