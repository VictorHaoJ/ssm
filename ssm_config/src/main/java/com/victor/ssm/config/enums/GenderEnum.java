package com.victor.ssm.config.enums;

/**
 * @author haojiao
 * @desc: TODO
 * @create 2019/7/3
 */
public enum GenderEnum {

    /** 男士 */
    FEMALE(2),
    /** 女士 */
    MALE(1)
    ;
    private Integer gender;

    GenderEnum(Integer gender) {
        this.gender = gender;
    }

    public Integer getGender() {
        return gender;
    }

    public static GenderEnum of(Integer gender) {
        for (GenderEnum genderEnum : GenderEnum.values()) {
            if (genderEnum.getGender().equals(gender)) {
                return genderEnum;
            }
        }
        return null;
    }
}
