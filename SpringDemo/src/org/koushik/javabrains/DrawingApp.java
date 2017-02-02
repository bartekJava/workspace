package org.koushik.javabrains;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp 
{
	public static void main(String[] args)
	{
//		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("Spring.xml"));
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
		Shape shape = (Shape)context.getBean("circle");
		shape.draw();
//		System.out.println(context.getMessage("greeting", null, "Default greeting", null));
	}

}
