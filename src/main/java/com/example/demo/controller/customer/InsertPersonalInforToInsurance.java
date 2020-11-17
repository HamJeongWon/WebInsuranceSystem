//package com.example.demo.controller.customer;
//
//import java.io.IOException;
//import java.util.HashMap;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import DAO.customerDAO;
//import DAO.insuranceDAO;
//import DAO.subscriptionDAO;
//
///**
// * Servlet implementation class InsertPersonalInforToInsurance
// */
//@WebServlet("/PersonalInfInsurance")
//public class InsertPersonalInforToInsurance extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//    customerDAO customerDAO;
//    subscriptionDAO subscriptionDAO;
//    
//    public InsertPersonalInforToInsurance() {
//        super();
//    }
//
//	public void init(ServletConfig config) throws ServletException {
//		super.init(config);
//		this.customerDAO = new customerDAO();
//		this.subscriptionDAO = new subscriptionDAO();
//	}
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html; charset=euc-kr");	
//        String url = "";
//        
//        String InsuranceType = request.getParameter("InsuranceTypeForInsert");
//        int CustomerID = Integer.parseInt(request.getParameter("CustomerID"));
//        int InsuranceID = Integer.parseInt(request.getParameter("InsuranceID"));
//        subscriptionDAO.insertSubscription(InsuranceID, CustomerID);	
//   
//        if(InsuranceType.equals("Fire")) {	
//            Building building = new Building();
//            building.setBuildingAddress(request.getParameter("buildingAddress"));
//            building.setBuildingPrice(Integer.parseInt(request.getParameter("buildingPrice")));
//            building.setBuildingScale(request.getParameter("buildingScale"));       
//            customerDAO.insertBuilding(building, CustomerID);
//            
//            request.setAttribute("CustomerID", CustomerID);
//            request.setAttribute("InsuranceID", InsuranceID);
//            request.setAttribute("building", building);           
//            url = "FirePersonalInformationResult.jsp";
//            
//		}else if(InsuranceType.equals("Car")) {
//			Car car = new Car();
//			car.setCarNumber(request.getParameter("carNumber"));
//			car.setCarType(Car.CarType.valueOf(request.getParameter("carType")));
//			car.setDrivingCareer(Integer.parseInt(request.getParameter("carCareer")));
//			car.setLicenseType(Car.LicenseType.valueOf(request.getParameter("licenseType")));
//			customerDAO.insertCar(car, CustomerID);	
//			
//			request.setAttribute("CustomerID", CustomerID);
//	        request.setAttribute("InsuranceID", InsuranceID);
//	        request.setAttribute("car", car);           
//	        url = "CarPersonalInformationResult.jsp";
//			
//		}else if(InsuranceType.equals("ActualCost")) {
//			ActualCost actualCost = new ActualCost();
//			actualCost.setBloodType(ActualCost.BloodType.valueOf(request.getParameter("bloodType")));
//			actualCost.setDiseaseHistory(ActualCost.DiseaseHistory.valueOf(request.getParameter("diseaseHistory")));			
//			String familyDisease = request.getParameter("familyDisease");
//			String familyrelation = request.getParameter("familyrelation");
//			HashMap<String, String> FamilyHistory = new HashMap<String, String>();
//			FamilyHistory.put(familyrelation, familyDisease);
//			
//			actualCost.setFamilyHistory(FamilyHistory);
//			customerDAO.insertActualCost(actualCost, CustomerID);
//			
//			request.setAttribute("CustomerID", CustomerID);
//	        request.setAttribute("InsuranceID", InsuranceID);
//	        request.setAttribute("familyrelation", familyrelation);   
//	        request.setAttribute("familyDisease", familyDisease);    
//	        request.setAttribute("actualCost", actualCost);           
//	        url = "LifePersonalInformationResult.jsp";
//		}
//        
//		RequestDispatcher disp = request.getRequestDispatcher(url);
//		disp.forward(request, response);	
//	}
//}
