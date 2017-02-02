package databasePackage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import databasePackage.dao.HibernateDaoImpl;
import databasePackage.dao.JdbcDAOimpl;
import databasePackage.dao.NamedParamDaoImpl;
import databasePackage.model.Circle;

public class JDBCDemo {

	public static void main(String[] args) 
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		HibernateDaoImpl dao = ctx.getBean("hibernateDaoImpl", HibernateDaoImpl.class);
//		NamedParamDaoImpl dao = ctx.getBean("namedParamDaoImpl", NamedParamDaoImpl.class);
		
//		Circle circle = dao.getCircle(1);
//		System.out.println(circle.getName());
		
//		dao.insertCircle(new Circle(5, "Fifth Circle"));
//		System.out.println(dao.getAllCircles().size());
		
//		dao.createTriangleTable();
		
		System.out.println(dao.getCircleCount());

	}

}
