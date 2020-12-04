package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SubscriptionDAO;
import com.example.demo.model.Subscription.Subscription;


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

	public void insertSubscription(int insuranceID, int customerID) throws Exception{
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("insuranceID", insuranceID);
		hash.put("customerID", customerID);
		subscriptionDAO.insertSubscription(hash);   
	}

	public List<Subscription> showAcceptanceAprove() throws Exception {
		return subscriptionDAO.showAcceptanceAprove();
	}


	public Vector<Integer> findAcceptanceAproveID() throws Exception {
		Vector<Integer> idVector = new Vector<Integer>();
		for(int i=0; i<subscriptionDAO.showAcceptanceAprove().size(); i++) {
			idVector.add(subscriptionDAO.showAcceptanceAprove().get(i).getInsuranceID());
			idVector.add(subscriptionDAO.showAcceptanceAprove().get(i).getCustomerID());

		}
		return idVector;
	}

	public List<Integer> findSubscriptionCustomerID() {
		List<Integer> accidentIDList = new ArrayList<Integer>();
		for(int i=0; i<subscriptionDAO.showSubscriptionCustomer().size(); i++) {
			accidentIDList.add(subscriptionDAO.showSubscriptionCustomer().get(i).getInsuranceID());
			accidentIDList.add(subscriptionDAO.showSubscriptionCustomer().get(i).getCustomerID());
		}
		return accidentIDList;	
	}
	
	
	public List<Integer> InsuranceSubscription()throws Exception{
		List<Integer> subscriptionIDList = new ArrayList<Integer>();
		for(int i=0; i<showAcceptanceAprove().size(); i++) {
			subscriptionIDList.add(showAcceptanceAprove().get(i).getInsuranceID());
			subscriptionIDList.add(showAcceptanceAprove().get(i).getCustomerID());
		}
		
		return subscriptionIDList;
	}

	public void updateSubscriptionStatus(int customerID, int insuranceID)throws Exception {
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("customerID", customerID);
		hash.put("insuranceID", insuranceID); 
		this.subscriptionDAO.updateSubscriptionStatus(hash);
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

	public void deleteSubscription(int customerID, int insuranceID)throws Exception  {
		  HashMap<String, Object> hash = new HashMap<String, Object>();
	      hash.put("customerID", customerID);
	      hash.put("insuranceID", insuranceID); 
	      this.subscriptionDAO.deleteSubscription(hash);
	}
}
