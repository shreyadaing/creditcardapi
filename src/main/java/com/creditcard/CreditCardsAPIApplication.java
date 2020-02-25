package com.creditcard;


import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.creditcard"})
@EnableAutoConfiguration
@EnableSwagger2
public class CreditCardsAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditCardsAPIApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.any())
				.build()
				.apiInfo(getApiInfo());
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfo(
				"Credit Card API for credit card providers",
				"Sample API for credit card",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Shreya Daing", "", "daing.shreya@gmail.com"),
				"API License",
				"Sample url",
				Collections.emptyList());
	}
}
