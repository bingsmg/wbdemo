package live.clover.thirdpay;

import java.util.List;

/**
 * 第三方支付显示规则 DTO
 * @author weibb
 * @date 2023-08-23
 */
public class ThirdPayDisplayRuleDTO extends ThirdPayBasicInfoDTO {

    /**
     * 第三方支付产品-支付商信息
     */
    ThirdPayPayerDTO payPayers;
    /**
     * 第三方支付产品-固定倍数资费明细
     */
    List<ThirdPayFixedRateDTO> fixedRates;
    /**
     * 第三方支付产品-自定义资费明细
     */
    List<ThirdPayCustomRateDTO> customRates;

    /**
     * 第三方支付产品-节目包明细
     */
    List<ThirdPayOfferDTO> basicOffers;
    /**
     * 第三方支付产品-可激活更换产品明细
     */
    List<ThirdPayProductDTO> products;
}
