package live.clover.phaseone.demo8;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @author weibb
 */
@Ann4(name = {"clover", "live", "yub"})
public class UseAnnotation4 {

    @Ann4(name = "只有一个值")
    public class T1 {

    }
}

/**
 * @author weibb
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Ann4 {
    String[] name();
}