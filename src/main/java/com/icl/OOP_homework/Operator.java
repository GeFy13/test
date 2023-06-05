package com.icl.OOP_homework;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "operators")
public class Operator implements Employee {

	@Id
	@Column(name = "id")
	private int id;

	@Override
	public int getId() {
		return id;
	}

	@Override
	public Company getCompany() {
		return company;
	}

	@Column(name = "stavka")
	private int wage_rate;

	@Transient
	private Company company;

	@Override
	public int getMonthSalary() {
		return wage_rate;
	}

	public Operator() {
		wage_rate = (int)(Math.random() * (80_000 - 60_000) + 60_000);
	}
}
