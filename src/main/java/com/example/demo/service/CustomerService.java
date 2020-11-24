package com.example.demo.service;

import java.util.HashMap;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.example.demo.dao.CustomerDAO;
import com.example.demo.model.Customer.ActualCost;
import com.example.demo.model.Customer.Building;
import com.example.demo.model.Customer.Car;
import com.example.demo.model.Customer.Customer;
import com.example.demo.model.Customer.PersonalInformation;


@Service("com.example.demo.service.CustomerService")
public class CustomerService {
	
    @Resource(name="com.example.demo.dao.CustomerDAO")
    CustomerDAO customerDAO;
    
    public int SelectMaxID()throws Exception  {
    	return customerDAO.SelectMaxID();
    }
    
    public int CheckInsuranceName(String record)throws Exception  {  	
    	return customerDAO.CheckInsuranceName(record);
    }
    
	public void insertBuilding(Building building, int customerID) throws Exception{
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("customerID", customerID);
		hash.put("buildingAddress", building.getBuildingAddress());
		hash.put("buildingPrice", building.getBuildingPrice());
		hash.put("buildingScale", building.getBuildingScale());
		customerDAO.insertBuilding(hash);
	}

	public void insertCar(Car car, int customerID) throws Exception {
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("customerID", customerID);
		hash.put("carNumber", car.getCarNumber());
		hash.put("carType", car.getCarType());
		hash.put("carCareer", car.getDrivingCareer());
		hash.put("licenseType", car.getLicenseType());
		customerDAO.insertCar(hash);
	}

	public void insertActualCost(ActualCost actualCost, String stringFamilyHistory, int customerID) throws Exception {
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("customerID", customerID);
		hash.put("bloodType", actualCost.getBloodType());
		hash.put("diseaseHistory", actualCost.getDiseaseHistory());
		hash.put("FamilyHistory", stringFamilyHistory);
		customerDAO.insertActualCost(hash);
	}

	public void insertCustomer(Customer customer)throws Exception  {
		customerDAO.insertCustomer(customer);
	}

	public void insertPersonalInformation(PersonalInformation personalInformation, String job, int customerID)throws Exception  {
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("customerID", customerID);
		hash.put("accidentHistory", personalInformation.getAccidentHistory());
		hash.put("accountNumber", personalInformation.getAccountNumber());
		hash.put("residentRegistrationNumber", personalInformation.getResidentRegistrationNumber());
		hash.put("gender", personalInformation.getGender());
		hash.put("job", job);
		hash.put("property", personalInformation.getProperty());
		customerDAO.insertPersonalInformation(hash);
	}
	
   
}
