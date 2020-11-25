package com.example.demo.controller.contract;

import javax.servlet.http.HttpServletRequest;

import java.util.Vector;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Contract.Contract.PaymentType;
import com.example.demo.model.Customer.ActualCost;
import com.example.demo.model.Customer.Car;
import com.example.demo.model.Customer.PersonalInformation;
import com.example.demo.service.ContractService;
import com.example.demo.service.CustomerService;
import com.example.demo.service.InsuranceService;
import com.example.demo.service.SubscriptionService;

@Controller
public class Contract {
	@Resource(name = "com.example.demo.service.ContractService")
	ContractService contractService;

	@Resource(name = "com.example.demo.service.CustomerService")
	CustomerService customerService;

	@Resource(name = "com.example.demo.service.SubscriptionService")
	SubscriptionService subscriptionService;

	@Resource(name = "com.example.demo.service.InsuranceService")
	InsuranceService insuranceService;

	@RequestMapping("/ContractContrallDesign")
	private String ContractContrallDesign(Model model) throws Exception {
		return "ContractContrallDesign";
	}

	@RequestMapping("/PaymentControll")
	private String PaymentControll(Model model) throws Exception {
		Vector<String> unpaidVec = this.contractService.searchUnpaidCustomer();
		model.addAttribute("unpaidVec", unpaidVec);
		return "unpaidList";
	}

	// action?
	@RequestMapping("/MakeContract")
	private String MakeContract(HttpServletRequest request, Model model) throws Exception {
		String action = request.getParameter("action");

		if (action.equals("List")) {
			Vector<Integer> IDVector = subscriptionService.showSubscriptionNoContractID();
			request.setAttribute("IDVector", IDVector);
			return "MakeContract1";

		} else if (action.equals("Make")) {
			// Subscription subscription = new Subscription();
			int contractID = contractService.SelectMaxID() + 1;
			int insuranceID = Integer.parseInt(request.getParameter("insuranceID"));
			int customerID = Integer.parseInt(request.getParameter("customerID"));
			int paymentAmout = 0;

			float insuranceFee = insuranceService.getInsuranceFee(insuranceID);
			String insuranceType = customerService.getInsuranceType(insuranceID);
			PersonalInformation personalInformation = customerService.findPersonalInformationByCutomerID(customerID);

			if (insuranceType.equals("Car")) {
				Car car = customerService.getCar(customerID, personalInformation);
				paymentAmout = (int) contractService.CalculatePremiumRateCar(car, insuranceFee);

			} else if (insuranceType.equals("Fire")) {
				float buildingPrice = customerService.getBuildingPrice(customerID);
				paymentAmout = (int) contractService.CalculatePremiumRateOfFire(buildingPrice, insuranceFee);

			} else {
				ActualCost actualCost = customerService.getActualCost(customerID, personalInformation);
				paymentAmout = (int) contractService.CalculatePremiumRateActual(actualCost, insuranceFee);
			}
			model.addAttribute("contractID", contractID);
			model.addAttribute("insuranceID", insuranceID);
			model.addAttribute("customerID", customerID);
			model.addAttribute("paymentAmout", paymentAmout);

			return "MakeContract2";
			
		} else if (action.equals("Finish")) {
			int insuranceID = Integer.parseInt(request.getParameter("insuranceID"));
			int customerID = Integer.parseInt(request.getParameter("customerID"));
			int contractID = Integer.parseInt(request.getParameter("contractID"));
			int paymentAmout = Integer.parseInt(request.getParameter("paymentAmout"));
			String contractExpirationDate = request.getParameter("contractExpirationDate");
			String paymentDate = request.getParameter("paymentDate");
			int paymentPeriod = Integer.parseInt(request.getParameter("paymentPeriod"));
			PaymentType paymentType = PaymentType.valueOf(request.getParameter("paymentType"));

			com.example.demo.model.Contract.Contract contract = contractService.createContract(contractID, customerID,
					contractExpirationDate, paymentAmout, paymentDate, paymentPeriod, paymentType);
			subscriptionService.insertContratIDtoSubscription(contractID, customerID, insuranceID);

			model.addAttribute("contract", contract);
			return "MakeContract3";
		}
		return "";
	}

	@RequestMapping("/FullContractControll")
	private String FullContractControll(HttpServletRequest request, Model model) throws Exception {
		Vector<String> VecFullContract = this.contractService.searchFullContractCustomers();
		model.addAttribute("VecFullContract", VecFullContract);

		return "fullContractList";
	}
//	Recontract?action=start

	@RequestMapping("/Recontract")
	private String Recontract(HttpServletRequest request, Model model) throws Exception {
		String action = request.getParameter("action");
		
		if(action.equals("start")) {
			int customerID = Integer.parseInt(request.getParameter("customerID"));
			int contractID = Integer.parseInt(request.getParameter("contractID"));

			int accountNumber = customerService.findPersonalInformationByCutomerID(customerID).getAccountNumber();
			com.example.demo.model.Contract.Contract  contract = contractService.searchContract(contractID);
					
			model.addAttribute("contract", contract);			
			model.addAttribute("accountNumber", accountNumber);
			
			return "recontract";
			
		}else if(action.equals("finish")) {			
			int customerID = Integer.parseInt(request.getParameter("customerID"));
			int contractID = Integer.parseInt(request.getParameter("contractID"));		
			String paymentDate = request.getParameter("paymentDate");
			PaymentType paymentType = PaymentType.valueOf(request.getParameter("paymentType"));
			String contractExpirationDate = request.getParameter("contractExpirationDate");
			int accountNumber = Integer.parseInt(request.getParameter("accountNumber"));
			
			customerService.updatePersonalInformation(customerID, accountNumber);
			contractService.updateContract(contractID, customerID, paymentDate, paymentType, contractExpirationDate);
			com.example.demo.model.Contract.Contract  contract = contractService.searchContract(contractID);
			
			model.addAttribute("accountNumber", accountNumber);
			model.addAttribute("contract", contract);
			return "recontract2";
		}
		return "";
	}
}
