package com.ddc.common.demo.api.system;

public interface DemoSystemService {

    /**
     * 测试发送消息
     * @param msg
     */
    public void testSendMsg(String msg);

    /**
     * 测试异步方法
     * @param msg
     */
    public void testAsyncFunc(String msg);
}
