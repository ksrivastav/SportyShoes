package Repository;



import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;

import model.Product;
import model.ProductCategory;


public class ProductCategoryRepository {

	private HibernateTemplate hibTemplate;

	public HibernateTemplate getHibTemplate() {
		return hibTemplate;
	}
	
	public void setHibTemplate(HibernateTemplate hibTemplate) {
		this.hibTemplate = hibTemplate;
	}
	
	
	


	public ProductCategoryRepository() {
		// TODO Auto-generated constructor stub
	}
	
	public int createProductCategory(ProductCategory productCategory)
	{
		int id = 0;
		
		try {
			
			
						
			Session session = hibTemplate.getSessionFactory().openSession();			
			session.beginTransaction();			
			System.out.println(productCategory.toString());
			id = (int) session.save(productCategory);			
			session.getTransaction().commit();			
			return id;
		}
		
		catch(Exception e)
		{
			System.out.println("ProductCategory:  " + e.getMessage());
			return id;
		}
		
		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<ProductCategory>   getAllProductCategory()
	{
		
		Session session = this.hibTemplate.getSessionFactory().openSession();
		Query<ProductCategory> query = session.createQuery("From ProductCategory");
		ArrayList<ProductCategory>  productList = (ArrayList<ProductCategory>) query.getResultList();		
		return productList;		
		
	}
	
	@SuppressWarnings("unchecked")
	public ProductCategory   getProductCategoryById(int id)
	{
		
		Session session = this.hibTemplate.getSessionFactory().openSession();
		Query<ProductCategory> query = session.createQuery("From ProductCategory where ProductCategoryId=: ProductCategoryId");
		query.setParameter("ProductCategoryId", id);
		ProductCategory  productCat = (ProductCategory)query.getSingleResult();		
		return productCat;		
		
	}
	
	
	

}
