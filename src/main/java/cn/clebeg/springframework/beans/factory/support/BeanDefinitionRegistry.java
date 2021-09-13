package cn.clebeg.springframework.beans.factory.support;

import cn.clebeg.springframework.beans.factory.config.BeanDefinition;

/**
 * bean 定义的注册器.
 * @author clebegxie
 */
public interface BeanDefinitionRegistry {

    /**
     * 注册 bean 的定义，本质就是将 bean 的定义和 bean 的名字映射。
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * contains bean definition.
     * @param beanName
     * @return
     */
    boolean containsBeanDefinition(String beanName);
}
