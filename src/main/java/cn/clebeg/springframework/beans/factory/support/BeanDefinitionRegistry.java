package cn.clebeg.springframework.beans.factory.support;

import cn.clebeg.springframework.beans.factory.config.BeanDefinition;

/**
 * bean 定义的注册器.
 * @author clebegxie
 */
public interface BeanDefinitionRegistry {

    /**
     * 注册 bean 的定义，本质就是将 bean 的定义和 bean 的名字映射。
     * @param beanName name of bean
     * @param beanDefinition definition of bean, include bean class, bean properties, ......
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * contains bean definition.
     * @param beanName name of bean
     * @return boolean of contains bean definition
     */
    boolean containsBeanDefinition(String beanName);
}
