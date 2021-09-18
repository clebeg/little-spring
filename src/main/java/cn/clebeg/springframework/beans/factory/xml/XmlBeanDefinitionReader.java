package cn.clebeg.springframework.beans.factory.xml;

import cn.clebeg.springframework.beans.BeansException;
import cn.clebeg.springframework.beans.factory.PropertyValue;
import cn.clebeg.springframework.beans.factory.config.BeanDefinition;
import cn.clebeg.springframework.beans.factory.config.BeanReference;
import cn.clebeg.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import cn.clebeg.springframework.beans.factory.support.BeanDefinitionRegistry;
import cn.clebeg.springframework.core.io.Resource;
import cn.clebeg.springframework.core.io.ResourceLoader;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import java.io.IOException;
import java.io.InputStream;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author clebegxie
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry,
            ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        InputStream inputStream;
        try {
            inputStream = resource.getInputStream();
            doLoadBeanDefinitions(inputStream);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }
    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }

    private void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException {
        Document doc = XmlUtil.readXML(inputStream);
        Element root = doc.getDocumentElement();

        NodeList childNodes = root.getChildNodes();

        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (!(item instanceof Element) || !"bean".equals(item.getNodeName())) {
                continue;
            }

            String id = ((Element) item).getAttribute("id");
            String name = ((Element) item).getAttribute("name");
            String classStr = ((Element) item).getAttribute("class");

            Class<?> clazz = Class.forName(classStr);

            String beanName = StrUtil.isNotEmpty(id) ? id : name;

            if (StrUtil.isEmpty(beanName)) {
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }

            BeanDefinition beanDefinition = new BeanDefinition(clazz);

            NodeList itemChildNodes = item.getChildNodes();

            for (int j = 0; j < itemChildNodes.getLength(); j++) {
                Node prop = itemChildNodes.item(j);
                if (!(prop instanceof Element) || !"property".equals(prop.getNodeName())) {
                    continue;
                }

                String attrName = ((Element) prop).getAttribute("name");
                String attrValue = ((Element) prop).getAttribute("value");
                String attrRef = ((Element) prop).getAttribute("ref");

                Object value = StrUtil.isNotEmpty(attrRef) ? new BeanReference(attrRef) : attrValue;

                PropertyValue propertyValue = new PropertyValue(attrName, value);

                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
            }

            if (getRegistry().containsBeanDefinition(beanName)) {
                throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed.");
            }

            getRegistry().registerBeanDefinition(beanName, beanDefinition);

        }

    }
}
