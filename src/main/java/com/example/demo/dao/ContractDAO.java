package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer.Customer;

@Repository("com.example.demo.dao.ContractDAO")
public interface ContractDAO {

	public Customer findCustomer(int customerID) throws Exception;

}
