package com.icl.OOP_homework;

import javax.persistence.*;

@Entity
@Table(name = "topmanagers")
public class TopManager implements Employee{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "stavka")
	private int wage_rate;

	@JoinColumn(name = "company_id")
	private Company company;

	@Override
	public int getMonthSalary() {
		return wage_rate + (int)(Manager.income > 10_000_000 ? wage_rate * 1.5 : 0);
	}

	public TopManager() {
		wage_rate = (int)(Math.random() * (80_000 - 60_000) + 60_000);
	}
}
