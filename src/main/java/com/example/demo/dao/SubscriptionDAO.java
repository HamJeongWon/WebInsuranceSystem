package com.example.demo.dao;

import java.util.List;
import java.util.Vector;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Subscription.Subscription;


@Repository("com.example.demo.dao.SubscriptionDAO")
public interface SubscriptionDAO{
	
	
	
	public Vector<Subscription> SubscriptionVector() throws Exception;

	public Vector<String> InsuranceTypeVector(int customerID);

	public void insertSubscription(int insuranceID, int customerID);

	public List<Subscription> showSubscriptionCustomer();

	public List<Subscription> showAcceptanceAprove()throws Exception;

}
