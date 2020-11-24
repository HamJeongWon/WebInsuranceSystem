package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Subscription.Subscription;


@Repository("com.example.demo.dao.SubscriptionDAO")
public interface SubscriptionDAO{
	
	public Vector<Subscription> SubscriptionVector() throws Exception;

	public Vector<String> InsuranceTypeVector(int customerID);

	public void insertSubscription(int insuranceID, int customerID);

	public List<Subscription> showSubscriptionCustomer();

	public void insertSubscription(HashMap<String, Object> hash);

	public Vector<Subscription> showSubscriptionNoContractID() throws Exception;

	public void insertContratIDtoSubscription(Subscription subscription);
}
