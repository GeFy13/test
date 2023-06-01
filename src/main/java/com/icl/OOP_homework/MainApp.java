package com.icl.OOP_homework;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MainApp {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Company.class)
				.addAnnotatedClass(Manager.class)
				.addAnnotatedClass(Operator.class)
				.addAnnotatedClass(TopManager.class)
				.buildSessionFactory();


		Session session = null;

		try	{
			session = factory.getCurrentSession();
			Company company = new Company();
			company.setName("FDP Inc.");
			session.beginTransaction();
			session.save(company);
			session.getTransaction().commit();
		} finally {
			factory.close();
			session.close();
		}

//		Company company = new Company();
//		for (int i = 0; i < 20; i++) company.hire(new Operator());
//		for (int i = 0; i < 7; i++) company.hire(new Manager());
//		for (int i = 0; i < 3; i++) company.hire(new TopManager());
//
//		System.out.println("\nСписок 15 самых высоких зарплат до увольнения: ");
//		List<Employee> topSalaryList = company.getTopSalaryStaff(10);
//		for (Employee e : topSalaryList) {
//			System.out.println(e.getMonthSalary());
//		}
//
//		System.out.println("\nСписок 30 самых низких зарплат до увольнения: ");
//		List<Employee> lowSalaryList = company.getLowestSalaryStaff(10);
//		for (Employee e : lowSalaryList) {
//			System.out.println(e.getMonthSalary());
//		}
//
//		for (int i = 0; i < 10; i ++) company.fire();
//
//		System.out.println("\nСписок 15 самых высоких зарплат после увольнения: ");
//		topSalaryList = company.getTopSalaryStaff(10);
//		for (Employee e : topSalaryList) {
//			System.out.println(e.getMonthSalary());
//		}
//
//		System.out.println("\nСписок 30 самых низких зарплат после увольнения: ");
//		lowSalaryList = company.getLowestSalaryStaff(10);
//		for (Employee e : lowSalaryList) {
//			System.out.println(e.getMonthSalary());
//		}
	}
}
