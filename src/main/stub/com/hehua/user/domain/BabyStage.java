/**
 * 
 */
package com.hehua.user.domain;

/**
 * @author zhihua
 *
 */
public enum BabyStage {

    Preparing(1, "备孕"), // 备孕

    ZeroYear(2, "囤货推荐·0-1岁宝宝篇"), // 0-1岁

    OneYear(3, "囤货推荐·1-2岁宝宝篇"), // 1-2岁

    TwoYear(4, "囤货推荐·2-3岁宝宝篇"), // 2-3岁
    ;

    private final int code;
    private final String desc;

    /**
     * @param code
     */
    private BabyStage(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static BabyStage fromCode(int code) {
        switch (code) {
            case 1:
                return Preparing;
            case 2:
                return ZeroYear;
            case 3:
                return OneYear;
            case 4:
                return TwoYear;
            default:
                throw new RuntimeException("unkown baby stage code: " + code);
        }
    }

}
