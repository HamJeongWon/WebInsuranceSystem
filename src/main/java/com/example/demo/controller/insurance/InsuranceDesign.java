package com.example.demo.controller.insurance;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.InsuranceService;

@Controller
public class InsuranceDesign {

	@Resource(name="com.example.demo.service.InsuranceService")
	InsuranceService insuranceService;
	
	@RequestMapping("/InsuranceDesign")
	private String InsuranceDesignLoad(Model model) throws Exception{
		return "InsuranceDesign";
	}

	@RequestMapping("/InsuranceList")
	private String searchInsuranceIDandName(Model model) throws Exception{
		model.addAttribute("InsuranceList", insuranceService.searchInsuranceIDandName());
		return "InsuranceList";
	}

	@RequestMapping("/ResultFInsurance")
	private String ResultFInsurance(HttpServletRequest request, Model model) throws Exception{
		model.addAttribute("FInsurance", insuranceService.ResultFInsurance(Integer.parseInt(request.getParameter("action"))));
		return "ResultFInsuranceDesign";
	}

	@RequestMapping("/ResultCInsurance")
	private String ResultCInsurance(HttpServletRequest request, Model model) throws Exception{
		model.addAttribute("CInsurance", insuranceService.ResultCInsurance(Integer.parseInt(request.getParameter("action"))));
		return "ResultCInsuranceDesign";
	}

	@RequestMapping("/ResultAInsurance")
	private String ResultAInsurance(HttpServletRequest request, Model model) throws Exception{
		model.addAttribute("AInsurance", insuranceService.ResultAInsurance(Integer.parseInt(request.getParameter("action"))));
		return "ResultAInsuranceDesign";
	}
	
    @RequestMapping("/AInsuranceDesign") 
    private String AInsuranceDesignLoad(Model model) throws Exception{
        return "AInsuranceDesign"; 
    }
    
    @RequestMapping("/CInsuranceDesign") 
    private String CInsuranceDesignLoad(Model model) throws Exception{
        return "CInsuranceDesign"; 
    }
    
    @RequestMapping("/FInsuranceDesign") 
    private String FInsuranceDesignLoad(Model model) throws Exception{
        return "FInsuranceDesign"; 
    }

	@RequestMapping("/InsuranceDesgin")
	private String InsertInsurance(HttpServletRequest request) {
		insuranceService.InsertInsurance(request);
		return "redirect:/InsuranceList";	
	}
}