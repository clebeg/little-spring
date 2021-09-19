package cn.clebeg.springframework;

import cn.clebeg.springframework.bean.TestBean;
import cn.clebeg.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.clebeg.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import cn.clebeg.springframework.context.support.ClassPathXmlApplicationContext;
import cn.clebeg.springframework.core.io.DefaultResourceLoader;

public class BeanFactoryFromXMLTest {

    public static void main(String[] args) {
        testLoadFromXML();
        testLoadFromContext();
    }


    public static void testLoadFromXML() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        TestBean testBean = (TestBean) factory.getBean("testBean","clebeg", 18);

        testBean.sayHello();

        System.out.println(testBean.queryUserAge());
    }

    public static void testLoadFromContext() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
        TestBean testBean = context.getBean("testBean", TestBean.class);
        testBean.sayHello();
        System.out.println(testBean.queryUserAge());
    }
}
