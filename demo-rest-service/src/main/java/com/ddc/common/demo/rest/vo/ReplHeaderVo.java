package com.ddc.common.demo.rest.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 补货单头BO 对应entity
 * Created by zhaojingyang
 */
public class ReplHeaderVo implements Serializable {
    private Long id;
    private Long merchantId;
    private String replHeaderCode;
    private String orderStatus;
    private Long cabinetId;
    private String contactName;
    private String contactMobile;
    private String address;
    private Date finishTime;
    private Date createTime;
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getReplHeaderCode() {
        return replHeaderCode;
    }

    public void setReplHeaderCode(String replHeaderCode) {
        this.replHeaderCode = replHeaderCode;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getCabinetId() {
        return cabinetId;
    }

    public void setCabinetId(Long cabinetId) {
        this.cabinetId = cabinetId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ReplHeaderVo{" +
                "id=" + id +
                ", merchantId=" + merchantId +
                ", replHeaderCode='" + replHeaderCode + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", cabinetId=" + cabinetId +
                ", contactName='" + contactName + '\'' +
                ", contactMobile='" + contactMobile + '\'' +
                ", address='" + address + '\'' +
                ", finishTime=" + finishTime +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
