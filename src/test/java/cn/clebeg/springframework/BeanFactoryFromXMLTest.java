package cn.clebeg.springframework;

import cn.clebeg.springframework.bean.TestBean;
import cn.clebeg.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.clebeg.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import cn.clebeg.springframework.core.io.DefaultResourceLoader;

public class BeanFactoryFromXMLTest {

    public static void main(String[] args) {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory, resourceLoader);
        reader.loadBeanDefinitions("classpath:Spring.xml");

        TestBean testBean = (TestBean) factory.getBean("testBean","clebeg", 18);

        testBean.sayHello();

        System.out.println(testBean.queryUserAge());

    }
}
