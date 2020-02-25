package com.creditcard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creditcard.CreditCardsRepository;
import com.creditcard.model.CreditCard;

@Service
public class CreditCardsService {
	
	@Autowired(required = true)
	public CreditCardsRepository creditCardRepo;

	
	public CreditCard addCreditCard(CreditCard card) {
		return creditCardRepo.save(card);
	}
	
	public Iterable<CreditCard> getAllCreditCards(){
		return creditCardRepo.findAll();
	}
}
