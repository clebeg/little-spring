package cn.clebeg.springframework.beans.factory.support;

import cn.clebeg.springframework.beans.BeansException;
import cn.clebeg.springframework.core.io.Resource;
import cn.clebeg.springframework.core.io.ResourceLoader;

/**
 * @author clebegxie
 */
public interface BeanDefinitionReader {

    /**
     * 返回 bean 信息注册器。
     * @return bean definition registry.
     */
    BeanDefinitionRegistry getRegistry();

    /**
     * 返回资源加载器。
     * @return resource loader
     */
    ResourceLoader getResourceLoader();

    /**
     * 通过 resource 获取 bean 定义。
     * @param resource resource
     * @throws BeansException beans exception
     */
    void loadBeanDefinitions(Resource resource) throws BeansException;

    /**
     * 通过 resource 获取 resource 定义。
     * @param resources resources
     * @throws BeansException beans exception
     */
    void loadBeanDefinitions(Resource ...resources) throws BeansException;

    /**
     * 通过路径获取 bean 定义。
     * @param location bean location
     * @throws BeansException beans exception
     */
    void loadBeanDefinitions(String location) throws BeansException;

}
