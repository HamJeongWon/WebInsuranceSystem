package com.example.demo.service;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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
	
	private List<Integer> accidentIDList = new ArrayList<Integer>();
	

	public List<Integer> showSubscriptionCustomer() throws Exception{
		for(int i=0; i<subscriptionDAO.showSubscriptionCustomer().size(); i++) {
			accidentIDList.add(subscriptionDAO.showSubscriptionCustomer().get(i).getInsuranceID());
			accidentIDList.add(subscriptionDAO.showSubscriptionCustomer().get(i).getCustomerID());
		}
		
		return accidentIDList;
	}


	public List<Accident> showAllAccidentIDFromPaymentAccidentFund() throws Exception{
		return accidentDAO.showAllAccidentIDFromPaymentAccidentFund();
	}

	public String resultMentAccidentReception(HttpServletResponse response,HttpServletRequest request, int num) throws Exception{
		
		int index = num - 2;
		
		int insuranceID = accidentIDList.get(index);
		int customerID = accidentIDList.get(index+1);
		
		Accident accident = new Accident();
		
		int accidentID = accidentDAO.SelectMaxID();
		if(accidentID == 0) {
			accidentID = 6000;
		}
		accidentID = accidentID+1;


		String accidentDate = request.getParameter("accidentDate");
		String accidentTime = String.valueOf(request.getParameter("accidentTime"));
		String accidentCause = request.getParameter("accidentCause");
		String accidentLocation = request.getParameter("accidentLocation");
		String expertOpinion = request.getParameter("expertOpinion");
		
		if(accidentDate =="" || accidentTime=="" || accidentCause=="" || accidentLocation == "" || expertOpinion == "") {
			response.sendRedirect("incl/alert.jsp");
			return null;

		}else {
			accident.setInsuranceID(insuranceID);
			accident.setCustomerID(customerID);
			accident.setAccidentID(accidentID);
			accident.setAccidentDate(accidentDate);
			accident.setAccidentTime(accidentTime+":00");
			accident.setAccidentCause(accidentCause);
			accident.setAccidentLocation(accidentLocation);
			accident.setExpertOpinion(expertOpinion);

			accidentDAO.insertAccident(accident);
			request.setAttribute("accident", accident);
			return "ResultMentAccidentReception";

		}
	
	
	
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
	
	public String InsertCalculateAccidentFund(int accidentID, Model model) throws Exception{
		Accident accident = accidentDAO.findAccident(accidentID);
		
		if(accident.getInsurancePremium() != 0 && accident.getInsurancePremiumCause() != null) {
			//이미 보험금이 산출되었을 경우
			return "error";
		}else {
			model.addAttribute("maxInsurancePremium",insuranceDAO.getInsuranceFee(accident.getInsuranceID()));
			model.addAttribute("accident", accident);
			return "InsertCalculateAccidentFund";
		}
	}
	
	public String ResultCalculateAccidentFund(int accidentID,String insurancePremium,String insurancePremiumCause,HttpServletResponse response,Model model)throws Exception{
		Accident accident =accidentDAO.findAccident(accidentID);	



		if(insurancePremium=="" || insurancePremiumCause=="") {
			response.sendRedirect("incl/alert.jsp");
			return null;

		}else {
			accident.setInsurancePremium(Integer.parseInt(insurancePremium));
			accident.setInsurancePremiumCause(insurancePremiumCause);

			accidentDAO.insertInsurancePayment(accident);
			model.addAttribute("accident", accident);
			return "ResultCalculateAccidentFund";
		}

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
