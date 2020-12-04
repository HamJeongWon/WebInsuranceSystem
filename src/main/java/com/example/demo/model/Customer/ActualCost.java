package com.example.demo.model.Customer;

import java.util.HashMap;

public class ActualCost extends PersonalInformation {
	
	public enum BloodType {
		A, B, O, AB, RHMinus
	};
	
	public enum DiseaseHistory{
		Cancer, Diabetes, Hypertension,  MyocardialInfarction, Hyperlipidemia, Stroke
	};
	
	private BloodType bloodType;
	private String FamilyHistory;
	private DiseaseHistory diseaseHistory;


	public ActualCost() {
		this.bloodType = null;
		this.FamilyHistory = null;
		this.diseaseHistory = null;
	}
	

	public BloodType getBloodType() {
		return bloodType;
	}

	public void setBloodType(BloodType bloodType) {
		this.bloodType = bloodType;
	}
	
	public DiseaseHistory getDiseaseHistory() {
		return diseaseHistory;
	}

	public void setDiseaseHistory(DiseaseHistory diseaseHistory) {
		this.diseaseHistory = diseaseHistory;
	}

	public String getFamilyHistory() {
		return FamilyHistory;
	}

	public void setFamilyHistory(String familyHistory) {
		FamilyHistory = familyHistory;
	}

}