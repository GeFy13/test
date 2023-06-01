package com.icl.OOP_homework;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy = "company")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<Employee> employeeList;

	@Column(name = "income")
	private int income;

	public Company() {
		this.income = getIncome();
		employeeList = new ArrayList<>();
	}

	public void hire(Employee employee) {
		employeeList.add(employee);
	}

	public void hireAll(List<Employee> list) {
		employeeList.addAll(list);
	}

	public void fire() {
		employeeList.remove((int)(Math.random() * employeeList.size()));
	}

	public int getIncome() {
		return Manager.income;
	}

	public List<Employee> getTopSalaryStaff(int count) {
		if (count <= 0 || count > employeeList.size()) count = employeeList.size();

		return employeeList.stream()
				.sorted(new Comparator<Employee>() {
					@Override
					public int compare(Employee o1, Employee o2) {
						return o2.getMonthSalary() - o1.getMonthSalary();
					}
				}).limit(count).collect(Collectors.toList());
	}

	public List<Employee> getLowestSalaryStaff(int count) {
		if (count <= 0 || count > employeeList.size()) count = employeeList.size();

		return employeeList.stream()
				.sorted(new Comparator<Employee>() {
					@Override
					public int compare(Employee o1, Employee o2) {
						return o1.getMonthSalary() - o2.getMonthSalary();
					}
				}).limit(count).collect(Collectors.toList());
	}


}