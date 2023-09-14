package live.clover.thirdpay;

/**
 * 第三方支付产品-替代资费项枚举
 * @author weibb
 * @date 2023-08-23
 */
public enum ReplaceRateEnum {
    DAYS_60_2_MONTHS("60日/2月", 60, 2),
    DAYS_90_3_MONTHS("90日/3月", 90, 3),
    DAYS_180_6_MONTHS("180日/6月", 180, 6),
    DAYS_360_12_MONTHS("360日/12月", 360, 12);

    private final String label;
    private final int days;
    private final int months;

    ReplaceRateEnum(String label, int days, int months) {
        this.label = label;
        this.days = days;
        this.months = months;
    }

    public String getLabel() {
        return label;
    }

    public int getDays() {
        return days;
    }

    public int getMonths() {
        return months;
    }
}
