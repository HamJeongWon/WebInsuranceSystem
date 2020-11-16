package com.example.demo.dao;

import java.util.Vector;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Insurance.Insurance.InsuranceType;
import com.example.demo.model.Insurance.Insurance;
import com.example.demo.model.Subscription.Subscription;


@Repository("com.example.demo.dao.SubscriptionDAO")
public interface SubscriptionDAO{
	
	public Vector<Subscription> SubscriptionVector() throws Exception;

	public Vector<String> InsuranceTypeVector(int customerID);

	public void insertSubscription(int insuranceID, int customerID);
	

}
