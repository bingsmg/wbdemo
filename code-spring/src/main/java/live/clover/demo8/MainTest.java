package live.clover.demo8;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.TypeVariable;

/**
 * @author weibb
 * @date 2023-09-27
 */
class MainTest {

    @Test
    void test1() {
        Annotation[] annotations = UseAnnotation6.class.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }

    @Test
    void test2() {
        TypeVariable<Class<UseAnnotation7>>[] typeParameters = UseAnnotation7.class.getTypeParameters();
        for (TypeVariable<Class<UseAnnotation7>> typeParameter : typeParameters) {
            System.out.println(typeParameter.getName() + "变量类型的注解信息");
            Annotation[] annotations = typeParameter.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }
        }
    }

    @Test
    void test3() throws NoSuchFieldException {
        Field name = UseAnnotation7.class.getDeclaredField("name");
        Annotation[] declaredAnnotations = name.getDeclaredAnnotations();
        for (Annotation declaredAnnotation : declaredAnnotations) {
            System.out.println(declaredAnnotation);
        }
    }
}
