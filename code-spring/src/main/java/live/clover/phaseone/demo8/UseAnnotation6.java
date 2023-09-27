package live.clover.phaseone.demo8;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author weibb
 * @date 2023-09-27
 */
@Ann6(value = "用在类上", elementType = ElementType.TYPE)
public class UseAnnotation6 {
    @Ann6(value = "用在字段上", elementType = ElementType.FIELD)
    private String a;
    @Ann6(value = "用在构造方法", elementType = ElementType.CONSTRUCTOR)
    public UseAnnotation6(@Ann6(value = "用在方法参数", elementType = ElementType.PARAMETER) String a) {
        this.a = a;
    }
    // 本地变量，即在方法里定义的变量
    public void m1() {
        @Ann6(value = "用在本地变量上", elementType = ElementType.LOCAL_VARIABLE)
        String name = "demo";
    }
}

@Target(value = {
        ElementType.TYPE,
        ElementType.METHOD,
        ElementType.FIELD,
        ElementType.PARAMETER,
        ElementType.CONSTRUCTOR,
        ElementType.LOCAL_VARIABLE
})
@Retention(RetentionPolicy.RUNTIME)
@interface Ann6 {
    String value();

    ElementType elementType();
}
