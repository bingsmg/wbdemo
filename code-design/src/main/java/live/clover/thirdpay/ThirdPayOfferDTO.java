package live.clover.thirdpay;

import java.math.BigDecimal;

/**
 * 第三方支付显示规则-销售品明细 DTO
 * @author weibb
 * @date 2023-08-23
 */
public class ThirdPayOfferDTO {
    private Long id;
    private Integer displayRuleId;
    private Integer companyId;
    private Integer partnerId;
    private Integer offerId;
    private Integer pricePlanId;
    private Integer rateId;
    private BigDecimal amount;
    private Integer billingCycle;
    private Integer billingDuration;
    private String basicOfferDisplayName;
    private String rateDisplayName;
    private String rateDesc;
}
