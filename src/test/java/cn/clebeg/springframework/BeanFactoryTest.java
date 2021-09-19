package cn.clebeg.springframework;

import cn.clebeg.springframework.bean.TestBean;
import cn.clebeg.springframework.beans.PropertyValue;
import cn.clebeg.springframework.beans.PropertyValues;
import cn.clebeg.springframework.beans.factory.config.BeanDefinition;
import cn.clebeg.springframework.beans.factory.support.DefaultListableBeanFactory;

public class BeanFactoryTest {

    public static void main(String[] args) {
        String beanName = "TestBean";
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("hobby", "basketball"));
        BeanDefinition beanDefinition = new BeanDefinition(TestBean.class, propertyValues);

        beanFactory.registerBeanDefinition(beanName, beanDefinition);

        TestBean testBean = (TestBean) beanFactory.getBean(beanName, "clebeg", 18);
        testBean.sayHello();
    }
}
