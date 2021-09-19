package cn.clebeg.springframework.beans.factory.config;

import cn.clebeg.springframework.beans.BeansException;

/**
 * 在 bean 初始化之前或者之后 操作 bean 实例的接口。
 */
public interface BeanPostProcessor {
    /**
     * 在 bean 对象初始化之前执行此方法。
     * 
     * @param bean     bean 对象
     * @param beanName bean的名字
     * @throws BeansException bean exception。
     * @return bean object
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在 bean 对象初始化之后执行此方法。
     * 
     * @param bean     bean 对象
     * @param beanName bean 的名字
     * @throws BeansException bean exception。
     * @return bean object
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
