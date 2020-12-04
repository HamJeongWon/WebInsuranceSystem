package com.example.demo.dao;

import java.util.HashMap;

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
	
	public String getInsuranceType(int insuranceID);

	public PersonalInformation findPersonalInformationByCutomerID(int customerID);

	public void insertBuilding(Building building)throws Exception;

	public void insertCar(Car car)throws Exception;

	public void insertActualCost(ActualCost actualCost)throws Exception;

	public void insertCustomer(Customer customer)throws Exception;

	public void insertPersonalInformation(PersonalInformation personalInformation)throws Exception;
	
	public PersonalInformation findPersonalInformation(int customerID) throws Exception;

	public Insurance getInsuranceType2(int insuranceID) throws Exception;

	public Building findBuildingCustomer(int customerID)throws Exception;

	public Car findCarCustomer(int customerID)throws Exception;

	public ActualCost findActualCostCustomer(int customerID)throws Exception;

	public Car getCar(int customerID);

	public float getBuildingPrice(int customerID);

	public ActualCost getActualCost(int customerID);

	public void updatePersonalInformation(HashMap<String, Object> hash);
}
