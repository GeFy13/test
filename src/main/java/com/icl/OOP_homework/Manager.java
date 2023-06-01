package com.icl.OOP_homework;

import javax.persistence.*;

@Entity
@Table(name = "managers")
public class Manager implements Employee{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "stavka")
	private int wage_rate;

	@Transient
	public static int income = 0;

	@Column(name = "income")
	private int unit_income;

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	@Override
	public int getMonthSalary() {
		return wage_rate + (int)(unit_income * 0.05);
	}

	public Manager() {
		wage_rate = (int)(Math.random() * (80_000 - 60_000) + 60_000);
		unit_income = (int)(Math.random() * (140_000 - 115_000) + 115_000);
		income += unit_income;
	}
}
