package com.example.demo.service;

import java.util.Vector;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.example.demo.dao.AcceptanceDAO;
import com.example.demo.model.Acceptance.AcceptanceGuide;
import com.example.demo.model.Insurance.Insurance;

@Service("com.example.demo.service.AcceptanceGuideService")
public class AcceptanceGuideService {
	
    @Resource(name="com.example.demo.dao.AcceptanceDAO")
    AcceptanceDAO acceptanceDAO;

	public int SelectMaxID(String string, String string2) {
		return acceptanceDAO.SelectMaxID();
	}

	public void InsertAcceptanceGuide(HttpServletRequest request) {
        AcceptanceGuide acceptanceGuide = new AcceptanceGuide();
        int acceptanceID;
        try {
        	acceptanceID = SelectMaxID("acceptanceID", "Acceptance");
        } catch (Exception e) {
        	acceptanceID = 5000;
        }
		acceptanceID = acceptanceID + 1;
		acceptanceGuide.setAcceptanceID(acceptanceID);	
		acceptanceGuide.setScamCase(request.getParameter("ScamCase"));	
		acceptanceGuide.setRiskEvaluation(AcceptanceGuide.RiskEvaluation.valueOf(request.getParameter("RiskEvaluation")));
		acceptanceGuide.setInsuranceID(Integer.parseInt(request.getParameter("InsuranceID")));
		acceptanceDAO.InsertAcceptanceGuide(acceptanceGuide);
	}

	public Vector<AcceptanceGuide> searchAcceptanceForInsurance(String string) {
		return new Vector<AcceptanceGuide>(acceptanceDAO.searchAcceptanceForInsurance(string));
	}

	public Vector<Insurance> SearchNullAcceptanceInsuranceID() {
		return new Vector<Insurance>(acceptanceDAO.SearchNullAcceptanceInsuranceID());
	}

	public AcceptanceGuide getAcceptanceGuide(int acceptanceID) {
		return acceptanceDAO.getAcceptanceGuide(acceptanceID);
	}
	
	public AcceptanceGuide findAcceptance(int insuranceID) throws Exception {
		AcceptanceGuide acceptanceGuide = acceptanceDAO.findAcceptance(insuranceID);
		if (acceptanceGuide.getAcceptanceID() == 0) {
			acceptanceGuide.setAcceptanceID(5001);
		}
		
		return acceptanceGuide;
	}
}
