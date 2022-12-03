package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ProductCategory")
public class ProductCategory {

	public ProductCategory() {
		// TODO Auto-generated constructor stub
	}
	
	private int ProductCategoryid;
	private String Name;
	private String Description;
	/**
	 * @return the productCategoryid
	 */
	@Id
    @Column(name = "ProductCategoryId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getProductCategoryid() {
		return ProductCategoryid;
	}
	/**
	 * @param productCategoryid the productCategoryid to set
	 */
	public void setProductCategoryid(int productCategoryid) {
		ProductCategoryid = productCategoryid;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}
	@Override
	public String toString() {
		return "ProductCategory [ProductCategoryid=" + ProductCategoryid + ", Name=" + Name + ", Description="
				+ Description + "]";
	}
	
	

}
