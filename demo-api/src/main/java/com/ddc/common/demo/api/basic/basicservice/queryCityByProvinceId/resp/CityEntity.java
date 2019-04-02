package com.ddc.common.demo.api.basic.basicservice.queryCityByProvinceId.resp;

import java.io.Serializable;

public class CityEntity implements Serializable {
    private Long id;
    private Long provinceId;
    private String cityCname;
    private String shortName;
    private Integer sort;
    private String lng;
    private String lat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityCname() {
        return cityCname;
    }

    public void setCityCname(String cityCname) {
        this.cityCname = cityCname;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "CityEntity{" +
                "id=" + id +
                ", provinceId=" + provinceId +
                ", cityCname='" + cityCname + '\'' +
                ", shortName='" + shortName + '\'' +
                ", sort=" + sort +
                ", lng='" + lng + '\'' +
                ", lat='" + lat + '\'' +
                '}';
    }
}
