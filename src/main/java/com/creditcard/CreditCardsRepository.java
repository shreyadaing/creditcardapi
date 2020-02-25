package com.creditcard;

import org.springframework.data.repository.CrudRepository;

import com.creditcard.model.CreditCard;

public interface CreditCardsRepository extends CrudRepository<CreditCard, Integer>{

}
