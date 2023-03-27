package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{	
	public Optional<Customer> findByEmail(String email);
	
}
