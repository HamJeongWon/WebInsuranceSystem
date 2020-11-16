package com.example.demo.controller.customer;
import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
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
		Vector<Insurance> VecInsurance = new Vector<Insurance>();
		
		for(Subscription Sub : VecSubscription) {
			Insurance insurance = insuranceService.FindInsurance(Sub.getInsuranceID());
			VecInsurance.add(insurance);
		}

		model.addAttribute("VecSubscription", VecSubscription);
		model.addAttribute("VecInsurance", VecInsurance);
		return "InsertExistingCus1";
	}

	@RequestMapping("/ExistingCus")
	private String ExistingCus(HttpServletRequest request, Model model) throws Exception {
		int CustomerID = Integer.parseInt(request.getParameter("CustomerID"));
		Vector<String> VecInsuranceTypeString = this.subscriptionService.InsuranceTypeVector(CustomerID);
		Vector<InsuranceType> VecInsuranceType = new Vector<InsuranceType>();
		
		for(String type : VecInsuranceTypeString) {
			InsuranceType InsuranceType = Insurance.InsuranceType.valueOf(type);
			VecInsuranceType.add(InsuranceType);
		}

		model.addAttribute("CustomerID", CustomerID);
		model.addAttribute("VecInsuranceType", VecInsuranceType);
		return "InsertExistingCus2";
	}
	
	@RequestMapping("/ExistingCus2")
	private String ExistingCus2(HttpServletRequest request, Model model) throws Exception {
		String url = "";
		Vector<Insurance> InsuVec = new Vector<Insurance>();
		
		int CustomerID = Integer.parseInt(request.getParameter("CustomerID"));
		String InsuranceType = request.getParameter("InsuranceType");

		if (InsuranceType.equals("Fire")) {
			url = "FirePersonalInformation";
			InsuVec = this.insuranceService.InsuranceNameVector("Fire");

		} else if (InsuranceType.equals("Car")) {
			url = "CarPersonalInformation";
			InsuVec = this.insuranceService.InsuranceNameVector("Car");

			Vector<CarType> VecCarType = new Vector<CarType>();
			for (CarType carType : Car.CarType.values()) {
				VecCarType.add(carType);
			}

			Vector<LicenseType> VecLicenseType = new Vector<LicenseType>();
			for (LicenseType licenseType : Car.LicenseType.values()) {
				VecLicenseType.add(licenseType);
			}
			model.addAttribute("carType", VecCarType);
			model.addAttribute("licenseType", VecLicenseType);

		} else if (InsuranceType.equals("ActualCost")) {
			url = "LifePersonalInformation";
			InsuVec = this.insuranceService.InsuranceNameVector("ActualCost");

			Vector<BloodType> VecBloodType = new Vector<BloodType>();
			for (BloodType bloodType : ActualCost.BloodType.values()) {
				VecBloodType.add(bloodType);
			}

			Vector<DiseaseHistory> VecDiseaseHistory = new Vector<DiseaseHistory>();
			for (DiseaseHistory diseaseHistory : ActualCost.DiseaseHistory.values()) {
				VecDiseaseHistory.add(diseaseHistory);
			}
			model.addAttribute("VecBloodType", VecBloodType);
			model.addAttribute("VecDiseaseHistory", VecDiseaseHistory);
		}
		model.addAttribute("InsuVec", InsuVec);
		model.addAttribute("CustomerID", CustomerID);

		return url;
	}
	
	@RequestMapping("/PersonalInfInsurance")
	private String PersonalInfInsurance(HttpServletRequest request, Model model) throws Exception {
	  String url = "";
	  
	  String InsuranceType = request.getParameter("InsuranceTypeForInsert");
	  int CustomerID = Integer.parseInt(request.getParameter("CustomerID"));
	  int InsuranceID = Integer.parseInt(request.getParameter("InsuranceID"));
	  subscriptionService.insertSubscription(InsuranceID, CustomerID);	
	
	  if(InsuranceType.equals("Fire")) {	
	      Building building = new Building();
	      building.setBuildingAddress(request.getParameter("buildingAddress"));
	      building.setBuildingPrice(Integer.parseInt(request.getParameter("buildingPrice")));
	      building.setBuildingScale(request.getParameter("buildingScale"));       
	      customerService.insertBuilding(building, CustomerID);
	      
	      model.addAttribute("CustomerID", CustomerID);
	      model.addAttribute("InsuranceID", InsuranceID);
	      model.addAttribute("building", building);           
	      url = "FirePersonalInformationResult";
	      
		}else if(InsuranceType.equals("Car")) {
			Car car = new Car();
			car.setCarNumber(request.getParameter("carNumber"));
			car.setCarType(Car.CarType.valueOf(request.getParameter("carType")));
			car.setDrivingCareer(Integer.parseInt(request.getParameter("carCareer")));
			car.setLicenseType(Car.LicenseType.valueOf(request.getParameter("licenseType")));
			customerService.insertCar(car, CustomerID);	
			
			model.addAttribute("CustomerID", CustomerID);
			model.addAttribute("InsuranceID", InsuranceID);
			model.addAttribute("car", car);           
			url = "CarPersonalInformationResult";
			
		}else if(InsuranceType.equals("ActualCost")) {
			ActualCost actualCost = new ActualCost();
			actualCost.setBloodType(ActualCost.BloodType.valueOf(request.getParameter("bloodType")));
			actualCost.setDiseaseHistory(ActualCost.DiseaseHistory.valueOf(request.getParameter("diseaseHistory")));			
			String familyDisease = request.getParameter("familyDisease");
			String familyrelation = request.getParameter("familyrelation");
			
			HashMap<String, String> FamilyHistory = new HashMap<String, String>();
			FamilyHistory.put(familyrelation, familyDisease);
			actualCost.setFamilyHistory(FamilyHistory);
			
			HashMap<String, String> hash = actualCost.getFamilyHistory();
			String Key = null;
			String value = null;

			Set set = hash.entrySet();
			Iterator iterator = set.iterator();

			while (iterator.hasNext()) {
				Map.Entry entry = (Map.Entry) iterator.next();
				Key = (String) entry.getKey();
				value = (String) entry.getValue();
			}
			String StringFamilyHistory = Key + ":" + value;
			
			customerService.insertActualCost(actualCost, StringFamilyHistory, CustomerID);
			
			model.addAttribute("CustomerID", CustomerID);
			model.addAttribute("InsuranceID", InsuranceID);
			model.addAttribute("familyrelation", familyrelation);   
			model.addAttribute("familyDisease", familyDisease);    
			model.addAttribute("actualCost", actualCost);           
			url = "LifePersonalInformationResult";
		}
	  return url;
	}
	
	@RequestMapping("/InsertNewCus")
	private String InsertNewCus(HttpServletRequest request, Model model) throws Exception {
		int newCustomerID = customerService.SelectMaxID() + 1;

		Vector<Job> VecJob = new Vector<Job>();
		
		for(Job job : PersonalInformation.Job.values()) {
			VecJob.add(job);
		}
		model.addAttribute("VecJob", VecJob);
		model.addAttribute("newCustomerID", newCustomerID);
		return "InsertNewCus";
	}
	
	@RequestMapping("/NewCus")
	private String NewCus(HttpServletRequest request, Model model) throws Exception {
		int customerID = Integer.parseInt(request.getParameter("customerID"));
		
		Customer customer = new Customer();	
		customer.setCustomerID(customerID);
		customer.setCustomerName(request.getParameter("customerName"));
		customer.setPhoneNum(request.getParameter("phoneNum"));
		
		customerService.insertCustomer(customer);
		
		PersonalInformation personalInformation = new PersonalInformation();
		personalInformation.setJob(PersonalInformation.Job.valueOf(request.getParameter("job")));
		personalInformation.setAccidentHistory(request.getParameter("accidentHistory"));
		personalInformation.setAccountNumber(Integer.parseInt(request.getParameter("accountNumber")));
		personalInformation.setProperty(Integer.parseInt(request.getParameter("property")));
		personalInformation.setResidentRegistrationNumber(request.getParameter("residentRegistrationNumber"));

		String sex = request.getParameter("sex");
		if (sex.equals("M")) {
			personalInformation.setGender(true);
		} else {
			personalInformation.setGender(false);
		}
		
		String job = personalInformation.getJob().toString();
		
		customerService.insertPersonalInformation(personalInformation, job, customerID);

		Vector<InsuranceType> VecInsuranceType = new Vector<InsuranceType>();

		model.addAttribute("CustomerID", customerID);
		model.addAttribute("VecInsuranceType", VecInsuranceType);
		return "InsertExistingCus2";
	}
}
