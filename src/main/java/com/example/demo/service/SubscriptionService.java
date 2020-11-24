package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AcceptanceDAO;
import com.example.demo.dao.ContractDAO;
import com.example.demo.dao.CustomerDAO;
import com.example.demo.dao.SubscriptionDAO;
import com.example.demo.model.Subscription.Subscription;
import com.example.demo.model.Acceptance.AcceptanceGuide;
import com.example.demo.model.Customer.ActualCost;
import com.example.demo.model.Customer.Customer;


@Service("com.example.demo.service.SubscriptionService")
public class SubscriptionService {
	
    @Resource(name="com.example.demo.dao.SubscriptionDAO")
    SubscriptionDAO subscriptionDAO;
    
    @Resource(name="com.example.demo.dao.AcceptanceDAO")
    AcceptanceDAO acceptanceDAO;
    
    @Resource(name="com.example.demo.dao.ContractDAO")
    ContractDAO contractDAO;
    
    @Resource(name="com.example.demo.dao.CustomerDAO")
    CustomerDAO customerDAO;
    
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

	public void JudgementInsuranceSubscription(int num,HttpServletRequest request) throws Exception {
		int index = num - 2;
		Vector<Integer> idVector = new Vector<Integer>();
		for(int i=0; i<subscriptionDAO.showAcceptanceAprove().size(); i++) {
			idVector.add(subscriptionDAO.showAcceptanceAprove().get(i).getInsuranceID());
			idVector.add(subscriptionDAO.showAcceptanceAprove().get(i).getCustomerID());
			
		}
		
		int insuranceID = idVector.get(index);
		int customerID = idVector.get(index+1);
		
		AcceptanceGuide acceptanceGuide = acceptanceDAO.findAcceptance(insuranceID);
		Customer customer = contractDAO.findCustomer(customerID);
		

		if (acceptanceGuide.getAcceptanceID() == 0) {
			acceptanceGuide.setAcceptanceID(5001);
		}
		
		request.setAttribute("insuranceID", insuranceID);
		request.setAttribute("acceptanceGuide", acceptanceGuide);
		request.setAttribute("customer", customer);
		request.setAttribute("personalInformation", customerDAO.findPersonalInformation(customerID));
		request.setAttribute("insuranceType", customerDAO.getInsuranceType2(insuranceID).getInsuranceType());
		customer.setPersonalInformation(customerDAO.findPersonalInformation(customerID));
	
		// ���� ������ ���� �� ���� �Ʒ� ������ ��������
		switch (this.customerDAO.getInsuranceType2(insuranceID).getInsuranceType()) {
		case Fire: // ȭ�纸��
			
			request.setAttribute("insurance", this.customerDAO.findBuildingCustomer(customerID));
			break;
		case Car:// �ڵ�������
			request.setAttribute("insurance", this.customerDAO.findCarCustomer(customerID));
			
			break;
		case ActualCost:// �Ǻ���
			String[] famillyHistoryArr = null;
			ActualCost actualCost= this.customerDAO.findActualCostCustomer(customerID);
			HashMap<String, String> famillyHistory = new HashMap<String, String>();
			famillyHistoryArr = customerDAO.findActualCostCustomer(customerID).getTempFamilyHistory().split(":");
			famillyHistory.put(famillyHistoryArr[0], famillyHistoryArr[1]);
			actualCost.setFamilyHistory(famillyHistory);
			request.setAttribute("insurance", actualCost);
			break;
		}
		
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
