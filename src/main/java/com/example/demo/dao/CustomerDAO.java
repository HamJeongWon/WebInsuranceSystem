package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer.ActualCost;
import com.example.demo.model.Customer.Building;
import com.example.demo.model.Customer.Car;
import com.example.demo.model.Customer.Customer;
import com.example.demo.model.Customer.PersonalInformation;


@Repository("com.example.demo.dao.CustomerDAO")
public interface CustomerDAO{
	
	public int SelectMaxID();
	
	public int CheckInsuranceName(String record);
	
	public String getInsuranceType(int insuranceID);

	public PersonalInformation findPersonalInformationByCutomerID(int customerID);

	public void insertBuilding(HashMap<String, Object> hash);

	public void insertCar(HashMap<String, Object> hash);

	public void insertActualCost(HashMap<String, Object> hash);

	public void insertCustomer(Customer customer);

	public void insertPersonalInformation(HashMap<String, Object> hash);

	public Car getCar(int customerID);

	public float getBuildingPrice(int customerID);

	public ActualCost getActualCost(int customerID);

	public void updatePersonalInformation(HashMap<String, Object> hash);
}
