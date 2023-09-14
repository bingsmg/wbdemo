package live.clover.parse;

import java.util.Map;

/**
 * @author weibb
 * @date 2023-08-23
 */
public interface TemplateParser {

    String parseTemplate(String template, Map<String, String> variables);

    default String parse(String template, Map<String, String> variables) {
        for (Map.Entry<String, String> entry : variables.entrySet()) {
            String placeholder = "{" + entry.getKey() + "}";
            String replacement = entry.getValue();
            template = template.replace(placeholder, replacement);
        }
        return template;
    }
}
