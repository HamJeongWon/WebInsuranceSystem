package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer.ActualCost;
import com.example.demo.model.Customer.Building;
import com.example.demo.model.Customer.Car;
import com.example.demo.model.Customer.Customer;
import com.example.demo.model.Customer.PersonalInformation;
import com.example.demo.model.Insurance.Insurance;


@Repository("com.example.demo.dao.CustomerDAO")
public interface CustomerDAO{
	
	public int SelectMaxID();
	
	public int CheckInsuranceName(String record)throws Exception;

	public void insertBuilding(HashMap<String, Object> hash)throws Exception;

	public void insertCar(HashMap<String, Object> hash)throws Exception;

	public void insertActualCost(HashMap<String, Object> hash)throws Exception;

	public void insertCustomer(Customer customer)throws Exception;

	public void insertPersonalInformation(HashMap<String, Object> hash)throws Exception;
	
	

	public PersonalInformation findPersonalInformation(int customerID) throws Exception;

	public Insurance getInsuranceType(int insuranceID) throws Exception;

	public Building findBuildingCustomer(int customerID)throws Exception;

	public Car findCarCustomer(int customerID)throws Exception;

	public ActualCost findActualCostCustomer(int customerID)throws Exception;
}
