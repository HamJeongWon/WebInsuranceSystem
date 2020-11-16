package com.example.demo.controller.menual;

import java.util.Vector;

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
	
	@RequestMapping("/GetMenual")
	private String searchInsuranceIDandName(HttpServletRequest request, Model model) throws Exception{
		int InsuranceID = Integer.parseInt(request.getParameter("InsuranceID"));
	    String InsuranceName = request.getParameter("InsuranceName");	
		String action = request.getParameter("menual");	
		String Content = "";
		Insurance insurance = insuranceService.FindInsurance(InsuranceID);
		
		if(action.equals("판매 메뉴얼 조회")) {
			Content = insurance.getInsuranceSalesManual();
		}else if(action.equals("상품 메뉴얼 조회")){
			Content = insurance.getInsuranceManual();
		}
	 
	    if(Content == "") Content = "메뉴얼 존재하지 않음";
	    
		model.addAttribute("InsuranceID", InsuranceID);
		model.addAttribute("InsuranceName", InsuranceName);
		model.addAttribute("Content", Content);

		return "ShowMenualResult";
	}

}
