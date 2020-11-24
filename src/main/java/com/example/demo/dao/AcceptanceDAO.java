package com.example.demo.dao;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Acceptance.AcceptanceGuide;
import com.example.demo.model.Insurance.Insurance;

@Repository("com.example.demo.dao.AcceptanceDAO")
public interface AcceptanceDAO {

	public int SelectMaxID();
	
	public void InsertAcceptanceGuide(AcceptanceGuide acceptanceGuide);

	public List<Insurance> SearchNullAcceptanceInsuranceID();

	public List<AcceptanceGuide> searchAcceptanceForInsurance(String string);

	public AcceptanceGuide getAcceptanceGuide(int acceptanceID);
	
	public AcceptanceGuide findAcceptance(int insuranceID) throws Exception;

}
