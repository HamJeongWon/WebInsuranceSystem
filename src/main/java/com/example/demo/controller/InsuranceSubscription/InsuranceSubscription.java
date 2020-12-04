package com.example.demo.controller.InsuranceSubscription;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Acceptance.AcceptanceGuide;
import com.example.demo.model.Customer.Customer;
import com.example.demo.service.AcceptanceGuideService;
import com.example.demo.service.ContractService;
import com.example.demo.service.CustomerService;
import com.example.demo.service.SubscriptionService;

@Controller
public class InsuranceSubscription {
	
	@Resource(name="com.example.demo.service.SubscriptionService")
	private SubscriptionService subscriptionService;
	
	@Resource(name="com.example.demo.service.AcceptanceGuideService")
	private AcceptanceGuideService acceptanceGuideService;
	
	@Resource(name="com.example.demo.service.ContractService")
	private ContractService contractService;
	
	@Resource(name="com.example.demo.service.CustomerService")
	private CustomerService customerService;
	
	@RequestMapping("/JudgementInsuranceSubscription")
	private String JudgementInsuranceSubscription(HttpServletRequest request,Model model) throws Exception{
		int num = Integer.parseInt(request.getParameter("num"));
		int index = num-2;
		int insuranceID = subscriptionService.findAcceptanceAproveID().get(index);
		int customerID = subscriptionService.findAcceptanceAproveID().get(index+1);
		AcceptanceGuide acceptanceGuide = acceptanceGuideService.findAcceptance(insuranceID);
		Customer customer= contractService.findCustomer(customerID);
		
		request.setAttribute("insuranceID", insuranceID);
		request.setAttribute("acceptanceGuide", acceptanceGuide);
		request.setAttribute("customer", customer);
		request.setAttribute("personalInformation", customerService.findPersonalInformation(customerID));
		request.setAttribute("insuranceType", customerService.getInsuranceType2(insuranceID));
		customerService.setPersonalInformation(customer);
		
		switch (customerService.getInsuranceType2(insuranceID)) {
		case Fire: // ȭ�纸��
			
			request.setAttribute("insurance", customerService.findBuildingCustomer(customerID));
			break;
		case Car:// �ڵ�������
			request.setAttribute("insurance", customerService.findCarCustomer(customerID));
			
			break;
		case ActualCost:// �Ǻ���
			request.setAttribute("insurance", customerService.findActualCostCustomer(customerID));
			break;
		}
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
