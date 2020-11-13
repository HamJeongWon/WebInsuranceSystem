package com.example.demo.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.dao.InsuranceDAO;
import com.example.demo.model.Insurance.ActualCostInsurance;
import com.example.demo.model.Insurance.CarInsurance;
import com.example.demo.model.Insurance.DamageInformation;
import com.example.demo.model.Insurance.FireInsurance;
import com.example.demo.model.Insurance.Goods_Personal;
import com.example.demo.model.Insurance.Goods_Personal.GSeparation;
import com.example.demo.model.Insurance.Injury;
import com.example.demo.model.Insurance.Insurance;
import com.example.demo.model.Insurance.SelfVehicleDamage;
import com.example.demo.model.Insurance.SelfVehicleDamage.SSeparation;


@Service("com.example.demo.service.InsuranceService")
public class InsuranceService {
	
    @Resource(name="com.example.demo.dao.InsuranceDAO")
    InsuranceDAO insuranceDAO;
	
    public List<Insurance> searchInsuranceIDandName() throws Exception{
        return insuranceDAO.searchInsuranceIDandName();
    }
    
    public FireInsurance ResultFInsurance(int insuranceID) throws Exception {
    	Map<String, Object> map = insuranceDAO.ResultFInsurance(insuranceID);
    	
    	FireInsurance insurance = new FireInsurance();
		insurance.setInsuranceID(Integer.parseInt(map.get("insuranceID").toString()));
		insurance.setInsuranceName(map.get("insuranceName").toString());
		insurance.setInsuranceFee(Integer.parseInt(map.get("insuranceFee").toString()));
		insurance.setInsuranceType(Insurance.InsuranceType.valueOf(map.get("insuranceType").toString()));	
		insurance.setInsuranceManual(map.get("insuranceManual").toString());
		insurance.setInsuranceSalesManual(map.get("insuranceSalesManual").toString());
		
		DamageInformation directDamage, fireDamage, refugeDamage;
		
		directDamage = new DamageInformation();
		directDamage.setDamageGuaranteedAmount(Integer.parseInt(map.get("directGuaranteedAmount").toString()));
		directDamage.setDamageGuaranteedContent(map.get("directGuaranteedContent").toString());
		insurance.setDirectDamage(directDamage);
		
		fireDamage = new DamageInformation();
		fireDamage.setDamageGuaranteedAmount(Integer.parseInt(map.get("fireGuaranteedAmount").toString()));
		fireDamage.setDamageGuaranteedContent(map.get("fireGuaranteedContent").toString());
		insurance.setFireDamage(fireDamage);
		
		refugeDamage = new DamageInformation();
		refugeDamage.setDamageGuaranteedAmount(Integer.parseInt(map.get("refugeGuaranteedAmount").toString()));
		refugeDamage.setDamageGuaranteedContent(map.get("refugeGuaranteedContent").toString());
		insurance.setRefugeDamage(refugeDamage);
    	
		return insurance;
    }
    
    public CarInsurance ResultCInsurance(int insuranceID) throws Exception {
    	Map<String, Object> map = insuranceDAO.ResultCInsurance(insuranceID);
    	
    	
    	CarInsurance insurance = new CarInsurance();
		insurance.setInsuranceID(Integer.parseInt(map.get("insuranceID").toString()));
		insurance.setInsuranceName(map.get("insuranceName").toString());
		insurance.setInsuranceFee(Integer.parseInt(map.get("insuranceFee").toString()));
		insurance.setInsuranceType(Insurance.InsuranceType.valueOf(map.get("insuranceType").toString()));	
		insurance.setInsuranceManual(map.get("insuranceManual").toString());
		insurance.setInsuranceSalesManual(map.get("insuranceSalesManual").toString());
    	
    	 Goods_Personal goods, pesonal;  
         goods = new Goods_Personal();
         goods.setGuaranteeContent(map.get("goodsGuaranteeContent").toString());
         goods.setProvisionLimit(Integer.parseInt(map.get("goodsGuaranteeLimit").toString()));
         goods.setSeparation(GSeparation.valueOf(map.get("goodsSeparation").toString()));
         insurance.setGoodsIndemnification(goods);
         
         pesonal = new Goods_Personal();
         pesonal.setGuaranteeContent(map.get("personalGuaranteeContent").toString());
         pesonal.setProvisionLimit(Integer.parseInt(map.get("personalProvisionLimit").toString()));
         pesonal.setSeparation(GSeparation.valueOf(map.get("personalSeparation").toString()));
         insurance.setPersonalIndemnification(pesonal);

         SelfVehicleDamage selfVehicleDamage = new SelfVehicleDamage();
         selfVehicleDamage.setSubscriptionFeeForAccidentalInjuries(Integer.parseInt(map.get("subscriptionFeeForAccidentalInjuries").toString()));
         selfVehicleDamage.setSubscriptionFeeForInjury(Integer.parseInt(map.get("subscriptionFeeForInjury").toString()));
 		 selfVehicleDamage.setSeparation(SSeparation.valueOf(map.get("selfVehicleSeparation").toString()));
         insurance.setSelfVehicleDamage(selfVehicleDamage);
		return insurance;
    }
    
    public ActualCostInsurance ResultAInsurance(int insuranceID) throws Exception {
    	Map<String, Object> map = insuranceDAO.ResultAInsurance(insuranceID);
    	ActualCostInsurance insurance = new ActualCostInsurance();
    	
		insurance.setInsuranceID(Integer.parseInt(map.get("insuranceID").toString()));
		insurance.setInsuranceName(map.get("insuranceName").toString());
		insurance.setInsuranceFee(Integer.parseInt(map.get("insuranceFee").toString()));
		insurance.setInsuranceType(Insurance.InsuranceType.valueOf(map.get("insuranceType").toString()));	
		insurance.setInsuranceManual(map.get("insuranceManual").toString());
		insurance.setInsuranceSalesManual(map.get("insuranceSalesManual").toString());
   	
        Injury hospitalization, outpatient;   
        hospitalization = new Injury();        
        hospitalization.setProvisionFee(Integer.parseInt(map.get("hospitalizationFee").toString()));
        hospitalization.setProvisionReason(map.get("hospitalizationReason").toString());
        insurance.setInjuryHospitalization(hospitalization);
        
        outpatient = new Injury();
        outpatient.setProvisionFee(Integer.parseInt(map.get("outpatientFee").toString()));
        outpatient.setProvisionReason(map.get("outpatientReason").toString());
        insurance.setInjuryOutpatient(outpatient);
        
		return insurance;
    }
}
