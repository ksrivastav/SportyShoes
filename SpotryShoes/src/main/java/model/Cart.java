package model;

import java.util.ArrayList;
import java.util.Hashtable;

public class Cart {
	private User curUser;
	private ArrayList<Product> productList= new ArrayList<Product>();
	private Hashtable<Integer, Integer> productMap = new  Hashtable<Integer, Integer>();
	double TotalPrice=0;

	public Cart() {
		// TODO Auto-generated constructor stub
		
	}
	

	/**
	 * @return the curUser
	 */
	public User getCurUser() {
		return curUser;
	}
	/**
	 * @param curUser the curUser to set
	 */
	public void setCurUser(User curUser) {
		this.curUser = curUser;
	}
	/**
	 * @return the productList
	 */
	public ArrayList<Product> getProductList() {
		return productList;
	}
	public void addCartItem(Product product) {
		if(this.productMap.containsKey(product.getProductId()))
		{
			int prodid= product.getProductId();
			int val = productMap.get(prodid);
			this.productMap.put(product.getProductId(),val + 1);
			this.TotalPrice= this.TotalPrice+product.getPrice();
		}
				
		else
		{
			this.productList.add(product);
			this.productMap.put(product.getProductId(), 1);
			this.TotalPrice= this.TotalPrice+product.getPrice();
			
		}
	}
	
	/**
	 * @param productList the productList to set
	 */
	
	public int getCartItemCount()
	{
		return this.productList.size();
	}


	/**
	 * @return the productMap
	 */
	public Hashtable<Integer, Integer> getProductMap() {
		return productMap;
	}


	/**
	 * @return the totalPrice
	 */
	public double getTotalPrice() {
		return TotalPrice;
	}
	
	
	
	
	

}
