package live.clover;

import live.clover.parse.RuleAssembler;
import live.clover.parse.RuleTempalteKeyEnum;

import static live.clover.parse.RuleTempalteKeyEnum.BASIC_OFFER_DISPLAY_NAME;
/**
 * @author weibb
 * @date 2023-08-23
 */
public class Main {

    private final RuleAssembler ruleAssembler;

    public Main(RuleAssembler ruleAssembler) {
        this.ruleAssembler = ruleAssembler;
    }

    public static void main(String[] args) {
        RuleTempalteKeyEnum type = BASIC_OFFER_DISPLAY_NAME;
        String template = "Package {rate_amount} ({billing_cycle}/{billing_duration})";
        String name = "demo";
        System.out.println(BASIC_OFFER_DISPLAY_NAME.convertLower());
        System.out.println("Hello world!");

    }

    public void precess(String name) {
        RuleTempalteKeyEnum type = BASIC_OFFER_DISPLAY_NAME;
        String template = "Package {rate_amount} ({billing_cycle}/{billing_duration})";
        System.out.println(BASIC_OFFER_DISPLAY_NAME.convertLower());
        System.out.println("Hello world!");

    }
}