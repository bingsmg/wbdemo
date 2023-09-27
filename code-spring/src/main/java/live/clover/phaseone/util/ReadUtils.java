package live.clover.phaseone.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author weibb
 * @date 2023-09-27
 */
public class ReadUtils {
    public static ClassPathXmlApplicationContext getContext(String xmlFileAddr) {
        return new ClassPathXmlApplicationContext(xmlFileAddr);
    }
}
