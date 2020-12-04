package com.example.demo.controller.menual;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Insurance.Insurance;
import com.example.demo.service.InsuranceService;

@Controller
public class ShowMenual {
	@Resource(name="com.example.demo.service.InsuranceService")
	InsuranceService insuranceService;
	
	@RequestMapping("/Menual")
	private String searchInsuranceIDandName(Model model) throws Exception{
		model.addAttribute("InsuranceList", insuranceService.searchInsuranceIDandName());
		return "ShowMenual";
	}
	
	@RequestMapping("/GetSaleMenual")
	private String GetSaleMenual(HttpServletRequest request, Model model) throws Exception{
		int InsuranceID = Integer.parseInt(request.getParameter("InsuranceID"));
	    String InsuranceName = request.getParameter("InsuranceName");

	    model.addAttribute("InsuranceID", InsuranceID);
		model.addAttribute("InsuranceName", InsuranceName);
		model.addAttribute("Content", insuranceService.FindInsurance(InsuranceID).getInsuranceSalesManual());

		return "ShowMenualResult";
	} 
	
	@RequestMapping("/GetProductMenual")
	private String GetProductMenual(HttpServletRequest request, Model model) throws Exception{
		int InsuranceID = Integer.parseInt(request.getParameter("InsuranceID"));
	    String InsuranceName = request.getParameter("InsuranceName");
	    
		model.addAttribute("InsuranceID", InsuranceID);
		model.addAttribute("InsuranceName", InsuranceName);
		model.addAttribute("Content", insuranceService.FindInsurance(InsuranceID).getInsuranceSalesManual());

		return "ShowMenualResult";
	}

}
