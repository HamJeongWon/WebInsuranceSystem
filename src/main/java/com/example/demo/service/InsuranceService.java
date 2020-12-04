package com.example.demo.service;

import java.util.List;
import java.util.Vector;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.dao.InsuranceDAO;
import com.example.demo.model.Customer.ActualCost.BloodType;
import com.example.demo.model.Customer.ActualCost.DiseaseHistory;
import com.example.demo.model.Customer.ActualCost;
import com.example.demo.model.Customer.Car;
import com.example.demo.model.Customer.Car.CarType;
import com.example.demo.model.Customer.Car.LicenseType;
import com.example.demo.model.Insurance.ActualCostInsurance;
import com.example.demo.model.Insurance.CarInsurance;
import com.example.demo.model.Insurance.DamageInformation;
import com.example.demo.model.Insurance.FireInsurance;
import com.example.demo.model.Insurance.Goods_Personal;
import com.example.demo.model.Insurance.Injury;
import com.example.demo.model.Insurance.Insurance;
import com.example.demo.model.Insurance.SelfVehicleDamage;
import com.example.demo.model.Insurance.Goods_Personal.GSeparation;
import com.example.demo.model.Insurance.Insurance.InsuranceType;
import com.example.demo.model.Insurance.SelfVehicleDamage.SSeparation;
import com.example.demo.model.Subscription.Subscription;


@Service("com.example.demo.service.InsuranceService")
public class InsuranceService {
	
    @Resource(name="com.example.demo.dao.InsuranceDAO")
    InsuranceDAO insuranceDAO;
	
    public List<Insurance> searchInsuranceIDandName() throws Exception{
        return insuranceDAO.searchInsuranceIDandName();
    }
    
	public Insurance FindInsurance(int insuranceID) throws Exception{
		
		return insuranceDAO.FindInsurance(insuranceID);
	}

    public FireInsurance ResultFInsurance(int insuranceID) throws Exception {   	
		return insuranceDAO.ResultFInsurance(insuranceID);
    }
    
    public CarInsurance ResultCInsurance(int insuranceID) throws Exception {
		return insuranceDAO.ResultCInsurance(insuranceID);
    }
    
    public ActualCostInsurance ResultAInsurance(int insuranceID) throws Exception {    
		return insuranceDAO.ResultAInsurance(insuranceID);
    }
    
    public int SelectMaxID() {
    	return insuranceDAO.SelectMaxID();
    }
    
    public int CheckInsuranceName(String record) {  	
    	return insuranceDAO.CheckInsuranceName(record);
    }

	public void InsertInsurance(String insuranceName, int insuranceFee, String insuranceManual, String insuranceSalesManual, 
			InsuranceType insuranceType1, int directGuaranteedAmount, String directGuaranteedContent, int fireGuaranteedAmount, 
			String fireGuaranteedContent, int refugeGuaranteedAmount, String refugeGuaranteedContent) {
		
			FireInsurance insurance = new FireInsurance();
        
			int insuranceID;
			try {
				insuranceID = insuranceDAO.SelectMaxID();
			} catch (Exception e) {
				insuranceID = 1000;
			}
			insuranceID = insuranceID + 1;
			insurance.setInsuranceID(insuranceID);        
			insurance.setInsuranceName(insuranceName);
			insurance.setInsuranceFee(insuranceFee);
			insurance.setInsuranceManual(insuranceManual);
			insurance.setInsuranceSalesManual(insuranceSalesManual);
			insurance.setInsuranceType(insuranceType1);

			DamageInformation directDamage, fireDamage, refugeDamage;

			directDamage = new DamageInformation();
			directDamage.setDamageGuaranteedAmount(directGuaranteedAmount);
			directDamage.setDamageGuaranteedContent(directGuaranteedContent);
			insurance.setDirectDamage(directDamage);

			fireDamage = new DamageInformation();
			fireDamage.setDamageGuaranteedAmount(fireGuaranteedAmount);
			fireDamage.setDamageGuaranteedContent(fireGuaranteedContent);
			insurance.setFireDamage(fireDamage);

			refugeDamage = new DamageInformation();
			refugeDamage.setDamageGuaranteedAmount(refugeGuaranteedAmount);
			refugeDamage.setDamageGuaranteedContent(refugeGuaranteedContent);
			insurance.setRefugeDamage(refugeDamage);

			insuranceDAO.InsertInsurance(insurance);
			insuranceDAO.InsertFireInsurance(insurance);
	    		
	        }
	
	public void InsertInsurance(String insuranceName, int insuranceFee, String insuranceManual,
			String insuranceSalesManual, InsuranceType insuranceType1, GSeparation gSeparation, int goodsGuaranteeLimit,
			String goodsGuaranteeContent, GSeparation gSeparation1, int personalProvisionLimit,
			String personalGuaranteeContent, SSeparation sSeparation, int subscriptionFeeForInjury,
			int subscriptionFeeForAccidentalInjuries) {
		
		CarInsurance insurance = new CarInsurance();

		int insuranceID;
		try {
			insuranceID = insuranceDAO.SelectMaxID();
		} catch (Exception e) {
			insuranceID = 1000;
		}
		insuranceID = insuranceID + 1;
		insurance.setInsuranceID(insuranceID);        
		insurance.setInsuranceName(insuranceName);
		insurance.setInsuranceFee(insuranceFee);
		insurance.setInsuranceManual(insuranceManual);
		insurance.setInsuranceSalesManual(insuranceSalesManual);
		insurance.setInsuranceType(insuranceType1);
    	
        Goods_Personal goods, pesonal;  
        goods = new Goods_Personal();
        goods.setSeparation(gSeparation);
        goods.setProvisionLimit(goodsGuaranteeLimit);
        goods.setGuaranteeContent(goodsGuaranteeContent);
        insurance.setGoodsIndemnification(goods);
        
        pesonal = new Goods_Personal();
        pesonal.setSeparation(gSeparation1);
        pesonal.setProvisionLimit(personalProvisionLimit);
        pesonal.setGuaranteeContent(personalGuaranteeContent);
        insurance.setPersonalIndemnification(pesonal);
        
        SelfVehicleDamage selfVehicleDamage = new SelfVehicleDamage();
		selfVehicleDamage.setSeparation(sSeparation);
        selfVehicleDamage.setSubscriptionFeeForInjury(subscriptionFeeForInjury);
        selfVehicleDamage.setSubscriptionFeeForAccidentalInjuries(subscriptionFeeForAccidentalInjuries);
        insurance.setSelfVehicleDamage(selfVehicleDamage);
  
        insuranceDAO.InsertInsurance(insurance);
        insuranceDAO.InsertCarInsurance((CarInsurance) insurance);
	}
	
	public void InsertInsurance(String insuranceName, int insuranceFee, String insuranceManual,
			String insuranceSalesManual, InsuranceType insuranceType1, int hospitalizationFee,
			String hospitalizationReason, int outpatientFee, String outpatientReason) {
			
			ActualCostInsurance insurance = new ActualCostInsurance();

			int insuranceID;
			try {
				insuranceID = insuranceDAO.SelectMaxID();
			} catch (Exception e) {
				insuranceID = 1000;
			}
			insuranceID = insuranceID + 1;
			insurance.setInsuranceID(insuranceID);        
			insurance.setInsuranceName(insuranceName);
			insurance.setInsuranceFee(insuranceFee);
			insurance.setInsuranceManual(insuranceManual);
			insurance.setInsuranceSalesManual(insuranceSalesManual);
			insurance.setInsuranceType(insuranceType1);
        	
            Injury hospitalization, outpatient;
            
            hospitalization = new Injury();
            
            hospitalization.setProvisionFee(hospitalizationFee);
            hospitalization.setProvisionReason(hospitalizationReason);
            insurance.setInjuryHospitalization(hospitalization);
            
            outpatient = new Injury();
            
            outpatient.setProvisionFee(outpatientFee);
            outpatient.setProvisionReason(outpatientReason);
            insurance.setInjuryOutpatient(outpatient);
      
            insuranceDAO.InsertInsurance(insurance);
            insuranceDAO.InsertActualCostInsurance(insurance);
	}

	public Vector<Insurance> InsuranceNameVector(String InsuranceType) {
		return insuranceDAO.InsuranceNameVector(InsuranceType);
	}

	public float getInsuranceFee(int insuranceID) throws Exception {
		return insuranceDAO.getInsuranceFee(insuranceID);
	}

	public Vector<Insurance> setVecInsurance(Vector<Subscription> vecSubscription) throws Exception {
		Vector<Insurance> VecInsurance = new Vector<Insurance>();	
		
		for(Subscription Sub : vecSubscription) {
			Insurance insurance = this.FindInsurance(Sub.getInsuranceID());
			VecInsurance.add(insurance);
		}	
		return VecInsurance;
	}

	public Vector<InsuranceType> changeInsuranceType(Vector<String> vecInsuranceTypeString) throws Exception {
		Vector<InsuranceType> VecInsuranceType = new Vector<InsuranceType>();
		
		for(String type : vecInsuranceTypeString) {
			InsuranceType InsuranceType = Insurance.InsuranceType.valueOf(type);
			VecInsuranceType.add(InsuranceType);
		}
		return VecInsuranceType;
	}

	public Vector<CarType> carTypeVector() {	
		Vector<CarType> VecCarType = new Vector<CarType>();
		for (CarType carType : Car.CarType.values()) {
			VecCarType.add(carType);
		}
		return VecCarType;
	}

	public Vector<LicenseType> licenseTypeVector() {
		Vector<LicenseType> VecLicenseType = new Vector<LicenseType>();
		for (LicenseType licenseType : Car.LicenseType.values()) {
			VecLicenseType.add(licenseType);
		}
		return VecLicenseType;
	}

	public Vector<BloodType> bloodTypeVector() {
		Vector<BloodType> VecBloodType = new Vector<BloodType>();
		for (BloodType bloodType : ActualCost.BloodType.values()) {
			VecBloodType.add(bloodType);
		}
		return VecBloodType;
	}

	public Vector<DiseaseHistory> diseaseHistoryVector() {
		Vector<DiseaseHistory> VecDiseaseHistory = new Vector<DiseaseHistory>();
		for (DiseaseHistory diseaseHistory : ActualCost.DiseaseHistory.values()) {
			VecDiseaseHistory.add(diseaseHistory);
		}
		return VecDiseaseHistory;
	}
}
