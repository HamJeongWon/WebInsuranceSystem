package com.example.demo.controller.accident;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.AccidentService;
import com.example.demo.service.SubscriptionService;

@Controller
public class AccidentReception {
	@Resource(name="com.example.demo.service.AccidentService")
	AccidentService accidentService;
	
	@Resource(name="com.example.demo.service.SubscriptionService")
	SubscriptionService subscriptionService;
	
	
	
	@RequestMapping("/InsuranceTreatment")
	private String InsuranceTreatment(Model model) throws Exception{
		return "InsuranceTreatment";
	}
	
	@RequestMapping("/AccidentReception")
	private String showSubscriptionCustomer(Model model) throws Exception{
		model.addAttribute("accidentIDList", subscriptionService.findSubscriptionCustomerID());
		return "AccidentReception";
	}


	@RequestMapping("/InsertAccidentReception")
	private String InsertAccidentReception(HttpServletResponse response,HttpServletRequest request,Model model) throws Exception{
		model.addAttribute("num", Integer.parseInt(request.getParameter("num")));
		return "InsertAccidentReception";

	}

	@RequestMapping("/ResultMentAccidentReception")
	private String  ResultMentAccidentReception(HttpServletResponse response,HttpServletRequest request,Model model) throws Exception{
		int num = Integer.parseInt(request.getParameter("num"));
		String accidentDate = request.getParameter("accidentDate");
		String accidentTime = String.valueOf(request.getParameter("accidentTime"));
		String accidentCause = request.getParameter("accidentCause");
		String accidentLocation = request.getParameter("accidentLocation");
		String expertOpinion = request.getParameter("expertOpinion");

		if(accidentDate =="" || accidentTime=="" || accidentCause=="" || accidentLocation == "" || expertOpinion == "") {
			response.sendRedirect("incl/alert.jsp");
			return null;
		}else {
			model.addAttribute("accident", accidentService.resultMentAccidentReception(num,subscriptionService.findSubscriptionCustomerID(),accidentDate,accidentTime,accidentCause,accidentLocation,expertOpinion));
			return "ResultMentAccidentReception";
		}
		
	}
	
	@RequestMapping("/ResultAccidentReception")
	private String  ResultAccidentReception(HttpServletRequest request,Model model) throws Exception{
		int accidentID = Integer.parseInt(request.getParameter("accidentID"));
		model.addAttribute("accident", accidentService.resultAccidentReception(accidentID));
		return "ResultAccidentReception";
	
	}
	
}