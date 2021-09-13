package cn.clebeg.springframework.beans.factory.support;

import cn.clebeg.springframework.beans.BeansException;
import cn.clebeg.springframework.beans.factory.config.BeanDefinition;
import java.lang.reflect.Constructor;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

/**
 * 类初始化的策略.
 * @author clebegxie
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {

    /**
     * instantiate by bean name bean class and constructor and constructor args.
     *
     * @param beanName bean name
     * @param beanDefinition bean definition
     * @param constructor constructor
     * @param args bean input args
     * @return
     * @throws BeansException
     */
    @Override
    public Object instantiate(String beanName, BeanDefinition beanDefinition,
            Constructor constructor, Object[] args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (null == constructor) {
            return enhancer.create();
        }
        return enhancer.create(constructor.getParameterTypes(), args);
    }
}
