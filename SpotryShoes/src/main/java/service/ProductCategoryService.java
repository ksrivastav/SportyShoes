package service;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Repository.ProductCategoryRepository;
import model.ProductCategory;


public class ProductCategoryService {

	public ProductCategoryService() {
		// TODO Auto-generated constructor stub
	}
	
	private ApplicationContext appContext;
	
	public ApplicationContext getAppContext() {
		return appContext;
	}
	
	public void setAppContext() {
		this.appContext = new ClassPathXmlApplicationContext("SportyShoesBeans.xml");
	}
	
	public int createProductCategory(ProductCategory productCategory)
	{
		int id=0;
		
		try
		{
			setAppContext();
			ProductCategoryRepository productcategoryRepo = (ProductCategoryRepository) this.appContext.getBean("ProductCategoryRepository");
			id = (int)productcategoryRepo.createProductCategory(productCategory);			
			return id;
		}
		catch(Exception e)
		{
			System.out.println("ProductCategory failed : "+ e.getMessage());
			return id;
		}
	}
	
	public ArrayList<ProductCategory>   getAllProductCategory()
	{
		
		setAppContext();
		ProductCategoryRepository productCategoryRepo = (ProductCategoryRepository) this.appContext.getBean("ProductCategoryRepository");
		ArrayList<ProductCategory>  productCategoryList =  productCategoryRepo.getAllProductCategory();
		return productCategoryList;		
		
	}
	
	public ProductCategory   getProductCategoryById(int id)
	{
		setAppContext();
		ProductCategoryRepository productCategoryRepo = (ProductCategoryRepository) this.appContext.getBean("ProductCategoryRepository");
		ProductCategory  productCategory =  productCategoryRepo.getProductCategoryById(id);
		return productCategory;	
	}

}
