package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional     //used for sending warning cmd to DB (i.e before create cmd "begin transaction" cmd is send to database)
public class CustomerService {
	
	@Autowired   
	private CustomerRepository repo;    //object reference dependency injection  //if not used autowired exception as "repo" object is null so it will throw null ptr exception error 
	
	//retrieve all
	public List<Customer> readAll()
	{
		return repo.findAll();
	}
	
	//create and update 
	
	public void insert(Customer customer)
	{
		repo.save(customer);
	}
	
	//read single value
	
	public Customer read(Integer id)
	{
		return repo.findById(id).get();
	}
	
	//delete
	
	public void delete(Integer id)
	{
		repo.deleteById(id);
	}
}
