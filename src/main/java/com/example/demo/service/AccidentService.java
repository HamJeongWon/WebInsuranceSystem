package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AccidentDAO;
import com.example.demo.model.Accident.Accident;

@Service("com.example.demo.service.AccidentService")
public class AccidentService {
	
	@Resource(name="com.example.demo.dao.AccidentDAO")
	AccidentDAO accidentDAO;
	
	public List<Accident> showAllAccidentIDFromPaymentAccidentFund() throws Exception{
		return accidentDAO.showAllAccidentIDFromPaymentAccidentFund();
	}

	public Accident resultMentAccidentReception(int num,List<Integer> accidentIDList,String accidentDate,String accidentTime,String accidentCause,String accidentLocation,String expertOpinion) throws Exception{
		int index = num - 2;

		int insuranceID = accidentIDList.get(index);
		int customerID = accidentIDList.get(index+1);

		Accident accident = new Accident();

		int accidentID;
		try {
			accidentID = accidentDAO.SelectMaxID();
		} catch (Exception e) {
			accidentID = 6000;
		}
		accidentID = accidentID+1;

		accident.setInsuranceID(insuranceID);
		accident.setCustomerID(customerID);
		accident.setAccidentID(accidentID);
		accident.setAccidentDate(accidentDate);
		accident.setAccidentTime(accidentTime+":00");
		accident.setAccidentCause(accidentCause);
		accident.setAccidentLocation(accidentLocation);
		accident.setExpertOpinion(expertOpinion);
		accidentDAO.insertAccident(accident);

		return accident;
	}
	
	public Accident resultAccidentReception (int accidentID) throws Exception{
		Accident accident = accidentDAO.findAccident(accidentID);
		return accident;
	}
	
	public List<Integer> CalculateAccidentFunds() throws Exception{
		List<Integer> accidentIDListFromCalculateAccidentFund = new ArrayList<Integer>();
		for(int i=0; i< accidentDAO.showAllAccidentIDFromCalculateAccidentFund().size(); i++) {
			accidentIDListFromCalculateAccidentFund.add(accidentDAO.showAllAccidentIDFromCalculateAccidentFund().get(i).getAccidentID());
		}
		return accidentIDListFromCalculateAccidentFund;
	}
	
	
	public Accident findAccident(int accidentID) throws Exception {
		Accident accident = accidentDAO.findAccident(accidentID);
		return accident;
	}
	
	public Accident ResultCalculateAccidentFund(int accidentID,String insurancePremium,String insurancePremiumCause)throws Exception{
		Accident accident =accidentDAO.findAccident(accidentID);	

		accident.setInsurancePremium(Integer.parseInt(insurancePremium));
		accident.setInsurancePremiumCause(insurancePremiumCause);
		accidentDAO.insertInsurancePayment(accident);
		
		return accident;


	}
	
	public void CalculateAccidentFund(int accidentID)throws Exception{
		Accident accident =accidentDAO.findAccident(accidentID);
		accident.setPayInsurancePremium(true);
		accidentDAO.updatePayInsurancePremium(accident);
	}
	
	public List<Integer> PaymentAccidentFunds()throws Exception{
		List<Integer> accidentIDListFromPaymentAccidentFund = new ArrayList<Integer>();
		
		for(int i=0; i< showAllAccidentIDFromPaymentAccidentFund().size(); i++) {
			accidentIDListFromPaymentAccidentFund.add(showAllAccidentIDFromPaymentAccidentFund().get(i).getAccidentID());
		}
		return accidentIDListFromPaymentAccidentFund;
		
	}
	
	public Accident ResultPaymentAccidentFund(int accidentID) throws Exception{
		Accident accident = accidentDAO.findAccident(accidentID);
		return accident;
		
	}

}