package com.example.demo.service;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AccidentDAO;
import com.example.demo.dao.InsuranceDAO;
import com.example.demo.dao.SubscriptionDAO;
import com.example.demo.model.Accident.Accident;
import com.example.demo.model.Subscription.Subscription;

@Service("com.example.demo.service.InsuranceTreatmentService")
public class InsuranceTreatmentService {
	
	@Resource(name="com.example.demo.dao.AccidentDAO")
	AccidentDAO accidentDAO;
	
	@Resource(name="com.example.demo.dao.SubscriptionDAO")
	SubscriptionDAO subscriptionDAO;
	
	@Resource(name="com.example.demo.dao.InsuranceDAO")
	InsuranceDAO insuranceDAO;
	

	public List<Subscription> showSubscriptionCustomer() throws Exception{
		return subscriptionDAO.showSubscriptionCustomer();
	}

	public int SelectMaxID() throws Exception{
		return accidentDAO.SelectMaxID();
	}

	public void insertAccident(Accident accident) throws Exception {
		accidentDAO.insertAccident(accident);
		
	}

	public Accident findAccident(int accidentID) throws Exception {
		return accidentDAO.findAccident(accidentID);
	}

	public float getInsuranceFee(int insuranceID) throws Exception {
		return insuranceDAO.getInsuranceFee(insuranceID);
	}

	public List<Accident> showAllAccidentIDFromCalculateAccidentFund() throws Exception{
		return accidentDAO.showAllAccidentIDFromCalculateAccidentFund();
	}

	public void insertInsurancePayment(Accident accident) throws Exception {
		accidentDAO.insertInsurancePayment(accident);
		
	}

	public void updatePayInsurancePremium(Accident accident)  throws Exception{
		accidentDAO.updatePayInsurancePremium(accident);
		
	}

	public List<Accident> showAllAccidentIDFromPaymentAccidentFund() throws Exception{
		return accidentDAO.showAllAccidentIDFromPaymentAccidentFund();
	}

}
