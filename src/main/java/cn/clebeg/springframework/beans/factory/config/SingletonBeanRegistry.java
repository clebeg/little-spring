package cn.clebeg.springframework.beans.factory.config;

/**
 * 注册一个单例
 * @author clebegxie
 */
public interface SingletonBeanRegistry {

    /**
     * 通过 bean class 的名字获取 bean 实例的单例.
     * @param beanName name of bean.
     * @return 单例
     */
    Object getSingleton(String beanName);
}
