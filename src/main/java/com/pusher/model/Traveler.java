package com.pusher.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Traveler {

	private String name;
	private Integer expense;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getExpense() {
		return expense;
	}

	public void setExpense(Integer expense) {
		this.expense = expense;
	}

}
