package cn.clebeg.springframework.beans.factory;

import cn.clebeg.springframework.beans.BeansException;
import cn.clebeg.springframework.beans.factory.config.BeanDefinition;
import cn.clebeg.springframework.beans.factory.config.BeanPostProcessor;

/**
 * author: clebeg
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory {

    /**
     * 通过 bean name 获取 bean 的定义。
     * 
     * @param beanName bean name
     * @return bean definition
     * @throws BeansException beans exception
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 初始化单例之前的方法
     * 
     * @throws BeansException beans exception
     */
    void preInstantiateSingletons() throws BeansException;

    /**
     * 注册一个 bean 初始化处理器
     * 
     * @param beanPostProcessor beanPostProcessor
     * @throws BeansException beans exception
     */
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) throws BeansException;
}