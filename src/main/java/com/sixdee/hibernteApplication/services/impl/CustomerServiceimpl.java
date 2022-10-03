package com.sixdee.hibernteApplication.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.sixdee.hibernteApplication.entity.Customer;
import com.sixdee.hibernteApplication.pagingAndSpecification.PageResponse;
import com.sixdee.hibernteApplication.repository.CustomerRepository;
import com.sixdee.hibernteApplication.services.CustomerServices;
@Service
public class CustomerServiceimpl implements CustomerServices{
	@Autowired
	private CustomerRepository repo;

	public CustomerServiceimpl(CustomerRepository repo) {
		super();
		this.repo = repo;
	}
	

	public CustomerServiceimpl() {
		super();
	}


	@Override
	public Customer saveCustomer(Customer cust) {
		return repo.save(cust);
	}

	@Override
	public Customer addMoney(int balance, int customerId) {
		Customer cust = repo.findById(customerId).orElseThrow(null);
		int newbal = cust.getBalance()+balance;
		cust.setBalance(newbal);
		repo.save(cust);
		return cust;
	}

	@Override
	public Customer withDrawMoney(int balance, int customerId) {
		Customer cust = repo.findById(customerId).orElseThrow(null);
		int newbal = cust.getBalance()-balance;
		cust.setBalance(newbal);
		repo.save(cust);
		return cust;
	}

	@Override
	public void deleteAccount(int customerId) {
		repo.findById(customerId).orElseThrow(null);
		repo.deleteById(customerId);
	}

	@Override
	public PageResponse<Customer> findAllCustomer(Pageable pageable, Specification<Customer> spec) {
		
		return (PageResponse<Customer>) repo.findAll(spec, pageable);
	}

}
