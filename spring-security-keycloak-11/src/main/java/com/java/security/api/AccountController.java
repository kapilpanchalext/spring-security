package com.java.security.api;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.security.model.Accounts;
import com.java.security.model.Customer;
import com.java.security.repository.AccountsRepository;
import com.java.security.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountsRepository accountsRepository;
    private final CustomerRepository customerRepository;

    @GetMapping("/myAccount")
    public Accounts getAccountDetails(@RequestParam String email) {
    	Optional<Customer> optionalCustomer = customerRepository.findByEmail(email);
    	
    	if(optionalCustomer.isPresent()) {
    		Accounts accounts = accountsRepository.findByCustomerId(optionalCustomer.get().getId());
    		if (accounts != null) {
    			return accounts;
    		} else {
    			return null;
    		}
    	} else {
    		return null;
    	}
    }
}
