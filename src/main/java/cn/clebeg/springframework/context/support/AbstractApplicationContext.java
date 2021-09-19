package cn.clebeg.springframework.context.support;

import cn.clebeg.springframework.beans.BeansException;
import cn.clebeg.springframework.context.ConfigurableApplicationContext;
import cn.clebeg.springframework.core.io.DefaultResourceLoader;

public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {
    @Override
    public void refresh() throws BeansException {
        
    }
}
