package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "Product")
public class Product {

	public Product() {
	
	}
		
		private int ProductId;
		private String Name;
		
		private ProductCategory ProductCategory;
		private Brand brand;
		private String Tag;
		private String Color;
		private double Price;
		private LocalDateTime CreateDateTime;
		private LocalDateTime UpdateDateTime;
		private String Image;
		/**
		 * @return the productId
		 */
		@Id
	    @Column(name = "ProductId")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		public int getProductId() {
			return ProductId;
		}
		/**
		 * @param productId the productId to set
		 */
		public void setProductId(int productId) {
			ProductId = productId;
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
		 * @return the airportName
		 */
		
		/**
		 * @return the productCategory
		 */
		@OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "ProductCategoryId")
		public ProductCategory getProductCategory() {
			return ProductCategory;
		}
		/**
		 * @param productCategory the productCategory to set
		 */
		public void setProductCategory(ProductCategory productCategory) {
			ProductCategory = productCategory;
		}
		/**
		 * @return the brand
		 */
		
		@OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "BrandId")
		public Brand getBrand() {
			return brand;
		}
		/**
		 * @param brand the brand to set
		 */
		public void setBrand(Brand brand) {
			this.brand = brand;
		}
		/**
		 * @return the tag
		 */
		public String getTag() {
			return Tag;
		}
		/**
		 * @param tag the tag to set
		 */
		public void setTag(String tag) {
			Tag = tag;
		}
		/**
		 * @return the color
		 */
		public String getColor() {
			return Color;
		}
		/**
		 * @param color the color to set
		 */
		public void setColor(String color) {
			Color = color;
		}
		/**
		 * @return the price
		 */
		public double getPrice() {
			return Price;
		}
		/**
		 * @param price the price to set
		 */
		public void setPrice(double price) {
			Price = price;
		}
		/**
		 * @return the createDateTime
		 */
		public LocalDateTime getCreateDateTime() {
			return CreateDateTime;
		}
		/**
		 * @param createDateTime the createDateTime to set
		 */
		public void setCreateDateTime(LocalDateTime createDateTime) {
			CreateDateTime = createDateTime;
		}
		/**
		 * @return the updateDateTime
		 */
		public LocalDateTime getUpdateDateTime() {
			return UpdateDateTime;
		}
		/**
		 * @param updateDateTime the updateDateTime to set
		 */
		public void setUpdateDateTime(LocalDateTime updateDateTime) {
			UpdateDateTime = updateDateTime;
		}
		/**
		 * @return the image
		 */
		public String getImage() {
			return Image;
		}
		/**
		 * @param image the image to set
		 */
		public void setImage(String image) {
			Image = image;
		}
		
		
			

}
