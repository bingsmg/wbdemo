package live.clover.parse;

/**
 * 第三方支付产品规则模版通配符枚举类
 * @author weibb
 * @date 2023-08-23
 */
public enum RuleTempalteKeyEnum {
    /**
     * 基本销售品的对外显示名称
     */
    BASIC_OFFER_DISPLAY_NAME,
    /**
     * 基本销售品的价格计划的资费的资费金额
     */
    RATE_AMOUNT,
    /**
     * 国家的货币代码
     */
    CURRENCY_CODE,
    /**
     * 国家的货币符号
     */
    CURRENCY_SYMBOL,
    /**
     * 基本销售品的价格计划的资费的计费时长
     */
    BILLING_DURATION,
    /**
     * 基本销售品的价格计划的资费的计费周期
     */
    BILLING_CYCLE,
    /**
     * 可更换产品的产品编码
     */
    PRODUCT_CODE,
    /**
     * 可更换产品的对外显示名称
     */
    PRODUCT_DISPLAY_NAME,
    /**
     * 可更换产品的产品编码描述
     */
    PRODUCT_DESCRIPTION;

    public String convertLower() {
        return this.name().toLowerCase();
    }
}
