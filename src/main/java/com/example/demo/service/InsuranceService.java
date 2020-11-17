package com.example.demo.service;

import java.util.List;
import java.util.Vector;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.dao.InsuranceDAO;
import com.example.demo.model.Insurance.ActualCostInsurance;
import com.example.demo.model.Insurance.CarInsurance;
import com.example.demo.model.Insurance.FireInsurance;
import com.example.demo.model.Insurance.Insurance;


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

	public void InsertInsurance(Insurance insurance) {
		insuranceDAO.InsertInsurance(insurance);
	}
	
	public void InsertFireInsurance(FireInsurance insurance) {
		insuranceDAO.InsertFireInsurance(insurance);
	}
	
	public void InsertCarInsurance(CarInsurance insurance) {
		insuranceDAO.InsertCarInsurance(insurance);
	}
	
	public void InsertActualCostInsurance(ActualCostInsurance insurance) {
		insuranceDAO.InsertActualCostInsurance(insurance);
	}

	public Vector<Insurance> InsuranceNameVector(String InsuranceType) {
		return insuranceDAO.InsuranceNameVector(InsuranceType);
	}
}
