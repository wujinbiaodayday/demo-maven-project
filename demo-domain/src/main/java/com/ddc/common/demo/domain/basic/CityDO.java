package com.ddc.common.demo.domain.basic;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ddc.common.demo.domain.common.BaseDO;

/**
 * 城市实体
 */
@TableName("md_city")
public class CityDO extends BaseDO {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableId(value = "province_id")
    private Long provinceId;

    @TableId(value = "city_cname")
    private String cityCname;

    @TableId(value = "short_name")
    private String shortName;

    @TableId(value = "sort")
    private Integer sort;

    @TableId(value = "lng")
    private String lng;

    @TableId(value = "lat")
    private String lat;

    @Override
    public Long getId() {
        return id;
    }

    @Override
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
        return "CityDO{" +
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
