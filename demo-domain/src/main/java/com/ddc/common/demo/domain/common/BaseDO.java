package com.ddc.common.demo.domain.common;

import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

public class BaseDO extends AbstractBaseDO {
    /**
     * 创建时间
     */
    @TableId(value = "create_time")
    protected Date createTime;

    /**
     * 修改时间
     */
    @TableId(value = "update_time")
    protected Date updateTime;

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
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
        return "BaseDO{" +
                "id=" + getId() +
                "createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
