package com.example.demo.controller.accident;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.InsuranceTreatmentService;

@Controller
public class CalculateAccidentFund {
	
	@Resource(name="com.example.demo.service.InsuranceTreatmentService")
	InsuranceTreatmentService insuranceTreatmentService;

	@RequestMapping("/CalculateAccidentFund")
	private String CalculateAccidentFunds(Model model) throws Exception{
		model.addAttribute("accidentIDVector", insuranceTreatmentService.CalculateAccidentFunds());
		return "CalculateAccidentFund";
	}
	

	
	@RequestMapping("/InsertCalculateAccidentFund")
	private String InsertCalculateAccidentFund(HttpServletRequest request,Model model) throws Exception{
		int accidentID = Integer.parseInt(request.getParameter("accidentID"));
		return insuranceTreatmentService.InsertCalculateAccidentFund(accidentID,model);
	}
	
	@RequestMapping("/ResultCalculateAccidentFund")
	private String ResultCalculateAccidentFund(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
		int accidentID = Integer.parseInt(request.getParameter("accidentID"));
		String insurancePremium =request.getParameter("insurancePremium");
		String insurancePremiumCause = request.getParameter("insurancePremiumCause");
		
		return insuranceTreatmentService.ResultCalculateAccidentFund(accidentID,insurancePremium,insurancePremiumCause, response,model);
		
	}


}
