package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import com.example.demo.model.Insurance.Insurance;

@Repository("com.example.demo.dao.InsuranceDAO")
public interface InsuranceDAO{	
	public List<Insurance> searchInsuranceIDandName() throws Exception;
	
	public Map<String, Object> ResultFInsurance(int insuranceID) throws Exception;
	
	public Map<String, Object> ResultCInsurance(int insuranceID) throws Exception;
	
	public Map<String, Object> ResultAInsurance(int insuranceID) throws Exception;

}
