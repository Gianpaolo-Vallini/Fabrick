package com.example.demo.entity;

public class Balance
{
	String date;
	Double balance;
	Double availableBalance;
	String currency;
	
	public Balance() {}
	
	public Balance(String date, Double balance, Double availableBalance, String currency)	{
		this.date = date;
		this.balance = balance;
		this.availableBalance = availableBalance;
		this.currency = currency;
	}

	public String getDate()	{
		return date;
	}
	public void setDate(String date)	{
		this.date = date;
	}
	public Double getBalance()	{
		return balance;
	}
	public void setBalance(Double balance)	{
		this.balance = balance;
	}
	public Double getAvailableBalance()	{
		return availableBalance;
	}
	public void setAvailableBalance(Double availableBalance)	{
		this.availableBalance = availableBalance;
	}
	public String getCurrency()	{
		return currency;
	}
	public void setCurrency(String currency)	{
		this.currency = currency;
	}
}
