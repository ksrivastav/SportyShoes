package service;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Repository.ProductRepository;
import model.Product;


public class ProductService {

	public ProductService() {
		// TODO Auto-generated constructor stub
	}
	
	private ApplicationContext appContext;
	
	public ApplicationContext getAppContext() {
		return appContext;
	}
	
	public void setAppContext() {
		this.appContext = new ClassPathXmlApplicationContext("SportyShoesBeans.xml");
	}
	
	public int createProduct(Product product)
	{
		int id=0;
		
		try
		{
			setAppContext();
			ProductRepository productcategoryRepo = (ProductRepository) this.appContext.getBean("ProductRepository");
			id = (int)productcategoryRepo.createProduct(product);			
			return id;
		}
		catch(Exception e)
		{
			System.out.println("Product failed : "+ e.getMessage());
			return id;
		}
	}
	

	public ArrayList<Product>   getAllProduct()
	{
		
		setAppContext();
		ProductRepository productRepo = (ProductRepository) this.appContext.getBean("ProductRepository");
		ArrayList<Product>  productList =  productRepo.getAllProduct();
		return productList;		
		
	}
	
	
	public Product   getProductById(int id)
	{
		
		setAppContext();
		ProductRepository productRepo = (ProductRepository) this.appContext.getBean("ProductRepository");
		Product  product =  productRepo.getProductById(id);
		return product;		
		
	}
	
	public int   updateProduct(Product product)
	{
		int id=0;
		
		try
		{
			setAppContext();
			ProductRepository productcategoryRepo = (ProductRepository) this.appContext.getBean("ProductRepository");
			id = (int)productcategoryRepo.updateProduct(product);			
			return id;
		}
		catch(Exception e)
		{
			System.out.println("Product failed : "+ e.getMessage());
			return id;
		}
	
	
	}
	

}
