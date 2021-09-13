package cn.clebeg.springframework.beans.factory;

import cn.clebeg.springframework.beans.BeansException;

/**
 * @author clebegxie
 */
public interface BeanFactory {

    /** get object instance by bean name.
     * @param beanName bean name
     * @return object instance
     * @throws BeansException
     */
    Object getBean(String beanName) throws BeansException;;

    /**
     * get bean by bean name add args.
     * @param beanName bean name for get bean class.
     * @param args constructor bean class.
     * @return new instance of bean class.
     * @throws BeansException
     */
    Object getBean(String beanName, Object... args) throws BeansException;;
}
