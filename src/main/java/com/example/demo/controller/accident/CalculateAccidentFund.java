package com.example.demo.controller.accident;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Accident.Accident;
import com.example.demo.service.AccidentService;
import com.example.demo.service.InsuranceService;

@Controller
public class CalculateAccidentFund {
	
	@Resource(name="com.example.demo.service.AccidentService")
	AccidentService accidentService;
	
	@Resource(name="com.example.demo.service.InsuranceService")
	InsuranceService insuranceService;

	@RequestMapping("/CalculateAccidentFund")
	private String CalculateAccidentFunds(Model model) throws Exception{
		model.addAttribute("accidentIDVector", accidentService.CalculateAccidentFunds());
		return "CalculateAccidentFund";
	}
	
	@RequestMapping("/InsertCalculateAccidentFund")
	private String InsertCalculateAccidentFund(HttpServletRequest request,Model model) throws Exception{
		int accidentID = Integer.parseInt(request.getParameter("accidentID"));
		Accident accident = accidentService.findAccident(accidentID);
		
		if(accident.getInsurancePremium() != 0 && accident.getInsurancePremiumCause() != null) {
			//이미 보험금이 산출되었을 경우
			return "error";
		}else {
			model.addAttribute("maxInsurancePremium",insuranceService.getInsuranceFee(accident.getInsuranceID()));
			model.addAttribute("accident", accident);
			return "InsertCalculateAccidentFund";
		}
	}
	
	@RequestMapping("/ResultCalculateAccidentFund")
	private String ResultCalculateAccidentFund(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
		int accidentID = Integer.parseInt(request.getParameter("accidentID"));
		String insurancePremium =request.getParameter("insurancePremium");
		String insurancePremiumCause = request.getParameter("insurancePremiumCause");
		if(insurancePremium=="" || insurancePremiumCause=="") {
			response.sendRedirect("incl/alert.jsp");
			return null;
		}else {
			model.addAttribute("accident", accidentService.ResultCalculateAccidentFund(accidentID,insurancePremium,insurancePremiumCause));
			return "ResultCalculateAccidentFund";
		}
		
		
	}
}