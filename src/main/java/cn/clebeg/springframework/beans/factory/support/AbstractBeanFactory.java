package cn.clebeg.springframework.beans.factory.support;

import cn.clebeg.springframework.beans.BeansException;
import cn.clebeg.springframework.beans.factory.BeanFactory;
import cn.clebeg.springframework.beans.factory.config.BeanDefinition;

/**
 * @author clebegxie
 */
abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String beanName) {
        Object singleton = getSingleton(beanName);
        if (singleton != null) {
            return singleton;
        }

        // 根据类名称生成类定义
        BeanDefinition beanDefinition = getBeanDefinition(beanName);

        return createBean(beanName, beanDefinition);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        Object singleton = getSingleton(beanName);
        if (singleton != null) {
            return singleton;
        }

        // 根据类名称生成类定义
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName, beanDefinition, args);
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
     * @return bean Object
     * @throws BeansException beans exception
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

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
