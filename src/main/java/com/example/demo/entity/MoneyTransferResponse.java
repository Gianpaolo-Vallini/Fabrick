package com.example.demo.entity;

public class MoneyTransferResponse
{
	String moneyTransferId;
	String status;
	String direction;
	
	public MoneyTransferResponse() {}
	
	public MoneyTransferResponse(String moneyTransferId, String status, String direction)	{
		this.moneyTransferId = moneyTransferId;
		this.status = status;
		this.direction = direction;
	}

	public String getMoneyTransferId()	{
		return moneyTransferId;
	}

	public void setMoneyTransferId(String moneyTransferId)	{
		this.moneyTransferId = moneyTransferId;
	}

	public String getStatus()	{
		return status;
	}

	public void setStatus(String status)	{
		this.status = status;
	}

	public String getDirection()	{
		return direction;
	}

	public void setDirection(String direction)	{
		this.direction = direction;
	}
}
