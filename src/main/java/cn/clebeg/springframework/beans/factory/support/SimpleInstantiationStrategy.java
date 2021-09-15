package cn.clebeg.springframework.beans.factory.support;

import cn.clebeg.springframework.beans.BeansException;
import cn.clebeg.springframework.beans.factory.config.BeanDefinition;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 类初始化的策略.
 * @author clebegxie
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {

    /**
     * instantiate by bean name bean class and constructor and constructor args.
     *
     * @param beanName bean name
     * @param beanDefinition bean definition
     * @param constructor constructor
     * @param args bean input args
     * @return instantiate object
     * @throws BeansException beans exception
     */
    @Override
    public Object instantiate(String beanName, BeanDefinition beanDefinition,
            Constructor<?> constructor, Object[] args) throws BeansException {
        Class<?> beanClass = beanDefinition.getBeanClass();

        try {
            if (null == constructor) {
                return beanClass.getDeclaredConstructor().newInstance();
            } else {
                return beanClass.getConstructor(constructor.getParameterTypes()).newInstance(args);
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new BeansException("Failed instantiate [" + beanName + "], " + e.getMessage(), e);
        }
    }
}
