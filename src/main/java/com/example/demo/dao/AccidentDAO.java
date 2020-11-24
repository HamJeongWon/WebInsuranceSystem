package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Accident.Accident;

@Repository("com.example.demo.dao.AccidentDAO")
public interface AccidentDAO {
	
	public List<Accident> showAllAccidentIDFromCalculateAccidentFund() throws Exception;

	public int SelectMaxID() throws Exception;

	public void insertAccident(Accident accident)throws Exception;

	public Accident findAccident(int accidentID) throws Exception;

	public void insertInsurancePayment(Accident accident)throws Exception;

	public void updatePayInsurancePremium(Accident accident)throws Exception;

	public List<Accident> showAllAccidentIDFromPaymentAccidentFund()throws Exception;

}
