package cn.clebeg.springframework.beans.factory.support;

import cn.clebeg.springframework.core.io.DefaultResourceLoader;
import cn.clebeg.springframework.core.io.ResourceLoader;

/**
 * @author clebegxie
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    private final BeanDefinitionRegistry registry;

    private final ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, null);
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry,
            ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
