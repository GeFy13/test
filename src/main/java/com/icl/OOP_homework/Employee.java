package com.icl.OOP_homework;

import javax.persistence.*;

@Entity
public interface Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int getId();

	@ManyToOne
	@JoinColumn(name = "company_id")
	Company getCompany();

	@Transient
	int getMonthSalary();
}
