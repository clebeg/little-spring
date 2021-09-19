package cn.clebeg.springframework.beans.factory;

import java.util.Map;

import cn.clebeg.springframework.beans.BeansException;

/**
 * Extension of the {@link BeanFactory} interface to be implemented by bean factories
 * that can enumerate all their bean instances, rather than attempting bean lookup
 * by name one by one as requested by clients. BeanFactory implementations that
 * preload all their bean definitions (such as XML-based factories) may implement
 * this interface.
 * <p>
 * Create by clebeg
 */
public interface ListableBeanFactory extends BeanFactory {
    /**
     * 根据类型返回所有符合此类型的 bean 实例，以 dict 的形式返回。
     * @param <T> 需要的类型
     * @param type class 类型
     * @return dict 的形式，bean的名字和实例
     * @throws BeansException beans exception
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 返回所有注册的 bean 的名字。
     * @return String[]
     */
    String[] getBeanDefinitionNames();
}
