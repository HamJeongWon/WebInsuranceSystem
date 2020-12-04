package com.example.demo.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ContractDAO;
import com.example.demo.dao.CustomerDAO;
import com.example.demo.dao.SubscriptionDAO;
import com.example.demo.model.Insurance.Insurance.InsuranceType;
import com.example.demo.model.Subscription.Subscription;
import com.example.demo.model.Contract.Contract;
import com.example.demo.model.Contract.Contract.PaymentType;
import com.example.demo.model.Customer.ActualCost;
import com.example.demo.model.Customer.Car;
import com.example.demo.model.Customer.Customer;
import com.example.demo.model.Customer.PersonalInformation;
import com.example.demo.model.Insurance.Insurance;


@Service("com.example.demo.service.ContractService")
public class ContractService {
	
    @Resource(name="com.example.demo.dao.ContractDAO")
    ContractDAO contractDAO;
    
    public int SelectMaxID() {
    	return contractDAO.SelectMaxID();
    }
    
	public Vector<String> searchUnpaidCustomer() throws Exception {
		Vector<Contract> VecContract = contractDAO.searchUnpaidCustomer();
		Vector<String> unpaidVec = new Vector<String>();

		for(Contract contract : VecContract) {			
			Customer customer = contractDAO.findCustomer(contract.getCustomerID());
			unpaidVec.add(Integer.toString(contract.getContractID()));
			unpaidVec.add(customer.getCustomerName());
			unpaidVec.add(customer.getPhoneNum());
			java.util.Date date = contract.getPaymentDate();
			String PaymentDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
			unpaidVec.add(String.valueOf(PaymentDate));
			//unpaidVec.add(String.valueOf(contract.getPaymentDate()).toString());
			unpaidVec.add(String.valueOf(contract.getPaymentStatus()));
			unpaidVec.add(String.valueOf(contract.getPaymentType()));
		}
		return unpaidVec;
	}

	public float CalculatePremiumRateCar(Car car, float insuranceFee) {
		float insurancePremiumRate = insuranceFee;

		switch (car.getJob()) {
		case soldier:
			insurancePremiumRate = (float) (insurancePremiumRate * 0.7);
			break;
		case constructionLaborer:
			insurancePremiumRate = (float) (insurancePremiumRate * 0.8);
			break;
		case driver:
			insurancePremiumRate = (float) (insurancePremiumRate * 1.5);
			break;
		case fireman:
			insurancePremiumRate = (float) (insurancePremiumRate * 1.1);
			break;
		case officeWorker:
			insurancePremiumRate = (float) (insurancePremiumRate * 0.7);
			break;
		case policeman:
			insurancePremiumRate = (float) (insurancePremiumRate * 1.2);
			break;
		case theOther:
			insurancePremiumRate = (float) (insurancePremiumRate * 1.0);
			break;
		default:
			insurancePremiumRate = (float) (insurancePremiumRate * 1.0);
			break;
		}
		if (car.getGender()) {
			insurancePremiumRate = (float) (insurancePremiumRate * 0.8);
		} else if (!car.getGender()) {
			insurancePremiumRate = (float) (insurancePremiumRate * 1.2);
		}

		switch (car.getCarType()) {
		case FullSize:
			insurancePremiumRate = (float) (insurancePremiumRate * 1.3);
			break;
		case Compact:
			insurancePremiumRate = (float) (insurancePremiumRate * 1.0);
			break;
		case Midsize:
			insurancePremiumRate = (float) (insurancePremiumRate * 0.7);
			break;
		default:
			insurancePremiumRate = (float) (insurancePremiumRate * 1.0);
			break;
		}

		switch (car.getLicenseType()) {
		case Class1:
			insurancePremiumRate = (float) (insurancePremiumRate * 0.8);
			break;
		case Class2:
			insurancePremiumRate = (float) (insurancePremiumRate * 1.1);
			break;
		case HGV:
			insurancePremiumRate = (float) (insurancePremiumRate * 1.1);
			break;
		default:
			insurancePremiumRate = (float) (insurancePremiumRate * 1.0);
			break;
		}

		if (car.getDrivingCareer() > 20) {
			insurancePremiumRate = (float) (insurancePremiumRate * 0.5);
		} else if (car.getDrivingCareer() > 15) {
			insurancePremiumRate = (float) (insurancePremiumRate * 0.75);
		} else if (car.getDrivingCareer() > 10) {
			insurancePremiumRate = (float) (insurancePremiumRate * 1.0);
		} else if (car.getDrivingCareer() > 5) {
			insurancePremiumRate = (float) (insurancePremiumRate * 1.25);
		} else if (car.getDrivingCareer() <= 5) {
			insurancePremiumRate = (float) (insurancePremiumRate * 1.5);
		}

		return insurancePremiumRate;
	}
	

	public float CalculatePremiumRateOfFire(float buildingP, float insuranceFee) {
		float insurancePremiumRate = insuranceFee;
		float buildingPrice = buildingP / 100000000;
		if (buildingPrice > 50) {
			insurancePremiumRate = (float) (insurancePremiumRate * 6.0);
		} else if (buildingPrice > 45) {
			insurancePremiumRate = (float) (insurancePremiumRate * 5.5);
		} else if (buildingPrice > 40) {
			insurancePremiumRate = (float) (insurancePremiumRate * 5.0);
		} else if (buildingPrice > 35) {
			insurancePremiumRate = (float) (insurancePremiumRate * 4.5);
		} else if (buildingPrice > 30) {
			insurancePremiumRate = (float) (insurancePremiumRate * 4.0);
		} else if (buildingPrice > 25) {
			insurancePremiumRate = (float) (insurancePremiumRate * 3.5);
		} else if (buildingPrice > 20) {
			insurancePremiumRate = (float) (insurancePremiumRate * 3.0);
		} else if (buildingPrice > 15) {
			insurancePremiumRate = (float) (insurancePremiumRate * 2.5);
		} else if (buildingPrice > 10) {
			insurancePremiumRate = (float) (insurancePremiumRate * 2.0);
		} else if (buildingPrice > 5) {
			insurancePremiumRate = (float) (insurancePremiumRate * 1.5);
		} else if (buildingPrice <= 5) {
			insurancePremiumRate = (float) (insurancePremiumRate * 1.0);
		}
		return insurancePremiumRate;
	}
	
	public float CalculatePremiumRateActual(ActualCost actualCost, float insuranceFee) {
		float insurancePremiumRate = insuranceFee;

		switch (actualCost.getJob()) {
		case soldier:
			insurancePremiumRate = (float) (insurancePremiumRate * 0.7);
			break;
		case constructionLaborer:
			insurancePremiumRate = (float) (insurancePremiumRate * 1.3);
			break;
		case driver:
			insurancePremiumRate = (float) (insurancePremiumRate * 1.1);
			break;
		case fireman:
			insurancePremiumRate = (float) (insurancePremiumRate * 1.2);
			break;
		case officeWorker:
			insurancePremiumRate = (float) (insurancePremiumRate * 0.9);
			break;
		case policeman:
			insurancePremiumRate = (float) (insurancePremiumRate * 1.3);
			break;
		case theOther:
			insurancePremiumRate = (float) (insurancePremiumRate * 1.0);
			break;
		default:
			insurancePremiumRate = (float) (insurancePremiumRate * 1.0);
			break;
		}
		if (actualCost.getGender()) {
			insurancePremiumRate = (float) (insurancePremiumRate * 1.1);
		} else if (!actualCost.getGender()) {
			insurancePremiumRate = (float) (insurancePremiumRate * 0.9);
		}

		switch (actualCost.getBloodType()) {
		case A:
			insurancePremiumRate = (float) (insurancePremiumRate * 0.8);
			break;
		case AB:
			insurancePremiumRate = (float) (insurancePremiumRate * 1.2);
			break;
		case B:
			insurancePremiumRate = (float) (insurancePremiumRate * 1.1);
			break;
		case O:
			insurancePremiumRate = (float) (insurancePremiumRate * 0.9);
			break;
		case RHMinus:
			insurancePremiumRate = (float) (insurancePremiumRate * 1.5);
			break;
		default:
			insurancePremiumRate = (float) (insurancePremiumRate * 1.0);
			break;
		}

		switch (actualCost.getDiseaseHistory()) {
		case Cancer:
			insurancePremiumRate = (float) (insurancePremiumRate * 1.7);
			break;
		case Diabetes:
			insurancePremiumRate = (float) (insurancePremiumRate * 1.5);
			break;
		case Hyperlipidemia:
			insurancePremiumRate = (float) (insurancePremiumRate * 1.2);
			break;
		case Hypertension:
			insurancePremiumRate = (float) (insurancePremiumRate * 1.6);
			break;
		case MyocardialInfarction:
			insurancePremiumRate = (float) (insurancePremiumRate * 1.5);
			break;
		case Stroke:
			insurancePremiumRate = (float) (insurancePremiumRate * 1.5);
			break;
		default:
			insurancePremiumRate = (float) (insurancePremiumRate * 0.8);
			break;
		}

		if (actualCost.getFamilyHistory().substring(0,1).equals("부")) {
			insurancePremiumRate = (float) (insurancePremiumRate * 1.5);
		} else if (actualCost.getFamilyHistory().substring(0,1).equals("모")) {
			insurancePremiumRate = (float) (insurancePremiumRate * 1.5);
		} else {
			insurancePremiumRate = (float) (insurancePremiumRate * 0.8);
		}
		return insurancePremiumRate;
	}

	public Contract createContract(int contractID, int customerID,
			String contractExpirationDate, int paymentAmout, String paymentDate, int paymentPeriod,
			PaymentType paymentType) throws Exception {

		SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

		java.util.Date JcontractExpirationDate = null;
		try {
			JcontractExpirationDate = (java.util.Date) SDF.parse(contractExpirationDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		java.util.Date JpaymentDate = null;
		try {
			JpaymentDate = (java.util.Date) SDF.parse(paymentDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Calendar cal = Calendar.getInstance();
		cal.setTime(JcontractExpirationDate);
		cal.add(Calendar.YEAR, 3);
		java.util.Date JPersonalInformationRetentionPeriod = (java.util.Date) cal.getTime();

		Contract contract = new Contract();
		contract.setContractID(contractID);
		contract.setCustomerID(customerID);
		contract.setContractExpirationDate(JcontractExpirationDate);
		contract.setPaymentAmount(paymentAmout);
		contract.setPaymentDate(JpaymentDate);
		contract.setPaymentPeriod(paymentPeriod);
		contract.setPaymentStatus(true);
		contract.setPaymentType(paymentType);
		contract.setPersonalInformationRetentionPeriod(JPersonalInformationRetentionPeriod);

		contractDAO.createContract(contract);
		
		return contract;
	}

	public Vector<String> searchFullContractCustomers() throws Exception{
		Calendar cal = new GregorianCalendar();
		Date nowTime = new Date(cal.getTimeInMillis());
		String now = nowTime.toString();

		Vector<String> VecString = new Vector<String>();
		Vector<HashMap<String, Object>> VecFullContract = contractDAO.searchFullContractCustomers(now);
		for(HashMap<String, Object> vec : VecFullContract) {		
			VecString.add(vec.get("contractID").toString());
			VecString.add(vec.get("customerID").toString());
			VecString.add(vec.get("customerName").toString());
			VecString.add(vec.get("contarctExplrationDate").toString());
			VecString.add(vec.get("personalInformationRetentionPeriod").toString());
		}
		return VecString;
	}

	public void updateContract(int contractID, int customerID, String paymentDate, PaymentType paymentType,
			String contractExpirationDate) throws Exception {
		
		SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
		
		java.util.Date JpaymenDate = null;		
		try {
			JpaymenDate = (java.util.Date) SDF.parse(paymentDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		java.util.Date JContractExpirationDate = null;
		try {
			JContractExpirationDate = (java.util.Date) SDF.parse(contractExpirationDate);
		} catch (ParseException e) {	
			e.printStackTrace();
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(JContractExpirationDate);
		cal.add(Calendar.YEAR, 3);
		
		java.util.Date JPersonalInformationRetentionPeriod = (java.util.Date) cal.getTime();
		
		Contract contract = new Contract();		
		contract.setContractID(contractID);		
		contract.setPaymentDate(JpaymenDate);
		contract.setPaymentType(paymentType);
		contract.setContractExpirationDate(JContractExpirationDate);
		contract.setPersonalInformationRetentionPeriod(JPersonalInformationRetentionPeriod);
		
		contractDAO.updateContract(contract);
	}

	public Contract searchContract(int contractID) throws Exception{
		Contract contract = contractDAO.searchContract(contractID);
		SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

		java.util.Date JpaymenDate = null;		
		JpaymenDate = (java.util.Date) SDF.parse(contract.getTempPaymentDate());
		
		java.util.Date JContractExpirationDate = null;
		JContractExpirationDate = (java.util.Date) SDF.parse(contract.getTempContractExpirationDate());
		
		java.util.Date JPersonalInformationRetentionPeriod = null;
		JPersonalInformationRetentionPeriod = (java.util.Date) SDF.parse(contract.getTempPersonalInformationRetentionPeriod());
		
		contract.setContractExpirationDate(JContractExpirationDate);
		contract.setPaymentDate(JpaymenDate);
		contract.setPersonalInformationRetentionPeriod(JPersonalInformationRetentionPeriod);

		return contract;
	}

	public Customer findCustomer(int customerID) throws Exception {
		Customer customer = contractDAO.findCustomer(customerID);
		return customer;
	}
}
