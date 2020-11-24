package com.example.demo.service;

import java.util.HashMap;
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
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("insuranceID", insuranceID);
		hash.put("customerID", customerID);
		subscriptionDAO.insertSubscription(hash);	
	}

	public Vector<Integer> showSubscriptionNoContractID() throws Exception {
		Vector<Subscription> VecSubscription = subscriptionDAO.showSubscriptionNoContractID();
		Vector<Integer> IDVector = new Vector<Integer>();
		
		for(Subscription subscription: VecSubscription) {
			IDVector.add(subscription.getInsuranceID());
			IDVector.add(subscription.getCustomerID());		
		}
		return IDVector;
	}

	public void insertContratIDtoSubscription(int contractID, int customerID, int insuranceID) throws Exception{
		Subscription subscription = new Subscription();
		subscription.setContractID(contractID);
		subscription.setCustomerID(customerID);
		subscription.setInsuranceID(insuranceID);

		subscriptionDAO.insertContratIDtoSubscription(subscription);
	}
	
   
}
