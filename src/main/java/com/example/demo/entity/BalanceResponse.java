package com.example.demo.entity;

public class BalanceResponse
{
	String status;
	String[] error;
	Balance balance;
	
	public BalanceResponse() {}
	
	public BalanceResponse(String status, String[] error, Balance balance)	{
		this.status = status;
		this.error = error;
		this.balance = balance;
	}

	public String getStatus()	{
		return status;
	}

	public void setStatus(String status)	{
		this.status = status;
	}

	public String[] getError()	{
		return error;
	}

	public void setError(String[] error)	{
		this.error = error;
	}

	public Balance getBalance()	{
		return balance;
	}

	public void setBalance(Balance balance)	{
		this.balance = balance;
	}
}
