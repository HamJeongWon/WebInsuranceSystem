package com.example.demo.model.Accident;

public interface AccidentInterface {
	
	public boolean add(Accident Accident);

	public boolean delete(int InsuranceID);

	public Accident search(int InsuranceID);
	
}