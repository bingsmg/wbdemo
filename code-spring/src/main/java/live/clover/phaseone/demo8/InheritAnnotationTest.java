package live.clover.phaseone.demo8;

import java.lang.annotation.*;

/**
 * @author weibb
 * @date 2023-09-27
 */
public class InheritAnnotationTest {
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Inherited
    @interface A1{ //@1
    }
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Inherited
    @interface A2{ //@2
    }

    @A1 //@3
    interface I1{}
    @A2 //@4
    static class C1{}

    static class C2 extends C1 implements I1{} //@5

    public static void main(String[] args) {
        for (Annotation annotation : C2.class.getAnnotations()) { //@6
            System.out.println(annotation);
        }
    }
}
