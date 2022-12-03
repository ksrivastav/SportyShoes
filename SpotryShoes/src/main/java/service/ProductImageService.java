package service;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import Repository.ProductImageRepository;

import model.ProductImage;


public class ProductImageService {

	public ProductImageService() {
		// TODO Auto-generated constructor stub
	}
	
	private ApplicationContext appContext;
	
	public ApplicationContext getAppContext() {
		return appContext;
	}
	
	public void setAppContext() {
		this.appContext = new ClassPathXmlApplicationContext("SportyShoesBeans.xml");
	}
	
	public int createProductImage(ProductImage productImage)
	{
		int id=0;
		
		try
		{
			setAppContext();
			ProductImageRepository productImageRepo = (ProductImageRepository) this.appContext.getBean("ProductImageRepository");
			id = (int)productImageRepo.createProductImage(productImage);			
			return id;
		}
		catch(Exception e)
		{
			System.out.println("Product Image failed : "+ e.getMessage());
			return id;
		}
	}
	
	
	public ArrayList<ProductImage>   getAllProductImage()
	{
		
		setAppContext();
		ProductImageRepository productImageRepo = (ProductImageRepository) this.appContext.getBean("ProductImageRepository");
		ArrayList<ProductImage>  productImageList =  productImageRepo.getAllProductImage();
		return productImageList;		
		
	}
	

}
