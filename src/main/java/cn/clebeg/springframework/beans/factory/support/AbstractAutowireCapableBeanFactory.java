package cn.clebeg.springframework.beans.factory.support;

import cn.clebeg.springframework.beans.BeansException;
import cn.clebeg.springframework.beans.factory.PropertyValue;
import cn.clebeg.springframework.beans.factory.PropertyValues;
import cn.clebeg.springframework.beans.factory.config.BeanDefinition;
import cn.clebeg.springframework.beans.factory.config.BeanReference;
import cn.hutool.core.bean.BeanUtil;
import java.lang.reflect.Constructor;
import org.apache.commons.lang3.ClassUtils;

/**
 * Todo：目前通过 bean definition 初始化类不支持构造器 需要完善.
 */
abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
            // 通过bean的定义来补充属性值
            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (InstantiationException e) {
            throw new BeansException("get bean class new instance by bean definition error, " + e.getMessage(), e);
        } catch (IllegalAccessException e) {
            throw new BeansException("get bean class new instance by bean definition error, " + e.getMessage(), e);
        }

        addSingleton(beanName, bean);
        return bean;
    }

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean;
        try {
            bean = createBeanInstance(beanName, beanDefinition, args);
            // 通过bean的定义来补充属性值
            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("get bean class new instance by bean definition error, " + e.getMessage(), e);
        }

        addSingleton(beanName, bean);
        return bean;
    }

    private void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue pv : propertyValues.getPropertyValues()) {
                String name = pv.getName();
                Object value = pv.getValue();

                if (value instanceof BeanReference) {
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }

                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values: " + beanName + ", error msg: " + e.getMessage(), e);
        }
    }

    protected Object createBeanInstance(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Constructor constructor = null;
        Class beanClass = beanDefinition.getBeanClass();
        Constructor[] constructors = beanClass.getConstructors();
        for (Constructor ctor : constructors) {
            Class[] parameterTypes = ctor.getParameterTypes();
            if (parameterTypes.length != args.length) {
                continue;
            }
            boolean match = true;
            for (int i = 0; i < parameterTypes.length; i++) {
                Class compare = parameterTypes[i];
                if (compare.isPrimitive()) {
                    compare = ClassUtils.primitiveToWrapper(compare);
                }
                if (!compare.getTypeName().equals(args[i].getClass().getTypeName())) {
                    match = false;
                    break;
                }
            }
            if (match) {
                constructor = ctor;
                break;
            }
        }
        return instantiationStrategy.instantiate(beanName, beanDefinition, constructor, args);
    }
}
