package com.example.demo.controller.accident;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.InsuranceTreatmentService;

@Controller
public class PaymentAccidentFund {

	@Resource(name="com.example.demo.service.InsuranceTreatmentService")
	InsuranceTreatmentService insuranceTreatmentService;
		
	@RequestMapping("/ResultMentPaymentAccidentFund")
	private String CalculateAccidentFund(HttpServletRequest request,Model model) throws Exception{
		int accidentID = Integer.parseInt(request.getParameter("accidentID"));
		insuranceTreatmentService.CalculateAccidentFund(accidentID);
		
		return "ResultMentPaymentAccidentFund";
	}
	
	@RequestMapping("/PaymentAccidentFund")
	private String PaymentAccidentFunds(HttpServletRequest request,Model model) throws Exception{
		model.addAttribute("accidentIDVector", insuranceTreatmentService.PaymentAccidentFunds());
		return "PaymentAccidentFund";
	}
	
	@RequestMapping("/ResultPaymentAccidentFund")
	private String ResultPaymentAccidentFund(HttpServletRequest request,Model model) throws Exception{
		int accidentID = Integer.parseInt(request.getParameter("accidentID"));
		
		model.addAttribute("accident", insuranceTreatmentService.ResultPaymentAccidentFund(accidentID));
		return "ResultPaymentAccidentFund";
	}
	
}
