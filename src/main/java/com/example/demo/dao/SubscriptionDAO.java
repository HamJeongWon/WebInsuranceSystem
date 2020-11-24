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

	public List<Subscription> showSubscriptionCustomer();

	public List<Subscription> showAcceptanceAprove()throws Exception;

	public void insertSubscription(HashMap<String, Object> hash);

	public void updateSubscriptionStatus(HashMap<String, Object> hash) throws Exception;

	public void deleteSubscription(HashMap<String, Object> hash) throws Exception;

	public Vector<Subscription> showSubscriptionNoContractID() throws Exception;

	public void insertContratIDtoSubscription(Subscription subscription);
}
