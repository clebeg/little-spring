package cn.clebeg.springframework.beans.factory.support;

import cn.clebeg.springframework.beans.factory.config.SingletonBeanRegistry;
import java.util.HashMap;
import java.util.Map;

/**
 * @author clebegxie
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> beanObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return beanObjects.get(beanName);
    }

    public void addSingleton(String beanName, Object object) {
        beanObjects.put(beanName, object);
    }
}
