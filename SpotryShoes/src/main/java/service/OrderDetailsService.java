package service;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import Repository.OrderDetailsRepository;
import model.OrderDetails;




public class OrderDetailsService {

	public OrderDetailsService() {
		// TODO Auto-generated constructor stub
	}
	

private ApplicationContext appContext;
	
	public ApplicationContext getAppContext() {
		return appContext;
	}
	
	public void setAppContext() {
		this.appContext = new ClassPathXmlApplicationContext("SportyShoesBeans.xml");
	}
	
	public int createOrderDetails(OrderDetails orderDetails)
	{
		int id=0;
		
		try
		{
			setAppContext();
			OrderDetailsRepository productcategoryRepo = (OrderDetailsRepository) this.appContext.getBean("OrderDetailsRepository");
			id = (int)productcategoryRepo.createOrderDetails(orderDetails);			
			return id;
		}
		catch(Exception e)
		{
			System.out.println("OrderDetails failed : "+ e.getMessage());
			return id;
		}
	}
	
	public ArrayList<OrderDetails>   getAllOrderDetails()
	{
		
		setAppContext();
		OrderDetailsRepository orderDetailsRepo = (OrderDetailsRepository) this.appContext.getBean("OrderDetailsRepository");
		ArrayList<OrderDetails>  orderDetailsList =  orderDetailsRepo.getAllOrderDetails();
		return orderDetailsList;		
		
	}

}
