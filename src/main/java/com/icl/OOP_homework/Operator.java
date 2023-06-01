package com.icl.OOP_homework;

import javax.persistence.*;

@Entity
@Table(name = "operators")
public class Operator implements Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "stavka")
	private int wage_rate;

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	@Override
	public int getMonthSalary() {
		return wage_rate;
	}

	public Operator() {
		wage_rate = (int)(Math.random() * (80_000 - 60_000) + 60_000);
	}
}
