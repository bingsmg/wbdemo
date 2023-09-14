package live.clover.parse;

import java.util.Map;

/**
 * @author weibb
 * @date 2023-08-23
 */
public class RuleAssembler {
    private final TemplateParser templateParser;

    public RuleAssembler(TemplateParser templateParser) {
        this.templateParser = templateParser;
    }

    public String assembleRule(String template, Map<String, String> variables) {
        return templateParser.parseTemplate(template, variables);
    }
}
