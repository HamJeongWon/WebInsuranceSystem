package com.example.demo.controller.insurance;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Insurance.ActualCostInsurance;
import com.example.demo.model.Insurance.CarInsurance;
import com.example.demo.model.Insurance.DamageInformation;
import com.example.demo.model.Insurance.FireInsurance;
import com.example.demo.model.Insurance.Goods_Personal;
import com.example.demo.model.Insurance.Injury;
import com.example.demo.model.Insurance.Insurance;
import com.example.demo.model.Insurance.Insurance.InsuranceType;
import com.example.demo.model.Insurance.SelfVehicleDamage;
import com.example.demo.model.Insurance.Goods_Personal.GSeparation;
import com.example.demo.model.Insurance.SelfVehicleDamage.SSeparation;
import com.example.demo.service.InsuranceService;

@Controller
public class InsuranceDesign {

	@Resource(name="com.example.demo.service.InsuranceService")
	InsuranceService insuranceService;

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
        Insurance insurance = null;
        
		 String insuranceType = request.getParameter("action");
			switch(insuranceType) {
			 case "fire" : 
				 insurance = new FireInsurance();
				 break;
			 case "car" : 
				 insurance = new CarInsurance();
				 break;
			 case "actualCost" : 
				 insurance = new ActualCostInsurance();
				 break;
			}

			int insuranceID = insuranceService.SelectMaxID();
			if (insuranceID == 0) { insuranceID = 1000; }
			insuranceID = insuranceID + 1;
			insurance.setInsuranceID(insuranceID);
	        
	        String insuranceName = request.getParameter("insuranceName");
	        insurance.setInsuranceName(insuranceName);
	        
	        if(insuranceService.CheckInsuranceName(insuranceName) == 1) {
				switch(insuranceType) {
				 case "fire" : 
					 return "/FInsuranceDesign";
				 case "car" : 
					 return "/CInsuranceDesign";
				 case "actualCost" : 
					 return "/AInsuranceDesign";
				}
	        }
	        
	        int insuranceFee = Integer.parseInt(request.getParameter("insuranceFee"));
	        insurance.setInsuranceFee(insuranceFee);
	        
	        String insuranceManual = request.getParameter("insuranceManual");
	        insurance.setInsuranceManual(insuranceManual);
	        
	        String insuranceSalesManual = request.getParameter("insuranceSalesManual");
	        insurance.setInsuranceSalesManual(insuranceSalesManual);
	        
	        switch(insuranceType) { 
	        case "fire" :    
	            insurance.setInsuranceType(InsuranceType.Fire);
	            
	            DamageInformation directDamage, fireDamage, refugeDamage;
	            
	            directDamage = new DamageInformation();
	            
	            int directGuaranteedAmount = Integer.parseInt(request.getParameter("directGuaranteedAmount"));
	            directDamage.setDamageGuaranteedAmount(directGuaranteedAmount);
	            
	            String directGuaranteedContent = request.getParameter("directGuaranteedContent");
	            directDamage.setDamageGuaranteedContent(directGuaranteedContent);
	            
	            ((FireInsurance) insurance).setDirectDamage(directDamage);
	            
	            fireDamage = new DamageInformation();
	            
	            int fireGuaranteedAmount = Integer.parseInt(request.getParameter("fireGuaranteedAmount"));
	            fireDamage.setDamageGuaranteedAmount(fireGuaranteedAmount);
	            
	            String fireGuaranteedContent = request.getParameter("fireGuaranteedContent");
	            fireDamage.setDamageGuaranteedContent(fireGuaranteedContent);
	            
	            ((FireInsurance) insurance).setFireDamage(fireDamage);
	            
	            refugeDamage = new DamageInformation();
	            
	            int refugeGuaranteedAmount = Integer.parseInt(request.getParameter("refugeGuaranteedAmount"));
	            refugeDamage.setDamageGuaranteedAmount(refugeGuaranteedAmount);
	            
	            String refugeGuaranteedContent = request.getParameter("refugeGuaranteedContent");
	            refugeDamage.setDamageGuaranteedContent(refugeGuaranteedContent);
	            
	            ((FireInsurance) insurance).setRefugeDamage(refugeDamage);
	            	
	            insuranceService.InsertInsurance(insurance);
	            insuranceService.InsertFireInsurance((FireInsurance) insurance);
	    		
	        	break;
	        	
	        case "car" : 
	        	insurance.setInsuranceType(InsuranceType.Car);
	        	
	            Goods_Personal goods, pesonal;  
	            goods = new Goods_Personal();
	            
	            switch(request.getParameter("goodsSeparation")){   
	            case "Death" :
	            	goods.setSeparation(GSeparation.Death);
	            	break; 	
	            case "Injury" :
	            	goods.setSeparation(GSeparation.Injury);
	            	break;
	            case "Aftereffect" :
	            	goods.setSeparation(GSeparation.Aftereffect);
	            	break;	
	            }
	            goods.setProvisionLimit(Integer.parseInt(request.getParameter("goodsGuaranteeLimit")));
	            goods.setGuaranteeContent(request.getParameter("goodsGuaranteeContent"));
	            ((CarInsurance) insurance).setGoodsIndemnification(goods);
	            
	            pesonal = new Goods_Personal();
	            switch(request.getParameter("personalSeparation")){   
	            case "Death" :
	            	pesonal.setSeparation(GSeparation.Death);
	            	break; 	
	            case "Injury" :
	            	pesonal.setSeparation(GSeparation.Injury);
	            	break;
	            case "Aftereffect" :
	            	pesonal.setSeparation(GSeparation.Aftereffect);
	            	break;	
	            }
	            pesonal.setProvisionLimit(Integer.parseInt(request.getParameter("personalProvisionLimit")));
	            pesonal.setGuaranteeContent(request.getParameter("personalGuaranteeContent"));
	            ((CarInsurance) insurance).setPersonalIndemnification(pesonal);

	            SelfVehicleDamage selfVehicleDamage = new SelfVehicleDamage();
	            
	            switch (request.getParameter("selfVehicleSeparation")) {
	    		case "SelfBodyAccident":
	    			selfVehicleDamage.setSeparation(SSeparation.SelfBodyAccident);
	    			break;
	    		case "CarInjury":
	    			selfVehicleDamage.setSeparation(SSeparation.CarInjury);
	    			break;
	    		default:
	    			break;
	    		}
	            selfVehicleDamage.setSubscriptionFeeForInjury(Integer.parseInt(request.getParameter("SubscriptionFeeForInjury")));
	            selfVehicleDamage.setSubscriptionFeeForAccidentalInjuries(Integer.parseInt(request.getParameter("SubscriptionFeeForAccidentalInjuries")));
	            ((CarInsurance) insurance).setSelfVehicleDamage(selfVehicleDamage);
	      
	            insuranceService.InsertInsurance(insurance);
	            insuranceService.InsertCarInsurance((CarInsurance) insurance);
				
	        	break;
	        	
	        case "actualCost" : 
	        	insurance.setInsuranceType(InsuranceType.ActualCost);
	        	
	            Injury hospitalization, outpatient;
	            
	            hospitalization = new Injury();
	            
	            hospitalization.setProvisionFee(Integer.parseInt(request.getParameter("hospitalizationFee")));
	            hospitalization.setProvisionReason(request.getParameter("hospitalizationReason"));
	            ((ActualCostInsurance) insurance).setInjuryHospitalization(hospitalization);
	            
	            outpatient = new Injury();
	            
	            outpatient.setProvisionFee(Integer.parseInt(request.getParameter("outpatientFee")));
	            outpatient.setProvisionReason(request.getParameter("outpatientReason"));
	            ((ActualCostInsurance) insurance).setInjuryOutpatient(outpatient);
	      
	    		insuranceService.InsertInsurance(insurance);
	    		insuranceService.InsertActualCostInsurance((ActualCostInsurance) insurance);
	        	break;     	
	        default :
	    		break;
	        }
		return "redirect:/InsuranceList";	
	}
}
