package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Accident.Accident;
import com.example.demo.service.InsuranceTreatmentService;

@Controller
public class PaymentAccidentFund {

	@Resource(name="com.example.demo.service.InsuranceTreatmentService")
	InsuranceTreatmentService insuranceTreatmentService;
		
	@RequestMapping("/ResultMentPaymentAccidentFund")
	private String CalculateAccidentFund(HttpServletRequest request,Model model) throws Exception{
		int accidentID = Integer.parseInt(request.getParameter("accidentID"));
		Accident accident =insuranceTreatmentService.findAccident(accidentID);

		accident.setPayInsurancePremium(true);
		insuranceTreatmentService.updatePayInsurancePremium(accident);
		return "ResultMentPaymentAccidentFund";
	}
	
	@RequestMapping("/PaymentAccidentFund")
	private String PaymentAccidentFunds(HttpServletRequest request,Model model) throws Exception{
		List<Integer> accidentIDListFromPaymentAccidentFund = new ArrayList<Integer>();
		for(int i=0; i< insuranceTreatmentService.showAllAccidentIDFromPaymentAccidentFund().size(); i++) {
			accidentIDListFromPaymentAccidentFund.add(insuranceTreatmentService.showAllAccidentIDFromPaymentAccidentFund().get(i).getAccidentID());
		}
		request.setAttribute("accidentIDVector", accidentIDListFromPaymentAccidentFund);
		return "PaymentAccidentFund";
	}
	
	@RequestMapping("/ResultPaymentAccidentFund")
	private String ResultPaymentAccidentFund(HttpServletRequest request,Model model) throws Exception{
		int accidentID = Integer.parseInt(request.getParameter("accidentID"));
		Accident accident = insuranceTreatmentService.findAccident(accidentID);

		request.setAttribute("accident", accident);
		return "ResultPaymentAccidentFund";
	}
	
}
