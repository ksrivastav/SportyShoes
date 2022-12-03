package Repository;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;

import model.OrderDetails;



public class OrderDetailsRepository {

	public OrderDetailsRepository() {
		// TODO Auto-generated constructor stub
	}
	
	private HibernateTemplate hibTemplate;

	public HibernateTemplate getHibTemplate() {
		return hibTemplate;
	}
	
	public void setHibTemplate(HibernateTemplate hibTemplate) {
		this.hibTemplate = hibTemplate;
	}
	
	
	public int createOrderDetails(OrderDetails orderDetails)
	{
		int id = 0;
		
		try {
			
			
						
			Session session = hibTemplate.getSessionFactory().openSession();			
			session.beginTransaction();			
			System.out.println(orderDetails.toString());
			id = (int) session.save(orderDetails);			
			session.getTransaction().commit();			
			return id;
		}
		
		catch(Exception e)
		{
			System.out.println("OrderDetails creation failed:  " + e.getMessage());
			return id;
		}
		
		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<OrderDetails>   getAllOrderDetails()
	{
		
		Session session = this.hibTemplate.getSessionFactory().openSession();
		Query<OrderDetails> query = session.createQuery("From OrderDetails");
		ArrayList<OrderDetails>  orderDetailsList = (ArrayList<OrderDetails>) query.getResultList();		
		return orderDetailsList;		
		
	}
	
	
	

}
