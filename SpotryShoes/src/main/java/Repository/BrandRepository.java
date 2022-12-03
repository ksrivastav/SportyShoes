package Repository;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;


import model.Brand;



public class BrandRepository {

	public BrandRepository() {
		
	}
	

	private HibernateTemplate hibTemplate;

	public HibernateTemplate getHibTemplate() {
		return hibTemplate;
	}
	
	public void setHibTemplate(HibernateTemplate hibTemplate) {
		this.hibTemplate = hibTemplate;
	}
	
	
	public int createBrand(Brand brand)
	{
		int id = 0;
		
		try {
			
			
						
			Session session = hibTemplate.getSessionFactory().openSession();			
			session.beginTransaction();			
			System.out.println(brand.toString());
			id = (int) session.save(brand);			
			session.getTransaction().commit();			
			return id;
		}
		
		catch(Exception e)
		{
			System.out.println("Brand creation failed:  " + e.getMessage());
			return id;
		}
		
		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Brand>   getAllBrand()
	{
		
		Session session = this.hibTemplate.getSessionFactory().openSession();
		Query<Brand> query = session.createQuery("From Brand");
		ArrayList<Brand>  brandList = (ArrayList<Brand>) query.getResultList();		
		return brandList;		
		
	}
	
	
	
	
}
