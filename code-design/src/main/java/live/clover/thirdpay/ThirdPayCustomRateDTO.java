package live.clover.thirdpay;

import java.math.BigDecimal;

/**
 * 第三方支付显示规则-自定义资费 DTO
 * @author weibb
 * @date 2023-08-23
 */
public class ThirdPayCustomRateDTO {
    private Long id;
    private Integer displayRuleId;
    private Integer companyId;
    private Integer offerId;
    private BigDecimal amount;
    private Integer billingCycle;
    private Integer billingDuration;
    private ReplaceRateEnum replaceRateItem;
}
