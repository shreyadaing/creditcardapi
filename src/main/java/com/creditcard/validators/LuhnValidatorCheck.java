package com.creditcard.validators;

import java.util.PrimitiveIterator;
import java.util.stream.IntStream;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

@Component
public class LuhnValidatorCheck implements ConstraintValidator<LuhnValidator, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		
		final PrimitiveIterator.OfInt factorBy = IntStream.iterate(1,i->3 - i).iterator();	
		final int sum = new StringBuilder(value)
						.reverse()
						.chars()
						.map(c -> c - '0')
						.map(i -> i * factorBy.nextInt())
						.reduce(0,(a,b) -> a + b / 10 + b%10);
		
		return (sum % 10) == 0;
	}

}
