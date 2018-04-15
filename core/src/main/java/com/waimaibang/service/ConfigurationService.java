package com.waimaibang.service;

/**
 * @Author zhouguanya
 * @Date 2018/4/15
 * @Description 配置服务
 */
public interface ConfigurationService {
    /**
     * 注册配置
     */
    void registerConfiguration();

    /**
     * 修改配置
     * @return
     */
    boolean updateConfiguration();

    /**
     * 刷新配置
     * @return
     */
    boolean flushConfiguration();
}
