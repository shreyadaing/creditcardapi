package com.creditcard;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.creditcard.controller.CreditCardsController;
import com.creditcard.model.CreditCard;
import com.creditcard.service.CreditCardsService;


public class CreditCardsControllerTest extends AbstractCreditCardAPITest{
	
	@Override
	@Before
	public void setUp() {
		super.setUp();
	}
	
	@Mock
	CreditCardsRepository repo;
	
	@Mock
	CreditCardsService service;
	
	@InjectMocks
	CreditCardsController controller;
	
	@Test
	public void testAddCreditCard() {
		String uri = "/api/credit-cards";
		
		when(service.addCreditCard(any(CreditCard.class))).thenReturn(any(CreditCard.class));
		
		//Build a GET request and send it to the server
		MvcResult result = null;
		try {
			
			result = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int responseStatus = result.getResponse().getStatus();	
		assertEquals(200,responseStatus);	
	}
	
	@Test
	public void testGetAllCreditCards() {
		List<CreditCard> cardsList = new ArrayList<CreditCard> ();
		List<CreditCard> resultList = new ArrayList<CreditCard>();
		
		CreditCard cardOne = new CreditCard("Neha","5376600184210906",30000);
		CreditCard cardTwo = new CreditCard("Sneha","2221003663266461",19000);
		CreditCard cardThree = new CreditCard("Alpa","3545112186839170",90000);
		
		cardsList.add(cardOne);
		cardsList.add(cardTwo);
		cardsList.add(cardThree);
		
		//when(repo.findAll()).thenReturn(cardsList);
		when(service.getAllCreditCards()).thenReturn(cardsList);
		
		//when
		resultList = (List<CreditCard>) controller.getAllCreditCards();
		
		//then	
		assertThat(resultList.size()).isEqualTo(3);
		
			
	}

	
}
