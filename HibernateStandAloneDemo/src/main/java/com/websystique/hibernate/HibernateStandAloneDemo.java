package com.websystique.hibernate;

import java.util.List;

import org.hibernate.Session;

import com.websystique.hibernate.model.Student;

public class HibernateStandAloneDemo {

	@SuppressWarnings("unused")
	public static void main(String[] args) 
	{
		HibernateStandAloneDemo application = new HibernateStandAloneDemo();
		
		int studentId1 = application.saveStudent("Sam", "Disilva", "Maths");
        int studentId2 = application.saveStudent("Joshua", "Brill", "Science");
        int studentId3 = application.saveStudent("Peter", "Pan", "Physics");
        int studentId4 = application.saveStudent("Bill", "Laurent", "Maths");
        
        
        
        List<Student> students = application.getAllStudents();
        System.out.println("List of all persisted students >>>");
        for (Student student : students) 
        {
            System.out.println("Persisted Student :" + student);
        }
        
        
        
        application.updateStudent(studentId4, "ARTS");
        
        
        
        application.deleteStudent(studentId2);

	}
	
	public int saveStudent(String firstName, String lastName, String section) 
	{
		Student student = new Student();
		student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setSection(section);
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int id = (Integer)session.save(student);
        session.getTransaction().commit();
        return id;
	}
	
	
	
	public List<Student> getAllStudents() 
	{
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
 
        @SuppressWarnings("unchecked")
        List<Student> employees = (List<Student>) session.createQuery(
                "FROM Student s ORDER BY s.firstName ASC").list();
 
        session.getTransaction().commit();
        return employees;
	}
	
	
	
    public void updateStudent(int id, String section) 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
 
        Student student = (Student) session.get(Student.class, id);
        student.setSection(section);
        //session.update(student);//No need to update manually as it will be updated automatically on transaction close.
        session.getTransaction().commit();
    }


    public void deleteStudent(int id)
    {
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	session.beginTransaction();
    	Student student = (Student)session.get(Student.class, id);
    	session.delete(student);
    	session.getTransaction().commit();
      
    }

}
