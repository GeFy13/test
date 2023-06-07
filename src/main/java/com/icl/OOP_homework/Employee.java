package com.icl.OOP_homework;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@Getter
@Setter
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "salary")
	private int salary;

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	public Type type;

	public Employee() {
		this.type = Type.OPERATOR;
		salary = (int)(Math.random()*(80000-60000) + 60000);
	}

	enum Type {
		MANAGER, TOPMANAGER, OPERATOR
	}

	public Employee(Type type) {
		this.type = type;
		salary = (int)(Math.random()*(80000-60000) + 60000);
	}
}
