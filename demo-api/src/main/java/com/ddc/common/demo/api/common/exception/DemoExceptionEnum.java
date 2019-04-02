package com.ddc.common.demo.api.common.exception;

import com.ddc.common.api.exception.ExceptionEnum;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1000-1999 是demo系统异常
 */
public class DemoExceptionEnum extends ExceptionEnum {
    private static volatile transient Map<String, ExceptionEnum> values = new LinkedHashMap<String, ExceptionEnum>();
    private static volatile transient Map<String, ExceptionEnum> names = new LinkedHashMap<String, ExceptionEnum>();
    private static final Lock lock = new ReentrantLock();

    public static ExceptionEnum DEMO_ERROR = ExceptionEnum.valueOf("1000", "demo error");


    private DemoExceptionEnum() {
        this.value = undefined;
        this.name = undefined;
    }

    private DemoExceptionEnum(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public static ExceptionEnum valueOf(String value, String name) {
        ExceptionEnum e = values.get(value);
        if (e != null) {
            if (e.getName().equals(name) || undefined.equals(name))
                //undefined可以更新， 其他的name不可以更新？ No, 所有值都可以更新; 但是不能用undefined覆盖已有值
                return e;
            else {
                //命名不相同
                //log.warn("Name to be change. value:" + value + ", old name:" + e.name + ", new name:" + name);
            }
        }

        Map<String, ExceptionEnum> tempValues = new LinkedHashMap<String, ExceptionEnum>();
        Map<String, ExceptionEnum> tempNames = new LinkedHashMap<String, ExceptionEnum>();
        e = new DemoExceptionEnum(value, name);
        lock.lock();
        try {
            tempValues.putAll(values);
            tempNames.putAll(names);
            tempValues.put(value, e);
            tempNames.put(name, e);
            values = tempValues;
            names = tempNames;
        } finally {
            lock.unlock();
        }
        return e;
    }


    public static ExceptionEnum valueOfByValue(String value) {
        ExceptionEnum e = values.get(value);
        if (e == null) {
            throw new RuntimeException("不包含此Value:" + value);
        }
        return e;
    }

    public static ExceptionEnum valueOfByName(String name) {
        ExceptionEnum e = names.get(name);
        if (e == null) {
            throw new RuntimeException("不包含此name:" + name);
        }
        return e;
    }

    public static boolean containValue(String value) {
        ExceptionEnum e = values.get(value);
        if (e != null) {
            return true;
        } else {
            return false;
        }
    }

    public static ExceptionEnum[] values() {
        return values.values().toArray(new ExceptionEnum[0]);
    }

}
