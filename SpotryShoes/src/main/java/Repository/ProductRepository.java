package Repository;


import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;
import model.Product;



public class ProductRepository {

	private HibernateTemplate hibTemplate;

	public HibernateTemplate getHibTemplate() {
		return hibTemplate;
	}
	
	public void setHibTemplate(HibernateTemplate hibTemplate) {
		this.hibTemplate = hibTemplate;
	}
	
	
	


	public ProductRepository() {
		// TODO Auto-generated constructor stub
	}
	
	public int createProduct(Product product)
	{
		int id = 0;
		
		try {
			
			
						
			Session session = hibTemplate.getSessionFactory().openSession();			
			session.beginTransaction();			
			System.out.println(product.toString());
			id = (int) session.save(product);			
			session.getTransaction().commit();			
			return id;
		}
		
		catch(Exception e)
		{
			System.out.println("Product:  " + e.getMessage());
			return id;
		}
		
		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Product>   getAllProduct()
	{
		
		Session session = this.hibTemplate.getSessionFactory().openSession();
		Query<Product> query = session.createQuery("From Product");
		ArrayList<Product>  productList = (ArrayList<Product>) query.getResultList();		
		return productList;		
		
	}
	
	@SuppressWarnings("unchecked")
	public Product   getProductById(int id)
	{
		
		Session session = this.hibTemplate.getSessionFactory().openSession();
		Query<Product> query = session.createQuery("From Product where ProductId=:ProductId");
		query.setParameter("ProductId", id);
		Product  product = (Product)query.getSingleResult();		
		return product;		
		
	}
	
	@SuppressWarnings("unchecked")
	public Product   deleteProductById(int id)
	{
		
		Session session = this.hibTemplate.getSessionFactory().openSession();
		Query<Product> query = session.createQuery("From Product where ProductId=:ProductId");
		query.setParameter("ProductId", id);
		Product  product = (Product)query.getSingleResult();		
		return product;		
		
	}
	
	@SuppressWarnings("unchecked")
	public int   updateProduct(Product product)
	{
		
		int id=0;
		
		try {
			Session session = hibTemplate.getSessionFactory().openSession();			
			session.beginTransaction();			
			System.out.println(product.toString());
			session.update(product);			
			session.getTransaction().commit();
			id= product.getProductId();
			return id;
		}
		
		catch(Exception e)
		{
			System.out.println("Product:  " + e.getMessage());
			return id;
		}
		
		
	}
	
	
	

}
