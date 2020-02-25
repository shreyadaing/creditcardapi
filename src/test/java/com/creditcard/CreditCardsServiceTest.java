package com.creditcard;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.creditcard.model.CreditCard;

public class CreditCardsServiceTest extends AbstractCreditCardAPITest {
	
	@Mock
	CreditCardsRepository repo;
	
	@Before
	public void setUp() {
		super.setUp();
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getAllCreditCardsTest() {
		List<CreditCard> cardsList = new ArrayList<CreditCard> ();
		CreditCard cardOne = new CreditCard("Neha","5376600184210906",30000);
		CreditCard cardTwo = new CreditCard("Sneha","2221003663266461",19000);
		CreditCard cardThree = new CreditCard("Alpa","3545112186839170",90000);
		
		cardsList.add(cardOne);
		cardsList.add(cardTwo);
		cardsList.add(cardThree);
		
		when(repo.findAll()).thenReturn(cardsList);	
	}
	
	@Test
	public void createEmployeeTest() {
		CreditCard card = new CreditCard("Steph","349348388346549",120000);
		
		repo.save(card);
		
		verify(repo,times(1)).save(card);
	}

}
