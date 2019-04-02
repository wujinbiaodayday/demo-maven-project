package com.ddc.common.demo.domain.common;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * Created by zhaojingyang on 2015/8/15.
 */
public abstract class AbstractBaseDO implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
