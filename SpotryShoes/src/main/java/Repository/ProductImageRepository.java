package Repository;



import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;


import model.ProductImage;


public class ProductImageRepository {

	private HibernateTemplate hibTemplate;

	public HibernateTemplate getHibTemplate() {
		return hibTemplate;
	}
	
	public void setHibTemplate(HibernateTemplate hibTemplate) {
		this.hibTemplate = hibTemplate;
	}
	
	
	


	public ProductImageRepository() {
		// TODO Auto-generated constructor stub
	}
	
	public int createProductImage(ProductImage productImage)
	{
		int id = 0;
		
		try {
			
			
						
			Session session = hibTemplate.getSessionFactory().openSession();			
			session.beginTransaction();			
			System.out.println(productImage.toString());
			id = (int) session.save(productImage);			
			session.getTransaction().commit();			
			return id;
		}
		
		catch(Exception e)
		{
			System.out.println("ProductImage:  " + e.getMessage());
			return id;
		}
		
		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<ProductImage>   getAllProductImage()
	{
		
		Session session = this.hibTemplate.getSessionFactory().openSession();
		Query<ProductImage> query = session.createQuery("From ProductImage");
		ArrayList<ProductImage>  productImageList = (ArrayList<ProductImage>) query.getResultList();		
		return productImageList;		
		
	}
	
	
	

}
