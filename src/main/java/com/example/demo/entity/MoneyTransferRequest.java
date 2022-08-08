package com.example.demo.entity;

public class MoneyTransferRequest
{
	Creditor creditor;
	String description;
	Double amount;
	String currency;
	
	public MoneyTransferRequest() {}
	
	public MoneyTransferRequest(Creditor creditor, String description, Double amount, String currency)	{
		this.creditor = creditor;
		this.description = description;
		this.amount = amount;
		this.currency = currency;
	}

	public Creditor getCreditor()	{
		return creditor;
	}

	public void setCreditor(Creditor creditor)	{
		this.creditor = creditor;
	}

	public String getDescription()	{
		return description;
	}

	public void setDescription(String description)	{
		this.description = description;
	}

	public Double getAmount()	{
		return amount;
	}

	public void setAmount(Double amount)	{
		this.amount = amount;
	}

	public String getCurrency()	{
		return currency;
	}

	public void setCurrency(String currency)	{
		this.currency = currency;
	}
}
