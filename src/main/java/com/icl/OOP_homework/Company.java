package com.icl.OOP_homework;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "company")
@Getter
@Setter
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
	@Cascade(org.hibernate.annotations.CascadeType.DELETE)
	private List<Employee> employeeList;

	@Column(name = "income")
	private int income;

	public Company() {
		this.income = 0;
		employeeList = new ArrayList<>();
	}

	public void hire(Employee employee) {
		employee.setCompany(this);
		typeEmployeeSwitch(employee);
		employeeList.add(employee);
	}

	public void hireAll(List<Employee> list) {
		for (Employee e : list) hire(e);
	}

	public List<Employee> getTopSalaryStaff(int count) {
		if (count <= 0 || count > employeeList.size()) count = 5;

		return employeeList.stream().sorted(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getSalary() - o2.getSalary();
			}
		}).limit(count).collect(Collectors.toList());
	}

	public List<Employee> getLowestSalaryStaff(int count) {
		if (count <= 0 || count > employeeList.size()) count = 5;

		return employeeList.stream().sorted(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o2.getSalary() - o1.getSalary();
			}
		}).limit(count).collect(Collectors.toList());
	}

	public void typeEmployeeSwitch(Employee employee) {
		employee.setSalary((int)(Math.random()*(80000-60000) + 60000));
		switch (employee.type) {
			case OPERATOR -> {
				break;
			}
			case MANAGER -> {
				int income = (int) (Math.random() * (140000 - 115000) + 115000);
				this.income += income;
				employee.setSalary(employee.getSalary() + (int) (income * 0.10));
			}
			case TOPMANAGER -> {
				if (this.income >= 1_500_000) employee.setSalary(employee.getSalary() + (int) (this.income * 0.10));
				;
			}
		}
	}

	public void update() {
		this.income = 0;
		List<Employee> list = employeeList.stream().sorted(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.type.compareTo(o2.type);
			}
		}).toList();
		for (Employee e : list) typeEmployeeSwitch(e);
	}

}