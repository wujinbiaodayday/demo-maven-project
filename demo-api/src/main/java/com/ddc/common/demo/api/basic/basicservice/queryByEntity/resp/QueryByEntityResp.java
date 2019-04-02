package com.ddc.common.demo.api.basic.basicservice.queryByEntity.resp;

import java.io.Serializable;

public class QueryByEntityResp implements Serializable {
    private Long id;
    private Long provinceId;
    private String cityCname;
    private String shortName;

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



    @Override
    public String toString() {
        return "CityEntity{" +
                "id=" + id +
                ", provinceId=" + provinceId +
                ", cityCname='" + cityCname + '\'' +
                ", shortName='" + shortName + '\'' +
                '}';
    }
}
