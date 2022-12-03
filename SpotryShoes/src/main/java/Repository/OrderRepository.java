package Repository;



import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;

import model.Order;


public class OrderRepository {

	public OrderRepository() {
		// TODO Auto-generated constructor stub
	}
	
	private HibernateTemplate hibTemplate;

	public HibernateTemplate getHibTemplate() {
		return hibTemplate;
	}
	
	public void setHibTemplate(HibernateTemplate hibTemplate) {
		this.hibTemplate = hibTemplate;
	}
	
	
	public int createOrder(Order order)
	{
		int id = 0;
		
		try {
			
			
						
			Session session = hibTemplate.getSessionFactory().openSession();			
			session.beginTransaction();			
			System.out.println(order.toString());
			id = (int) session.save(order);			
			session.getTransaction().commit();			
			return id;
		}
		
		catch(Exception e)
		{
			System.out.println("Order creation failed:  " + e.getMessage());
			return id;
		}
		
		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Order>   getAllOrder()
	{
		
		Session session = this.hibTemplate.getSessionFactory().openSession();
		Query<Order> query = session.createQuery("From Order");
		ArrayList<Order>  orderList = (ArrayList<Order>) query.getResultList();
		
		return orderList;		
		
	}
	
	
	

}
