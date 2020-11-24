package com.example.demo.controller.InsuranceSubscription;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.SubscriptionService;

@Controller
public class InsuranceSubscription {
	
	@Resource(name="com.example.demo.service.SubscriptionService")
	private SubscriptionService subscriptionService;
	
	
	@RequestMapping("/JudgementInsuranceSubscription")
	private String JudgementInsuranceSubscription(HttpServletRequest request,Model model) throws Exception{
		int num = Integer.parseInt(request.getParameter("num"));
		subscriptionService.JudgementInsuranceSubscription(num,request);

		return "JudgementInsuranceSubscription";
	}

	@RequestMapping("/InsuranceSubscription")
	private String InsuranceSubscription(Model model) throws Exception{
		model.addAttribute("IDVector", subscriptionService.InsuranceSubscription());
		return "InsuranceSubscription";
	}
	
	@RequestMapping("/AcceptInsuranceSubscription")
	private String AcceptInsuranceSubscription(HttpServletRequest request,Model model) throws Exception{
		int customerID = Integer.parseInt(request.getParameter("customerID"));
		int insuranceID = Integer.parseInt(request.getParameter("insuranceID"));

		subscriptionService.updateSubscriptionStatus(customerID, insuranceID);

		return "AcceptInsuranceSubscription";
	}
	@RequestMapping("/DeclineInsuranceSubscription")
	private String DeclineInsuranceSubscription(HttpServletRequest request,Model model) throws Exception{
		int customerID = Integer.parseInt(request.getParameter("customerID"));
		int insuranceID = Integer.parseInt(request.getParameter("insuranceID"));

		subscriptionService.deleteSubscription(customerID, insuranceID);

		return "DeclineInsuranceSubscription";
	}
	@RequestMapping("/DeclineDoneInsuranceSubscription")
	private String DeclineDoneInsuranceSubscription(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
		String declineCause = request.getParameter("declineCause");
		if(declineCause == "") {
			response.sendRedirect("incl/alert.jsp");
			return null;
		}else {
			return "DeclineDoneInsuranceSubscription";
		}		
	}
	
}
