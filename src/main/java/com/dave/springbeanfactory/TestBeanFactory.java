package com.dave.springbeanfactory;

import com.dave.model.Employee;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Created by David on 09/03/2017.
 */
public class TestBeanFactory {

    @Test
    public void testSpringBeanFactory() {
        Resource r = new ClassPathResource("beanFactory-example.xml");
//        BeanFactory factory = new XmlBeanFactory(r);
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        reader.loadBeanDefinitions(r);


        Employee employee = (Employee)beanFactory.getBean(Employee.class);
        System.out.println(employee.getFirstName());

    }
}
