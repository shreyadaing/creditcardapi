package com.creditcard.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.creditcard.model.CreditCard;
import com.creditcard.service.CreditCardsService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@EnableAutoConfiguration
public class CreditCardsController {

	@Autowired
	CreditCardsService service;
	
	@GetMapping("/api")
	public String welcome() {

		return "Welcome to the Credit Card Services API.";

	}

	@GetMapping("/api/credit-cards")
	@ApiOperation(value = "Finds all credit cards available", notes = "Lists all credit cards in the system", response = String.class)
	@ApiResponses({ 
		@ApiResponse(code = 201, message = "Fetched all credit cards successfully."),
		@ApiResponse(code = 500, message = "Failure")
	})
	public Iterable<CreditCard> getAllCreditCards() {

		return service.getAllCreditCards();

	}

	@PostMapping(path = "/api/credit-cards")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Creates a new credit card with given information", notes = "Creates a new Credit Card in the system", response = CreditCard.class)
	@ApiResponses({ 
		@ApiResponse(code = 201, message = "Credit Card Added Succesfully"),
		@ApiResponse(code = 400, message = "Bad Request"),
		@ApiResponse(code = 500, message = "Failure")
	})
	public void addCreditCard(@Valid @RequestBody CreditCard card) {
		
		service.addCreditCard(card);	
	}

	
	
	@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason = "Some parameters are invalid. Please check.")
	public void onIllegalArgumentException(IllegalArgumentException exception) {
		
	}

}
