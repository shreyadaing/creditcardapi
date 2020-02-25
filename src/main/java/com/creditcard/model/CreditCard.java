package com.creditcard.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.creditcard.validators.LuhnValidator;



@Entity
public class CreditCard {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int cardId;
	
	@NotNull(message = "Card Holder name cannot be blank.")
	@Size(min=2, message="Name should have atleast 2 characters")
	private String name;
	
	@NotNull(message = "Card Number cannot be blank.")
	@Size(max=19, message="Card number cannot be longer than 19 digits.")
	@LuhnValidator
	private String cardNumber;
	private int balance = 0;
	
	@NotNull
	@Min(0)
	private int cardLimit;
	
	public CreditCard() {
		
	}
	
	public CreditCard(String name, String cardNumber, int cardLimit) {
		super();
		this.name = name;
		this.cardNumber = cardNumber;
		this.cardLimit = cardLimit;
	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getCardLimit() {
		return cardLimit;
	}
	public void setCardLimit(int cardLimit) {
		this.cardLimit = cardLimit;
	}


}
