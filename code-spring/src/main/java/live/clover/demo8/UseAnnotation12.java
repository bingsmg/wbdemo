package live.clover.demo8;

import java.lang.annotation.*;

/**
 * @author weibb
 * @date 2023-09-27
 */
@Ann12
@Ann12
public class UseAnnotation12 {

}



@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
// 为注解指定容器
// 注解定义无法被继承，所以可用 @AliasFor 注解解决该问题
@Repeatable(Ann12s.class)
@interface Ann12 {}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
@interface Ann12s {
    Ann12[] value();
}