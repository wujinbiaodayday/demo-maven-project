package com.ddc.common.demo.common.enums.basic;

import java.util.HashMap;
import java.util.Map;

public enum BasicLogType {

    SUPPLIER(1, "供应商管理"), CONTRACT(2, "合同管理"), PRODUCT(3, "产品管理"), ACCOUNT(4, "账号管理");

    private static Map<Integer, String> enumMap = new HashMap<>();

    private Integer value;
    private String desc;

    BasicLogType(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }


    public Integer getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public static BasicLogType valueOfByValue(String value) {
        BasicLogType[] values = BasicLogType.values();
        for (BasicLogType v : values) {
            if (v.value.equals(value)) {
                return v;
            }
        }
        return null;
    }

    public static Map<Integer, String> getByMap() {
        if (enumMap.isEmpty()) {
            synchronized (enumMap) {
                if (enumMap.isEmpty()) {
                    BasicLogType[] values = BasicLogType.values();
                    for (BasicLogType v : values) {
                        enumMap.put(v.getValue(), v.getDesc());
                    }
                }
            }
        }
        return enumMap;
    }
}
