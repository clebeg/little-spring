package cn.clebeg.springframework.beans.factory.support;

import cn.clebeg.springframework.beans.BeansException;
import cn.clebeg.springframework.beans.factory.BeanFactory;
import cn.clebeg.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.clebeg.springframework.beans.factory.config.BeanDefinition;
import cn.clebeg.springframework.beans.factory.config.BeanPostProcessor;
import cn.clebeg.springframework.beans.factory.config.ConfigurableBeanFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author clebegxie
 */
abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    @Override
    public Object getBean(String beanName) {
        return doGetBean(beanName, null);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return doGetBean(beanName, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    protected <T> T doGetBean(final String name, final Object[] args) {
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        beanPostProcessors.remove(beanPostProcessor);
        beanPostProcessors.add(beanPostProcessor);
    }

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return beanPostProcessors;
    }

    /**
     * 通过bean的名字生产bean的定义.
     * @param beanName name of bean
     * @return bean definition
     * @throws BeansException beans exception
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 根据bean的定义产生对象，并且放入到单例中.
     * @param beanDefinition bean definition
     * @param beanName name of bean
     * @param args construct args
     * @return Object bean object
     * @throws BeansException beans exception
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;
}
