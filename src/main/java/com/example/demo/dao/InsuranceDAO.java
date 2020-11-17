package com.example.demo.dao;

import java.util.List;
import java.util.Vector;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Insurance.ActualCostInsurance;
import com.example.demo.model.Insurance.CarInsurance;
import com.example.demo.model.Insurance.FireInsurance;
import com.example.demo.model.Insurance.Insurance;

@Repository("com.example.demo.dao.InsuranceDAO")
public interface InsuranceDAO{
	
	public int SelectMaxID();
	
	public int CheckInsuranceName(String record);
	
	public List<Insurance> searchInsuranceIDandName() throws Exception;	
	
	public Insurance FindInsurance(int InsuranceID) throws Exception;

	public FireInsurance ResultFInsurance(int insuranceID) throws Exception;

	public CarInsurance ResultCInsurance(int insuranceID) throws Exception;

	public ActualCostInsurance ResultAInsurance(int insuranceID) throws Exception;

	public void InsertInsurance(Insurance insurance);
	
	public void InsertFireInsurance(FireInsurance fireInsurance);
	
	public void InsertCarInsurance(CarInsurance carInsurance);
	
	public void InsertActualCostInsurance(ActualCostInsurance actualCostInsurance);

	public float getInsuranceFee(int insuranceID) throws Exception;

	public Vector<Insurance> InsuranceNameVector(String insuranceType);

}
