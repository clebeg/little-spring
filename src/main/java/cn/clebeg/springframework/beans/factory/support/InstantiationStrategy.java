package cn.clebeg.springframework.beans.factory.support;

import cn.clebeg.springframework.beans.BeansException;
import cn.clebeg.springframework.beans.factory.config.BeanDefinition;
import java.lang.reflect.Constructor;

/**
 * 类初始化的策略.
 * @author clebegxie
 */
public interface InstantiationStrategy {

    /**
     * instantiate by bean name bean class and constructor and constructor args.
     * @param beanName bean name
     * @param beanDefinition bean definition
     * @param constructor constructor
     * @param args bean input args
     * @return instantiate object
     * @throws BeansException beans exception
     */
    Object instantiate(String beanName, BeanDefinition beanDefinition,
            Constructor<?> constructor, Object[] args) throws BeansException;
}
