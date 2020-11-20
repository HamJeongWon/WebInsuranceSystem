package com.example.demo.controller.accident;

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
	//private List<Integer> accidentIDList = new ArrayList<Integer>();
	@Resource(name="com.example.demo.service.InsuranceTreatmentService")
	InsuranceTreatmentService insuranceTreatmentService;
	
	
	@RequestMapping("/InsuranceTreatment")
	private String InsuranceTreatment(Model model) throws Exception{
		return "InsuranceTreatment";
	}
	
	@RequestMapping("/AccidentReception")
	private String showSubscriptionCustomer(Model model) throws Exception{
		model.addAttribute("accidentIDList", insuranceTreatmentService.showSubscriptionCustomer());
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
		return insuranceTreatmentService.resultMentAccidentReception(response,request,num);		
	}
	
	@RequestMapping("/ResultAccidentReception")
	private String  ResultAccidentReception(HttpServletRequest request,Model model) throws Exception{
		int accidentID = Integer.parseInt(request.getParameter("accidentID"));
		model.addAttribute("accident", insuranceTreatmentService.resultAccidentReception(accidentID));
		return "ResultAccidentReception";
	
	}
	
}
