package com.example.demo.controller.acceptanceGuide;

import java.util.Vector;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Acceptance.AcceptanceGuide;
import com.example.demo.model.Acceptance.AcceptanceGuide.RiskEvaluation;
import com.example.demo.model.Insurance.Insurance;
import com.example.demo.service.AcceptanceGuideService;

@Controller
public class AcceptanceManage {
	
	@Resource(name="com.example.demo.service.AcceptanceGuideService")
	AcceptanceGuideService acceptanceGuideService;
	
	@RequestMapping("/AcceptanceGuide")
	private String AcceptanceGuideLoad(Model model) throws Exception{
		return "AcceptanceGuide";
	}
	
	@RequestMapping("/AcceptanceGuideDesignLoad")
	private String AcceptanceGuideDesignLoad(HttpServletRequest request, Model model) throws Exception{
		model.addAttribute("action", request.getParameter("action"));
		return "AcceptanceGuideDesign";
	}
	
	@RequestMapping("/AcceptanceGuideDesign")
	private String AcceptanceGuideDesign(HttpServletRequest request) throws Exception{	
		String ScameCase = request.getParameter("ScamCase");	
		RiskEvaluation RiskEvaluation = AcceptanceGuide.RiskEvaluation.valueOf(request.getParameter("RiskEvaluation"));
		int InsuranceID = Integer.parseInt(request.getParameter("InsuranceID"));
		acceptanceGuideService.InsertAcceptanceGuide(ScameCase, RiskEvaluation, InsuranceID);		
		return "redirect:/ShowAcceptanceGuide";
	}
	
	@RequestMapping("/ShowAcceptanceGuide")
	private String ShowAcceptanceGuide(Model model) throws Exception{
        Vector<AcceptanceGuide> fireGuide = acceptanceGuideService.searchAcceptanceForInsurance((Insurance.InsuranceType.Fire).toString());    
        Vector<AcceptanceGuide> carGuide = acceptanceGuideService.searchAcceptanceForInsurance((Insurance.InsuranceType.Car).toString());
        Vector<AcceptanceGuide> actualCostGuide = acceptanceGuideService.searchAcceptanceForInsurance((Insurance.InsuranceType.ActualCost).toString());
        model.addAttribute("fireGuide", fireGuide);
        model.addAttribute("carGuide", carGuide);
        model.addAttribute("actualCostGuide", actualCostGuide);
		return "AcceptanceGuideList";
	}
	
	@RequestMapping("/SearchNullAcceptanceGuide")
	private String SearchNullAcceptanceGuide(Model model) throws Exception{
		model.addAttribute("nullAcceptanceInsuranceID", acceptanceGuideService.SearchNullAcceptanceInsuranceID());
		return "NullAcceptanceGuideList";
	}
	
	@RequestMapping("/ResultAcceptanceGuide")
	private String ResultAcceptanceGuide(HttpServletRequest request, Model model) throws Exception{
		model.addAttribute("acceptanceGuide", acceptanceGuideService.getAcceptanceGuide(Integer.parseInt(request.getParameter("action"))));
		return "ResultAcceptanceGuide";
	}

}
