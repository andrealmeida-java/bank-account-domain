package model.entities;

import model.exception.DomainException;

public class Account {

	private Integer number;
	private String holder;
	private double balance;
	private double withdrawLimit;
	
	public Account() {
		this.balance = 0.0;
		this.withdrawLimit = 0.0;
	}

	public Account(Integer number, String holder, double balance, double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}


	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	public void deposit(double amount) {
		if(amount <= 0) {
			throw new DomainException("Deposit amount must be positiver");
		}
		balance += amount;
	}
	
	public void withdraw(double amount) {
		if(amount <= 0) {
			throw new DomainException("Deposit amount must be positive");
		}
		if(withdrawLimit < amount) {
			throw new DomainException("The amount exceeds withdraw limit");
		}
		if(balance < amount) {
			throw new DomainException("Not enough balance");
		}
		balance -= amount;
	}

}
