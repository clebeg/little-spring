package cn.clebeg.springframework.beans.factory.config;

import cn.clebeg.springframework.beans.BeansException;

/**
 * 在 bean 初始化之前操作 bean definition 接口。
 */
public interface BeanFactoryPostProcessor {
    /**
     * 在所有 beandefinition 加载完成后，提供修改 bean definition 属性的机制。
     * @param beanFactory ConfigurableListableBeanFactory
     * @throws BeansException beans exception
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
