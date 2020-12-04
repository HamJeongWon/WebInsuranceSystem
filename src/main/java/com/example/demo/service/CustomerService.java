package com.example.demo.service;

import java.util.HashMap;
import java.util.Vector;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.model.Customer.ActualCost;
import com.example.demo.model.Customer.ActualCost.BloodType;
import com.example.demo.model.Customer.ActualCost.DiseaseHistory;
import com.example.demo.model.Customer.Building;
import com.example.demo.model.Customer.Car;
import com.example.demo.model.Customer.Car.CarType;
import com.example.demo.model.Customer.Car.LicenseType;
import com.example.demo.model.Customer.Customer;
import com.example.demo.model.Customer.PersonalInformation;
import com.example.demo.model.Customer.PersonalInformation.Job;
import com.example.demo.model.Insurance.Insurance.InsuranceType;


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

	public Building insertBuilding(int CustomerID, String buildingAddress, int buildingPrice, String buildingScale) throws Exception{
		Building building = new Building();
		building.setCustomerID(CustomerID);
		building.setBuildingAddress(buildingAddress);
		building.setBuildingPrice(buildingPrice);
		building.setBuildingScale(buildingScale);
		customerDAO.insertBuilding(building);
		return building;
	}

	public Car insertCar(int customerID, String carNumber, CarType carType, int carCareer, LicenseType licenseType) throws Exception{		
		Car car = new Car();
		car.setCustomerID(customerID);
		car.setCarNumber(carNumber);
		car.setCarType(carType);
		car.setDrivingCareer(carCareer);
		car.setLicenseType(licenseType);
		customerDAO.insertCar(car);
		return car;
	}

	public ActualCost insertActualCost(int customerID, BloodType bloodType, DiseaseHistory diseaseHistory,
			String familyDisease, String familyrelation) throws Exception{
		ActualCost actualCost = new ActualCost();
		actualCost.setCustomerID(customerID);
		actualCost.setBloodType(bloodType);
		actualCost.setDiseaseHistory(diseaseHistory);
		String familyHistory = familyrelation+":"+familyDisease;
		actualCost.setFamilyHistory(familyHistory);
		customerDAO.insertActualCost(actualCost);
		return actualCost;
	}

	public void insertCustomer(int customerID, String customerName, String phoneNum)throws Exception  {
		Customer customer = new Customer();
		customer.setCustomerID(customerID);
		customer.setCustomerName(customerName);
		customer.setPhoneNum(phoneNum);
		customerDAO.insertCustomer(customer);
	}

	
	public void insertPersonalInformation(int customerID, Job job, String accidentHistory, int accountNumber,
			int property, String residentRegistrationNumber, String sex)throws Exception  {
		PersonalInformation personalInformation = new PersonalInformation();	
		personalInformation.setCustomerID(customerID);
		personalInformation.setJob(job);
		personalInformation.setAccidentHistory(accidentHistory);
		personalInformation.setAccountNumber(accountNumber);
		personalInformation.setProperty(property);
		personalInformation.setResidentRegistrationNumber(residentRegistrationNumber);
		
		if (sex.equals("M")) {
			personalInformation.setGender(true);
		} else {
			personalInformation.setGender(false);
		}
		
		customerDAO.insertPersonalInformation(personalInformation);
	}

	public String getInsuranceType(int insuranceID) {
		return customerDAO.getInsuranceType(insuranceID);
	}

	public PersonalInformation findPersonalInformationByCutomerID(int customerID) {
		return customerDAO.findPersonalInformationByCutomerID(customerID);
	}
	
	public Car getCar(int customerID, PersonalInformation personalInformation) {
		Car car = customerDAO.getCar(customerID);
		car.setJob(personalInformation.getJob());
		car.setAccidentHistory(personalInformation.getAccidentHistory());
		car.setAccountNumber(personalInformation.getAccountNumber());
		car.setGender(personalInformation.getGender());
		car.setProperty(personalInformation.getProperty());
		car.setResidentRegistrationNumber(personalInformation.getResidentRegistrationNumber());
		return car;
	}
	
	public float getBuildingPrice(int customerID) {
		float buildingPrice = customerDAO.getBuildingPrice(customerID);
		return buildingPrice;
	}

	public ActualCost getActualCost(int customerID, PersonalInformation personalInformation) {
		ActualCost actualCost = customerDAO.getActualCost(customerID);
     
		actualCost.setJob(personalInformation.getJob());
		actualCost.setAccidentHistory(personalInformation.getAccidentHistory());
		actualCost.setAccountNumber(personalInformation.getAccountNumber());
		actualCost.setGender(personalInformation.getGender());
		actualCost.setProperty(personalInformation.getProperty());
		actualCost.setResidentRegistrationNumber(personalInformation.getResidentRegistrationNumber());
		return actualCost;
	}
	
	public void updatePersonalInformation(int customerID, int accountNumber) {
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("customerID", customerID);
		hash.put("accountNumber", accountNumber);
		customerDAO.updatePersonalInformation(hash);		
	}

	public Vector<Job> jobVector() {
		Vector<Job> VecJob = new Vector<Job>();	
		for(Job job : PersonalInformation.Job.values()) {
			VecJob.add(job);
		}
		return VecJob;
	}

	public PersonalInformation findPersonalInformation(int customerID) throws Exception {
		PersonalInformation personalInformation = customerDAO.findPersonalInformation(customerID);
		return personalInformation;
	}

	public InsuranceType getInsuranceType2(int insuranceID) throws Exception {
		InsuranceType insuranceType =customerDAO.getInsuranceType2(insuranceID).getInsuranceType();
		return insuranceType;
	}

	public void setPersonalInformation(Customer customer) throws Exception {
		customer.setPersonalInformation(customerDAO.findPersonalInformation(customer.getCustomerID()));
		
	}

	public Building findBuildingCustomer(int customerID)throws Exception {
		Building building = customerDAO.findBuildingCustomer(customerID);
		return building;
	}

	public Car findCarCustomer(int customerID)throws Exception {
		Car car = customerDAO.findCarCustomer(customerID);
		return car;
	}

	public ActualCost findActualCostCustomer(int customerID)throws Exception  {
		ActualCost actualCost = customerDAO.findActualCostCustomer(customerID);
		return actualCost;
	}

}
