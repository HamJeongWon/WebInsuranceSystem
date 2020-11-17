package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Accident.Accident;
import com.example.demo.model.Subscription.Subscription;
import com.example.demo.service.InsuranceTreatmentService;

@Controller
public class AccidentReception {
	private List<Integer> accidentIDList = new ArrayList<Integer>();
	@Resource(name="com.example.demo.service.InsuranceTreatmentService")
	InsuranceTreatmentService insuranceTreatmentService;
	
	
	@RequestMapping("/InsuranceTreatment")
	private String InsuranceTreatment(Model model) throws Exception{
		return "InsuranceTreatment";
	}
	
	@RequestMapping("/AccidentReception")
	private String showSubscriptionCustomer(Model model) throws Exception{

		for(int i=0; i<insuranceTreatmentService.showSubscriptionCustomer().size(); i++) {
			accidentIDList.add(insuranceTreatmentService.showSubscriptionCustomer().get(i).getInsuranceID());
			accidentIDList.add(insuranceTreatmentService.showSubscriptionCustomer().get(i).getCustomerID());
		}

		model.addAttribute("accidentIDList", accidentIDList);
		return "AccidentReception";
	}


	@RequestMapping("/InsertAccidentReception")
	private String InsertAccidentReception(HttpServletResponse response,HttpServletRequest request,Model model) throws Exception{
		int num = Integer.parseInt(request.getParameter("num"));
		model.addAttribute("num", num);
		return "InsertAccidentReception";

	}

	@RequestMapping("/ResultMentAccidentReception")
	private String  ResultMentAccidentReception(HttpServletResponse response,HttpServletRequest request,Model model) throws Exception{
		int num = Integer.parseInt(request.getParameter("num"));
		int index = num - 2;

		int insuranceID = accidentIDList.get(index);
		int customerID = accidentIDList.get(index+1);


		Accident accident = new Accident();


		int accidentID = insuranceTreatmentService.SelectMaxID();
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

			insuranceTreatmentService.insertAccident(accident);
			request.setAttribute("accident", accident);
			return "ResultMentAccidentReception";

		}
	}
	
	@RequestMapping("/ResultAccidentReception")
	private String  ResultAccidentReception(HttpServletResponse response,HttpServletRequest request,Model model) throws Exception{
		int accidentID = Integer.parseInt(request.getParameter("accidentID"));
		Accident accident = insuranceTreatmentService.findAccident(accidentID);

		request.setAttribute("accident", accident);
		return "ResultAccidentReception";
	
	}
	
}
