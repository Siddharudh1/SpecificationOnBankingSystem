package com.sixdee.hibernteApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.sixdee.hibernteApplication.annotation.And;

import com.sixdee.hibernteApplication.entity.Customer;
import com.sixdee.hibernteApplication.pagingAndSpecification.PageResponse;
import com.sixdee.hibernteApplication.repository.CustomerRepository;

import com.sixdee.hibernteApplication.services.CustomerServices;

import net.kaczmarzyk.spring.data.jpa.domain.Equal;

import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;



@RestController
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	private  CustomerRepository repo;
	private CustomerServices as;

	public CustomerController(CustomerServices as) {
		super();
		this.as = as;
	}
	
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer cust){
		System.out.println("Account created..........");
		return new ResponseEntity<Customer>(as.saveCustomer(cust),HttpStatus.CREATED);
	}
	
	@PutMapping("/{customerId}/{balance}")
	public ResponseEntity<Customer> addMoney(@PathVariable("customerId") int customerId,@PathVariable("balance") int balance){
		System.out.println("Money added......");
		return new ResponseEntity<Customer>(as.addMoney(customerId, balance), HttpStatus.OK);
	}
	@PutMapping("/withdrawMoney/{customerId}/{balance}")
	public ResponseEntity<Customer> withDrawMoney(@PathVariable("customerId") int customerId,@PathVariable("balance") int balance){
		System.out.println("Money wuthDraw successfully......");
		return new ResponseEntity<Customer>(as.withDrawMoney(balance, customerId), HttpStatus.OK);
	}
		
	@DeleteMapping("{customerId}")
	public ResponseEntity<Customer> deleteAccount(@PathVariable("customerId") int customerId){
		as.deleteAccount(customerId);
		System.out.println("Account Deleted");
		return new ResponseEntity<Customer>(HttpStatus.OK);
	}
    @GetMapping(value = "/pagination")
    Page pagination(Pageable pageable) {
    	return repo.findAll(pageable);
	  }
    
    @GetMapping(path="/getCustomer")
    public PageResponse<Customer> getCustomer(
            @RequestParam(value = "customerId", required =false) Integer customerId,
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "userName", required = false) String userName,
            @RequestParam(value = "lastName", required = false) String lastName,
            @RequestParam(value = "age", required = false) Integer age,
            @RequestParam(value = "address", required = false) String address,
            @RequestParam(value = "mobileNumber", required = false) String mobileNumber,
            @RequestParam(value = "dateOfBirth", required = false) String dateOfBirth,
            @RequestParam(value = "balance", required = false) Integer balance,
            
            @RequestParam(value = "page", defaultValue = "1", required = false) int page,
            @RequestParam(value = "size", defaultValue = "0", required = false) int size,
            @RequestParam(value = "sort", defaultValue = "createdDate", required = false) String sort,
            @RequestParam(value = "order", defaultValue = "desc", required = false) String order,
            @And({ 
                @Spec(path = "CustomerbyId", params = "customerId", spec = Equal.class),
                @Spec(path = "CustomerbyUserName", params = "userName", spec = Equal.class)}) 
       
            Specification<Customer> spec) {

        Pageable pageable = (size != 0
                ? PageRequest.of(page - 1, size,order.trim().equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC,sort)
                : Pageable.unpaged());
        return as.findAllCustomer(pageable,spec);
    }
    
 
}