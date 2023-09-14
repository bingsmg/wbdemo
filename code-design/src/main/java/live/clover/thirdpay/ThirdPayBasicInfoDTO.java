package live.clover.thirdpay;

/**
 * @author weibb
 * @date 2023-08-23
 */
public class ThirdPayBasicInfoDTO {
    private Long id;
    private Integer companyId;
    private SortType sortType;
    private DisplayRuleTypeEnum offerNameDisplayRuleType;
    private String offerNameRule;
    private DisplayRuleTypeEnum rateInfoDisplayRuleType;
    private String rateInfoRule;
    private DisplayRuleTypeEnum rateDescDisplayRuleType;
    private String rateDescRule;
    private DisplayRuleTypeEnum confNameDisplayRuleType;
    private String confNameRule;
    private DisplayRuleTypeEnum confDescDisplayRuleType;
    private String confDescRule;
    private SelectStatus sixMonthCheck;
    private SelectStatus twelveMonthCheck;
    private RuleStatus displayRuleStatus;
}
