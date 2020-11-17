package com.example.demo.controller.InsuranceSubscription;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.SubscriptionService;

@Controller
public class AcceptInsuranceSubscription {
	
	@Resource(name="com.example.demo.service.SubscriptionService")
	SubscriptionService subscriptionService;
	
	

	@RequestMapping("/InsuranceSubscription")
	private String InsuranceSubscription(Model model) throws Exception{
		List<Integer> subscriptionIDList = new ArrayList<Integer>();
		for(int i=0; i<subscriptionService.showAcceptanceAprove().size(); i++) {
			subscriptionIDList.add(subscriptionService.showAcceptanceAprove().get(i).getInsuranceID());
			subscriptionIDList.add(subscriptionService.showAcceptanceAprove().get(i).getCustomerID());
		}

		model.addAttribute("IDVector", subscriptionIDList);

		return "InsuranceSubscription";
	}

}
