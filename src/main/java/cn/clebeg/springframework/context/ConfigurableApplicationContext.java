package cn.clebeg.springframework.context;

import cn.clebeg.springframework.beans.BeansException;

/**
 * author: clebeg
 */
public interface ConfigurableApplicationContext extends ApplicationContext {
    /**
     * 刷新容器
     */
    void refresh() throws BeansException;
}
