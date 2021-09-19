package cn.clebeg.springframework.beans.factory.config;

import cn.clebeg.springframework.beans.BeansException;
import cn.clebeg.springframework.beans.factory.BeanFactory;

public interface AutowireCapableBeanFactory extends BeanFactory {

    /**
     * 执行 {@link BeanPostProcessor} 接口实现的 postProcessBeforeInitialization
     * @param existingBean 存在的 bean
     * @param beanName bean name
     * @return 实现后的 bean 对象
     * @throws BeansException beans exception
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    /**
     * 执行 {@link BeanPostProcessor} 接口实现的 postProcessAfterInitialization
     * @param existingBean 存在的 bean
     * @param beanName bean name
     * @return 实现后的 bean 对象
     * @throws BeansException beans exception
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;
}
