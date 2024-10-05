package com.example.demo;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	//RESTful API methods for Retrieval operations
	//retrieve all
	@GetMapping("/getCustomers")
	public List<Customer> listAll()
	{
		return service.readAll();
	}
	
	//retrieve single value
	
	@GetMapping("customers/{id}")
	public ResponseEntity<Customer> listOne(@PathVariable Integer id)  //
	{
		try 
		{
		Customer customer = service.read(id);
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
	}
	
	//RESTful API methods for Create operations
	//create 
	
	@PostMapping("/addCustomer")
	public void create(@RequestBody Customer customer)
	{
		
	}
	
	//update
	
	@PutMapping("/customers/{id}")
	public ResponseEntity<?> update(@RequestBody Customer customer, @PathVariable Integer id) 
	 {
		try
	 	{
			 Customer existCustomer = service.read(id);
			 service.insert(customer);
			 return new ResponseEntity<>(HttpStatus.OK);
	 	} 
	 	catch (NoSuchElementException e) 
	 	{
		 	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 	} 
	 }
	
	//delete
	
	@DeleteMapping("/customers/{id}")
	public void remove(@PathVariable Integer id)
	{
		service.delete(id);
	}

	
}
