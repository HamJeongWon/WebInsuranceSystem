package com.example.demo.dao;

import java.util.List;
import java.util.Vector;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Subscription.Subscription;
@Repository("com.example.demo.dao.SubscriptionDAO")
public interface SubscriptionDAO {
	
	public List<Subscription> showSubscriptionCustomer() throws Exception;;

}
