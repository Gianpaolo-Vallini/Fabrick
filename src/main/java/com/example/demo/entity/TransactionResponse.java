package com.example.demo.entity;

public class TransactionResponse
{
	String status;
	String[] error;
	Transaction[] transactions;
	
	public TransactionResponse() {}

	public TransactionResponse(String status, String[] error, Transaction[] transactions) {
		this.status = status;
		this.error = error;
		this.transactions = transactions;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String[] getError() {
		return error;
	}

	public void setError(String[] error) {
		this.error = error;
	}

	public Transaction[] getTransactions() {
		return transactions;
	}

	public void setTransactions(Transaction[] transactions)	{
		this.transactions = transactions;
	}
}
