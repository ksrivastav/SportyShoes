package service;


import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import Repository.BrandRepository;
import model.Brand;



public class BrandService {

	public BrandService() {
		
	}
	

private ApplicationContext appContext;
	
	public ApplicationContext getAppContext() {
		return appContext;
	}
	
	public void setAppContext() {
		this.appContext = new ClassPathXmlApplicationContext("SportyShoesBeans.xml");
	}
	
	public int createBrand(Brand brand)
	{
		int id=0;
		
		try
		{
			setAppContext();
			BrandRepository productcategoryRepo = (BrandRepository) this.appContext.getBean("BrandRepository");
			id = (int)productcategoryRepo.createBrand(brand);			
			return id;
		}
		catch(Exception e)
		{
			System.out.println("Brand failed : "+ e.getMessage());
			return id;
		}
	}
	
	
	public ArrayList<Brand>   getAllBrand()
	{
		
		setAppContext();
		BrandRepository brandRepo = (BrandRepository) this.appContext.getBean("BrandRepository");
		ArrayList<Brand>  brandList =  brandRepo.getAllBrand();
		return brandList;		
		
	}
	
	

	
}
