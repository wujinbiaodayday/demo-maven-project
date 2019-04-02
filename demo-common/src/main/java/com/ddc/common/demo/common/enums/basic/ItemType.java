package com.ddc.common.demo.common.enums.basic;

import java.util.HashMap;
import java.util.Map;

/**
 * 商品类型
 */
public enum ItemType {

//    MAKE(1, "现制现售品"),
    SALES(2, "零售品"),
//    COURSE(3, "课程"),
    MATERIAL(4, "原料"), consume(5, "耗材"),TOOL(6, "工具"),
    SHOP(7, "电商商品"),
    PORTAL(8, "门户商品");

    private static Map<Integer, String> enumMap = new HashMap<>();

    private Integer value;
    private String desc;

    ItemType(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }


    public Integer getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public static ItemType valueOfByValue(String value) {
        ItemType[] values = ItemType.values();
        for (ItemType v : values) {
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
                    ItemType[] values = ItemType.values();
                    for (ItemType v : values) {
                        enumMap.put(v.getValue(), v.getDesc());
                    }
                }
            }
        }
        return enumMap;
    }

    public static Map<Integer, String> getEnumMap() {
        return enumMap;
    }

    public static void setEnumMap(Map<Integer, String> enumMap) {
        ItemType.enumMap = enumMap;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
