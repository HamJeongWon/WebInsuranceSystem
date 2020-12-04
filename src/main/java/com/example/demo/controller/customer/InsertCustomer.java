package com.example.demo.controller.customer;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Customer.ActualCost;
import com.example.demo.model.Customer.ActualCost.BloodType;
import com.example.demo.model.Customer.ActualCost.DiseaseHistory;
import com.example.demo.model.Customer.Building;
import com.example.demo.model.Customer.Car;
import com.example.demo.model.Customer.Car.CarType;
import com.example.demo.model.Customer.Car.LicenseType;
import com.example.demo.model.Customer.Customer;
import com.example.demo.model.Customer.PersonalInformation;
import com.example.demo.model.Customer.PersonalInformation.Job;
import com.example.demo.model.Insurance.Insurance;
import com.example.demo.model.Insurance.Insurance.InsuranceType;
import com.example.demo.model.Subscription.Subscription;
import com.example.demo.service.CustomerService;
import com.example.demo.service.InsuranceService;
import com.example.demo.service.SubscriptionService;

@Controller
public class InsertCustomer {
	@Resource(name="com.example.demo.service.CustomerService")
	CustomerService customerService;
	
	@Resource(name="com.example.demo.service.SubscriptionService")
	SubscriptionService subscriptionService;
	
	@Resource(name="com.example.demo.service.InsuranceService")
	InsuranceService insuranceService;
	
	@RequestMapping("/SalesActivityDesign")
	private String SalesActivityDesign(Model model) throws Exception{
		return "SalesActivityDesign";
	}
	
	@RequestMapping("/ProductSubscription")
	private String ProductSubscription(Model model) throws Exception{
		return "ProductSubscription";
	}
	
	@RequestMapping("/InsertExistingCus")
	private String SubscriptionVector(Model model) throws Exception{
		Vector<Subscription> VecSubscription = this.subscriptionService.SubscriptionVector();
		Vector<Insurance> VecInsurance = insuranceService.setVecInsurance(VecSubscription);	
		
		model.addAttribute("VecSubscription", VecSubscription);
		model.addAttribute("VecInsurance", VecInsurance);
		return "InsertExistingCus1";
	}

	@RequestMapping("/ExistingCus")
	private String ExistingCus(HttpServletRequest request, Model model) throws Exception {
		int CustomerID = Integer.parseInt(request.getParameter("CustomerID"));
		Vector<String> VecInsuranceTypeString = this.subscriptionService.InsuranceTypeVector(CustomerID);
		Vector<InsuranceType> VecInsuranceType = insuranceService.changeInsuranceType(VecInsuranceTypeString);

		model.addAttribute("CustomerID", CustomerID);
		model.addAttribute("VecInsuranceType", VecInsuranceType);
		return "InsertExistingCus2";
	}
	
	@RequestMapping("/ExistingCus2")
	private String ExistingCus2(HttpServletRequest request, Model model) throws Exception {
		int CustomerID = Integer.parseInt(request.getParameter("CustomerID"));
		String InsuranceType = request.getParameter("InsuranceType");		
		
		if (InsuranceType.equals("Fire")) {
			Vector<Insurance> InsuVec = this.insuranceService.InsuranceNameVector("Fire");
			
			model.addAttribute("InsuVec", InsuVec);
			model.addAttribute("CustomerID", CustomerID);

			return "FirePersonalInformation";
			
		} else if (InsuranceType.equals("Car")) {
			Vector<Insurance> InsuVec = this.insuranceService.InsuranceNameVector("Car");
			Vector<CarType> VecCarType = this.insuranceService.carTypeVector();
			Vector<LicenseType> VecLicenseType = this.insuranceService.licenseTypeVector();
			
			model.addAttribute("carType", VecCarType);
			model.addAttribute("licenseType", VecLicenseType);
			model.addAttribute("InsuVec", InsuVec);
			model.addAttribute("CustomerID", CustomerID);

			return "CarPersonalInformation";
			
		} else if (InsuranceType.equals("ActualCost")) {		
			Vector<Insurance> InsuVec = this.insuranceService.InsuranceNameVector("ActualCost");
			Vector<BloodType> VecBloodType = this.insuranceService.bloodTypeVector();
			Vector<DiseaseHistory> VecDiseaseHistory = this.insuranceService.diseaseHistoryVector();

			model.addAttribute("VecBloodType", VecBloodType);
			model.addAttribute("VecDiseaseHistory", VecDiseaseHistory);
			model.addAttribute("InsuVec", InsuVec);
			model.addAttribute("CustomerID", CustomerID);
			
			return "LifePersonalInformation";
		}
		return null;
	}
	
	@RequestMapping("/PersonalInfInsurance")
	private String PersonalInfInsurance(HttpServletRequest request, Model model) throws Exception {
	  String InsuranceType = request.getParameter("InsuranceTypeForInsert");
	  int CustomerID = Integer.parseInt(request.getParameter("CustomerID"));
	  int InsuranceID = Integer.parseInt(request.getParameter("InsuranceID"));
	  subscriptionService.insertSubscription(InsuranceID, CustomerID);	
	
	  if(InsuranceType.equals("Fire")) {	
	      String buildingAddress = request.getParameter("buildingAddress");
	      int buildingPrice = Integer.parseInt(request.getParameter("buildingPrice"));
	      String buildingScale = request.getParameter("buildingScale"); 
	      Building building = customerService.insertBuilding(CustomerID, buildingAddress, buildingPrice, buildingScale);
	      
	      model.addAttribute("CustomerID", CustomerID);
	      model.addAttribute("InsuranceID", InsuranceID);
	      model.addAttribute("building", building);           
	      return "FirePersonalInformationResult";
	      
		}else if(InsuranceType.equals("Car")) {
			String carNumber = request.getParameter("carNumber");
			Car.CarType carType = Car.CarType.valueOf(request.getParameter("carType"));
			int carCareer = Integer.parseInt(request.getParameter("carCareer"));
			Car.LicenseType licenseType = Car.LicenseType.valueOf(request.getParameter("licenseType"));
			Car car = customerService.insertCar(CustomerID, carNumber, carType, carCareer, licenseType);	
			
			model.addAttribute("CustomerID", CustomerID);
			model.addAttribute("InsuranceID", InsuranceID);
			model.addAttribute("car", car);           
			return "CarPersonalInformationResult";
			
		}else if(InsuranceType.equals("ActualCost")) {

			ActualCost.BloodType bloodType = ActualCost.BloodType.valueOf(request.getParameter("bloodType"));
			ActualCost.DiseaseHistory diseaseHistory = ActualCost.DiseaseHistory.valueOf(request.getParameter("diseaseHistory"));
			String familyDisease = request.getParameter("familyDisease");
			String familyrelation = request.getParameter("familyrelation");		
			ActualCost actualCost = customerService.insertActualCost(CustomerID, bloodType, diseaseHistory, familyDisease, familyrelation);
			
			model.addAttribute("CustomerID", CustomerID);
			model.addAttribute("InsuranceID", InsuranceID);
			model.addAttribute("familyrelation", familyrelation);   
			model.addAttribute("familyDisease", familyDisease);    
			model.addAttribute("actualCost", actualCost);           
			return "LifePersonalInformationResult";
		}
	  return null;
	}
	
	@RequestMapping("/InsertNewCus")
	private String InsertNewCus(HttpServletRequest request, Model model) throws Exception {
		Vector<Job> VecJob = this.customerService.jobVector();		
		model.addAttribute("VecJob", VecJob);
		model.addAttribute("newCustomerID", customerService.SelectMaxID()+1);
		return "InsertNewCus";
	}
	
	@RequestMapping("/NewCus")
	private String NewCus(HttpServletRequest request, Model model) throws Exception {
		int customerID = Integer.parseInt(request.getParameter("customerID"));
		String customerName = request.getParameter("customerName");
		String phoneNum = request.getParameter("phoneNum");
		
		customerService.insertCustomer(customerID, customerName, phoneNum);
		
		PersonalInformation.Job job = PersonalInformation.Job.valueOf(request.getParameter("job"));
		String accidentHistory = request.getParameter("accidentHistory");
		int accountNumber = Integer.parseInt(request.getParameter("accountNumber"));
		int property = Integer.parseInt(request.getParameter("property"));
		String residentRegistrationNumber = request.getParameter("residentRegistrationNumber");
		String sex = request.getParameter("sex");
		
		customerService.insertPersonalInformation(customerID, job, accidentHistory, accountNumber, property, residentRegistrationNumber, sex);


		model.addAttribute("CustomerID", customerID);
		model.addAttribute("VecInsuranceType",  new Vector<InsuranceType>());
		return "InsertExistingCus2";
	}
}
