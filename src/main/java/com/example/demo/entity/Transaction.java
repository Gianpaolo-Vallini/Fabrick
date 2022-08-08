package com.example.demo.entity;

public class Transaction
{
	String transactionId;
	String operationId;
	String accountingDate;
	String valueDate;
	TransactionType transactionType;
	Double amount;
	String currency;
	String description;
	
	public Transaction() {}
	
	public Transaction(String transactionId, String operationId, String accountingDate, String valueDate,
			TransactionType transactionType, Double amount, String currency, String description)	{
		this.transactionId = transactionId;
		this.operationId = operationId;
		this.accountingDate = accountingDate;
		this.valueDate = valueDate;
		this.transactionType = transactionType;
		this.amount = amount;
		this.currency = currency;
		this.description = description;
	}

	public String getTransactionId()	{
		return transactionId;
	}

	public void setTransactionId(String transactionId)	{
		this.transactionId = transactionId;
	}

	public String getOperationId()	{
		return operationId;
	}

	public void setOperationId(String operationId)	{
		this.operationId = operationId;
	}

	public String getAccountingDate()	{
		return accountingDate;
	}

	public void setAccountingDate(String accountingDate)	{
		this.accountingDate = accountingDate;
	}

	public String getValueDate()	{
		return valueDate;
	}

	public void setValueDate(String valueDate)	{
		this.valueDate = valueDate;
	}

	public TransactionType getTransactionType()	{
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType)	{
		this.transactionType = transactionType;
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

	public String getDescription()	{
		return description;
	}

	public void setDescription(String description)	{
		this.description = description;
	}
}
