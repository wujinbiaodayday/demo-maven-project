package com.ddc.common.demo.persistence.basic.dto;

import java.io.Serializable;

/**
 * 配送上服务区域
 */
public class SupplierServiceCityDto implements Serializable {

    private Long cityId;
    private String cityName;

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "SupplierServiceCityDto{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
