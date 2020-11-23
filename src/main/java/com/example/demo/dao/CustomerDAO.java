package com.example.demo.dao;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer.Customer;


@Repository("com.example.demo.dao.CustomerDAO")
public interface CustomerDAO{
	
	public int SelectMaxID();
	
	public int CheckInsuranceName(String record);

	public void insertBuilding(HashMap<String, Object> hash);

	public void insertCar(HashMap<String, Object> hash);

	public void insertActualCost(HashMap<String, Object> hash);

	public void insertCustomer(Customer customer);

	public void insertPersonalInformation(HashMap<String, Object> hash);
}
