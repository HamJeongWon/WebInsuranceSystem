package com.example.demo.model.Subscription;

public class Subscription {
	private int insuranceID;
	private int CustomerID;
	private int ContractID;
	private int subscription;
	
	public Subscription() {
		this.insuranceID = 0;
		this.CustomerID = 0;
		this.ContractID = 0;
		this.subscription = 0;
	}
	
	public int getInsuranceID() {
		return insuranceID;
	}
	public void setInsuranceID(int insuranceID) {
		this.insuranceID = insuranceID;
	}
	public int getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}
	public int getContractID() {
		return ContractID;
	}
	public void setContractID(int contractID) {
		ContractID = contractID;
	}
	public int getSubscription() {
		return subscription;
	}
	public void setSubscription(int subscription) {
		this.subscription = subscription;
	}
}
