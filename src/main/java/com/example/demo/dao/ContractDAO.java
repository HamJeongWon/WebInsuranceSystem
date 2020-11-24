package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer.Customer;

import java.util.HashMap;
import java.util.Vector;


import com.example.demo.model.Contract.Contract;


@Repository("com.example.demo.dao.ContractDAO")
public interface ContractDAO{
	
	public int SelectMaxID();
	
	public int CheckInsuranceName(String record);

	public Vector<Contract> searchUnpaidCustomer() throws Exception;
		
	public Customer findCustomer(int customerID) throws Exception;

	public void createContract(Contract contract) throws Exception;

	public Vector<HashMap<String, Object>> searchFullContractCustomers(String now);

	public Contract searchContract(int contractID);
	
	public void updateContract(Contract contract);

}
