package service;




import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



import Repository.OrderRepository;

import model.Order;



public class OrderService {

	public OrderService() {
		// TODO Auto-generated constructor stub
	}
	

private ApplicationContext appContext;
	
	public ApplicationContext getAppContext() {
		return appContext;
	}
	
	public void setAppContext() {
		this.appContext = new ClassPathXmlApplicationContext("SportyShoesBeans.xml");
	}
	
	public int createOrder(Order order)
	{
		int id=0;
		
		try
		{
			setAppContext();
			OrderRepository productcategoryRepo = (OrderRepository) this.appContext.getBean("OrderRepository");
			id = (int)productcategoryRepo.createOrder(order);			
			return id;
		}
		catch(Exception e)
		{
			System.out.println("Order failed : "+ e.getMessage());
			return id;
		}
	}
	
	public ArrayList<Order>   getAllOrder()
	{
		
		setAppContext();
		OrderRepository orderRepo = (OrderRepository) this.appContext.getBean("OrderRepository");
		ArrayList<Order>  orderList =  orderRepo.getAllOrder();
		return orderList;		
		
	}
	

	
}
