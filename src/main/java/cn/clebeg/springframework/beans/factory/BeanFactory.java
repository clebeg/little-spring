package cn.clebeg.springframework.beans.factory;

import cn.clebeg.springframework.beans.BeansException;

/**
 * @author clebegxie
 */
public interface BeanFactory {

    /**
     * get bean instance by bean name.
     * 
     * @param beanName bean name
     * @return object instance
     * @throws BeansException beans exception
     */
    Object getBean(String beanName) throws BeansException;

    /**
     * get bean instance by bean name add args.
     * 
     * @param beanName bean name for get bean class.
     * @param args     constructor bean class.
     * @return new instance of bean class.
     * @throws BeansException beans exception
     */
    Object getBean(String beanName, Object... args) throws BeansException;

    /**
     * 根据传入的类型，返回对应类型的 bean 实例。
     * @param <T> 传入的类型
     * @param beanName bean 的名称
     * @param classOfType 类型的 class
     * @return 返回对应的实例
     * @throws BeansException beans exception
     */
    <T> T getBean(String beanName, Class<T> classOfType) throws BeansException;
}
