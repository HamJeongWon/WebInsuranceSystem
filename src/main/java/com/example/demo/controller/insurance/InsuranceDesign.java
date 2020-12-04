package com.example.demo.controller.insurance;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Insurance.Goods_Personal.GSeparation;
import com.example.demo.model.Insurance.Insurance.InsuranceType;
import com.example.demo.model.Insurance.SelfVehicleDamage.SSeparation;
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

	@SuppressWarnings("static-access")
	@RequestMapping("/InsuranceDesgin")
	private String InsertInsurance(HttpServletRequest request) {
		
			String insuranceType = request.getParameter("action");
	        
	        String insuranceName = request.getParameter("insuranceName");
	        int insuranceFee = Integer.parseInt(request.getParameter("insuranceFee"));
	        String insuranceManual = request.getParameter("insuranceManual");       
	        String insuranceSalesManual = request.getParameter("insuranceSalesManual");
	        InsuranceType insuranceType1;
	        
	        switch(insuranceType) { 
	        case "fire" : 
	        	insuranceType1 = InsuranceType.Fire;
	            
	            int directGuaranteedAmount = Integer.parseInt(request.getParameter("directGuaranteedAmount"));            
	            String directGuaranteedContent = request.getParameter("directGuaranteedContent");
	                        
	            int fireGuaranteedAmount = Integer.parseInt(request.getParameter("fireGuaranteedAmount")); 
	            String fireGuaranteedContent = request.getParameter("fireGuaranteedContent");

	            int refugeGuaranteedAmount = Integer.parseInt(request.getParameter("refugeGuaranteedAmount"));  
	            String refugeGuaranteedContent = request.getParameter("refugeGuaranteedContent");
	            
	            insuranceService.InsertInsurance(insuranceName, insuranceFee, insuranceManual, insuranceSalesManual,
	            		insuranceType1, directGuaranteedAmount, directGuaranteedContent, fireGuaranteedAmount, fireGuaranteedContent, 
	            		refugeGuaranteedAmount, refugeGuaranteedContent);
	        	break;	
	        case "car" : 
	        	insuranceType1 = InsuranceType.Car;

	        	GSeparation GSeparation = null;
	        	switch(request.getParameter("goodsSeparation")){   
	        		case "Death" :
	        			GSeparation = GSeparation.Death;
	        			break; 	
	        		case "Injury" :
	        			GSeparation = GSeparation.Injury;
	        			break;
	        		case "Aftereffect" :
	        			GSeparation = GSeparation.Aftereffect;
	        			break;	
	        	}
	        	
	            int goodsGuaranteeLimit = Integer.parseInt(request.getParameter("goodsGuaranteeLimit"));
	            String goodsGuaranteeContent = request.getParameter("goodsGuaranteeContent");
	            
	            GSeparation GSeparation1 = null;
	            switch(request.getParameter("personalSeparation")){   
	            case "Death" :
        			GSeparation1 = GSeparation.Death;
        			break; 	
        		case "Injury" :
        			GSeparation1 = GSeparation.Injury;
        			break;
        		case "Aftereffect" :
        			GSeparation1 = GSeparation.Aftereffect;
        			break;	
	            }
	            int personalProvisionLimit = Integer.parseInt(request.getParameter("personalProvisionLimit"));
	            String personalGuaranteeContent = request.getParameter("personalGuaranteeContent");
	            
	            SSeparation SSeparation = null;
	            switch (request.getParameter("selfVehicleSeparation")) {
	    		case "SelfBodyAccident":
	    			SSeparation = SSeparation.SelfBodyAccident;
	    			break;
	    		case "CarInjury":
	    			SSeparation = SSeparation.CarInjury;
	    			break;
	    		default:
	    			break;
	    		}
	            int SubscriptionFeeForInjury = Integer.parseInt(request.getParameter("SubscriptionFeeForInjury"));
	            int SubscriptionFeeForAccidentalInjuries = Integer.parseInt(request.getParameter("SubscriptionFeeForAccidentalInjuries"));
	            
	            insuranceService.InsertInsurance(insuranceName, insuranceFee, insuranceManual, insuranceSalesManual,
	            		insuranceType1, GSeparation, goodsGuaranteeLimit, goodsGuaranteeContent, GSeparation1, personalProvisionLimit, personalGuaranteeContent, 
	            		SSeparation, SubscriptionFeeForInjury, SubscriptionFeeForAccidentalInjuries);

	        	break;
	        case "actualCost" : 
	        	insuranceType1 = InsuranceType.ActualCost;

	            int hospitalizationFee = Integer.parseInt(request.getParameter("hospitalizationFee"));
	            String hospitalizationReason = request.getParameter("hospitalizationReason");
	            
	            int outpatientFee = Integer.parseInt(request.getParameter("outpatientFee"));
	            String outpatientReason = request.getParameter("outpatientReason");
	            
	            insuranceService.InsertInsurance(insuranceName, insuranceFee, insuranceManual, insuranceSalesManual,
	            		insuranceType1, hospitalizationFee, hospitalizationReason, outpatientFee, outpatientReason);
	            
	            break;
	        }
		return "redirect:/InsuranceList";	
	}
}