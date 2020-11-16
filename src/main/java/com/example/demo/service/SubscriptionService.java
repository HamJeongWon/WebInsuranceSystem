package com.example.demo.service;

import java.util.List;
import java.util.Vector;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.example.demo.dao.CustomerDAO;
import com.example.demo.dao.SubscriptionDAO;
import com.example.demo.model.Insurance.Insurance.InsuranceType;
import com.example.demo.model.Subscription.Subscription;
import com.example.demo.model.Insurance.Insurance;


@Service("com.example.demo.service.SubscriptionService")
public class SubscriptionService {
	
    @Resource(name="com.example.demo.dao.SubscriptionDAO")
    SubscriptionDAO subscriptionDAO;
    
	public Vector<Subscription> SubscriptionVector() throws Exception {
		return subscriptionDAO.SubscriptionVector();
	}

	public Vector<String> InsuranceTypeVector(int customerID) {
		return subscriptionDAO.InsuranceTypeVector(customerID);
	}

	public void insertSubscription(int insuranceID, int customerID) {
		subscriptionDAO.insertSubscription(insuranceID, customerID);	
	}
	
   
}
