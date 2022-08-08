package com.example.demo;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Account;
import com.example.demo.entity.Creditor;
import com.example.demo.entity.MoneyTransferRequest;
import com.example.demo.entity.Transaction;

@SpringBootTest
class DemoApplicationTests {
	
	final String accountId = "14537780";
	final String baseUrl = "http://localhost:8080/";

	@Test
	void testSaldo() {
	    RestTemplate restTemplate = new RestTemplate();
	    
	    ResponseEntity<String> response = null;
		try {
		    URI uri = new URI(baseUrl + "saldo/" + accountId.toString());
			response = restTemplate.getForEntity(uri, String.class);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		Assert.notNull(response);
		Assert.notNull(response.getBody());
	}
	
	@Test
	void testTransazioni() {
	    RestTemplate restTemplate = new RestTemplate();
	    
	    ResponseEntity<Transaction[]> response = null;
		try {
		    URI uri = new URI(baseUrl + "transazioni/" + accountId.toString() + "?fromAccountingDate=2019-01-01&toAccountingDate=2019-12-01");
			response = restTemplate.getForEntity(uri, Transaction[].class);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		Assert.notNull(response);
		Assert.notNull(response.getBody());
	}
	
	@Test
	void testBonifico() {
	    RestTemplate restTemplate = new RestTemplate();
	    Account account = new Account("IT23A0336844430152923804660", "SELBIT2BXXX");
	    Creditor creditor = new Creditor("Gianpaolo Vallini", account);
	    MoneyTransferRequest requestObject = new MoneyTransferRequest(creditor, "Causale del bonifico", 595.99, "EUR");
 
	    ResponseEntity<String> response = null;
		try {
		    URI uri = new URI(baseUrl + "bonifico/" + accountId.toString());
			response = restTemplate.postForEntity(uri, requestObject, String.class);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		Assert.notNull(response);
		Assert.notNull(response.getBody());
	}

}
