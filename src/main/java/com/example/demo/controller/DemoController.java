package com.example.demo.controller;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.BalanceResponse;
import com.example.demo.entity.MoneyTransferRequest;
import com.example.demo.entity.MoneyTransferResponse;
import com.example.demo.entity.Transaction;
import com.example.demo.entity.TransactionResponse;

@RestController
public class DemoController
{
	@GetMapping("/saldo/{id}")
	public String letturaSaldo(@PathVariable Long id) {
    
		String uri = "https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/" + id.toString() + "/balance";
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();

		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Auth-Schema", "S2S");
		headers.add("Api-Key", "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP");
		
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<BalanceResponse> response = null;
		try {
			response = restTemplate.exchange(uri, HttpMethod.GET, entity, BalanceResponse.class);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		String result = "";
		if((response != null) && (response.getBody() != null) && (response.getBody().getStatus().equals("OK"))) {
			result = response.getBody().getBalance().toString();
		}
		
		return result;
	}
	
	@GetMapping("/transazioni/{id}")
	public Transaction[] letturaTransazioni(@PathVariable Long id, @RequestParam(name = "fromAccountingDate") String fromAccountingDate, @RequestParam(name = "toAccountingDate") String toAccountingDate) {
    
		String uri = "https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/" + id.toString() + "/transactions?fromAccountingDate=" + fromAccountingDate + "&toAccountingDate=" + toAccountingDate;
			
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();

		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Auth-Schema", "S2S");
		headers.add("Api-Key", "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP");
		
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<TransactionResponse> response = null;
		try {
			response = restTemplate.exchange(uri, HttpMethod.GET, entity, TransactionResponse.class);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		Transaction[] result = null;
		if((response != null) && (response.getBody() != null) && (response.getBody().getStatus().equals("OK"))) {
			result = response.getBody().getTransactions();
		}
		
		return result;

	}
	
	@PostMapping("/bonifico/{id}")
	public String eseguiBonifico(@PathVariable Long id, @RequestBody MoneyTransferRequest moneyTransferRequest) {
    
		String uri = "https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/" + id.toString() + "/payments/money-transfers";
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();

		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Auth-Schema", "S2S");
		headers.add("Api-Key", "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP");
		
		HttpEntity<MoneyTransferRequest> httpEntity = new HttpEntity<>(moneyTransferRequest, headers);
		
		MoneyTransferResponse responseMoneyTransfer = null;
		try {
			responseMoneyTransfer = restTemplate.postForObject(uri, httpEntity, MoneyTransferResponse.class);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		String result = null;
		if((responseMoneyTransfer != null) && (responseMoneyTransfer.getStatus() != null) && (responseMoneyTransfer.getStatus().equals("EXECUTED"))) {
			result = responseMoneyTransfer.getStatus();
		}
		
		return result;
	}
}
