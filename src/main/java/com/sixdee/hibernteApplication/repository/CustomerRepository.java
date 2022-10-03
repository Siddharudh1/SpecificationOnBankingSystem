package com.sixdee.hibernteApplication.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sixdee.hibernteApplication.entity.Customer;
@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer>,JpaSpecificationExecutor{
	
}



