package com.example.demo.controller.accident;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Accident.Accident;
import com.example.demo.service.InsuranceTreatmentService;

@Controller
public class CalculateAccidentFund {
	
	@Resource(name="com.example.demo.service.InsuranceTreatmentService")
	InsuranceTreatmentService insuranceTreatmentService;

	@RequestMapping("/CalculateAccidentFund")
	private String CalculateAccidentFunds(HttpServletRequest request,Model model) throws Exception{
		List<Integer> accidentIDListFromCalculateAccidentFund = new ArrayList<Integer>();
		for(int i=0; i< insuranceTreatmentService.showAllAccidentIDFromCalculateAccidentFund().size(); i++) {
			accidentIDListFromCalculateAccidentFund.add(insuranceTreatmentService.showAllAccidentIDFromCalculateAccidentFund().get(i).getAccidentID());
		}
		request.setAttribute("accidentIDVector", accidentIDListFromCalculateAccidentFund);
		return "CalculateAccidentFund";
	}
	

	
	@RequestMapping("/InsertCalculateAccidentFund")
	private String InsertCalculateAccidentFund(HttpServletRequest request,Model model) throws Exception{
		int accidentID = Integer.parseInt(request.getParameter("accidentID"));
		Accident accident = insuranceTreatmentService.findAccident(accidentID);
		if(accident.getInsurancePremium() != 0 && accident.getInsurancePremiumCause() != null) {
			//이미 보험금이 산출되었을 경우
			return "error";
		}else {
			request.setAttribute("maxInsurancePremium",insuranceTreatmentService.getInsuranceFee(accident.getInsuranceID()));
			request.setAttribute("accident", accident);
			return "InsertCalculateAccidentFund";
		}


	}
	@RequestMapping("/ResultCalculateAccidentFund")
	private String ResultCalculateAccidentFund(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
		int accidentID = Integer.parseInt(request.getParameter("accidentID"));
		Accident accident =insuranceTreatmentService.findAccident(accidentID);

		String insurancePremium =request.getParameter("insurancePremium");
		String insurancePremiumCause = request.getParameter("insurancePremiumCause");
		
		
		

		if(insurancePremium=="" || insurancePremiumCause=="") {
			response.sendRedirect("incl/alert.jsp");
			return null;

		}else {
			accident.setInsurancePremium(Integer.parseInt(insurancePremium));
			accident.setInsurancePremiumCause(insurancePremiumCause);

			insuranceTreatmentService.insertInsurancePayment(accident);
			request.setAttribute("accident", accident);
			return "ResultCalculateAccidentFund";
		}
	}


}
