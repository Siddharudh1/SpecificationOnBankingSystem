package com.sixdee.hibernteApplication.services;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.sixdee.hibernteApplication.entity.Customer;
import com.sixdee.hibernteApplication.pagingAndSpecification.PageResponse;

public interface CustomerServices {
	Customer saveCustomer(Customer cust);//Account
	Customer addMoney(int balance,int customerId);
	Customer withDrawMoney(int balance,int customerId);
	void deleteAccount(int customerId);
	PageResponse<Customer> findAllCustomer(Pageable pageable, Specification<Customer> spec);	
	
}
