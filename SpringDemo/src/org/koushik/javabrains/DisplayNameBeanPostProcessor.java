package org.koushik.javabrains;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class DisplayNameBeanPostProcessor implements BeanPostProcessor
{

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException 
	{
		System.out.println("After Initialization Method. Bean name is " + beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException 
	{
		System.out.println("Before Initialization Method. Bean name is " + beanName);
		return bean;
	}

}
