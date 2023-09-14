package live.clover.parse;

import java.util.Map;

/**
 * @author weibb
 * @date 2023-08-23
 */
public class OfferNameRuleTemplateParser implements TemplateParser {

    @Override
    public String parseTemplate(String template, Map<String, String> variables) {
        return parse(template, variables);
    }
}
