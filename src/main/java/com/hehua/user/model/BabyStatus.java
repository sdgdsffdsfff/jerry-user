/**
 * 
 */
package com.hehua.user.model;

/**
 * @author zhihua
 *
 */
public enum BabyStatus {

    Preparing(0), // 备孕

    Pregnant(1), // 怀孕中

    Birth(2), // 已经有小孩

    None(-1) // 未知

    ;

    private final int code;

    /**
     * @param code
     */
    private BabyStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static BabyStatus fromCode(int code) {
        switch (code) {
            case 0:
                return Preparing;
            case 1:
                return Pregnant;
            case 2:
                return Birth;
            case -1:
                return None;
            default:
                throw new RuntimeException("unkown baby status code: " + code);
        }
    }

}
