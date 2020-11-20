package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Acceptance.AcceptanceGuide;

@Repository("com.example.demo.dao.AcceptanceDAO")
public interface AcceptanceDAO {

	public AcceptanceGuide findAcceptance(int insuranceID) throws Exception;

}
