package com.lhy.ssm.support.listeners;

/**
 * @author haiyang.li
 */
public interface AppContext {

    /**
     * 初始化
     */
    void init();

    /**
     * 获取配置文件
     *
     * @param keyName
     * @return
     */
    String getConfigByKey(String keyName);

    /**
     * 销毁
     */
    void destroy();
}
