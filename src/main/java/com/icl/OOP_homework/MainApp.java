package com.icl.OOP_homework;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MainApp {
	public static void main(String[] args) {


		try (SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Company.class)
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory(); Session session = factory.getCurrentSession()) {
//			Company company = new Company();
//			company.setName("FDP Inc.");
//			session.beginTransaction();
//			session.save(company);
//			session.getTransaction().commit();

//			session.beginTransaction();
//			Company company = session.get(Company.class, 1);
//			for (int i = 0; i < 10; i++) company.hire(new Employee());
//			for (int i = 0; i < 7; i++) company.hire(new Employee(Employee.Type.MANAGER));
//			for (int i = 0; i < 2; i++) company.hire(new Employee(Employee.Type.TOPMANAGER));
//			session.getTransaction().commit();

//			session.beginTransaction();
//			Company company = session.get(Company.class, 1);
//			company.update();
//			session.getTransaction().commit();

//			session.beginTransaction();
//			Company company = session.get(Company.class, 2);
//			company.setName("FUFO");
//			company.update();
//			session.getTransaction().commit();

//			session.beginTransaction();
//			Employee employee = session.get(Employee.class, 3);
//			employee.setSalary(150000);
//			session.getTransaction().commit();

			session.beginTransaction();
			Company company = session.get(Company.class, 1);
			company.update();
			session.getTransaction().commit();
		}
	}
}
