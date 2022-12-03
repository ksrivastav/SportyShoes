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

@Entity
@Table(name = "ProductImage")
public class ProductImage {

	public ProductImage() {
	
	}
		
		private int ProductImageId;
		private Product product;
		private String ImageUrl;
		/**
		 * @return the productImageId
		 */
		@Id
	    @Column(name = "ProductImageId")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		public int getProductImageId() {
			return ProductImageId;
		}
		/**
		 * @param productImageId the productImageId to set
		 */
		public void setProductImageId(int productImageId) {
			ProductImageId = productImageId;
		}
		/**
		 * @return the product
		 */
		@OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "ProductId")
		public Product getProduct() {
			return product;
		}
		/**
		 * @param product the product to set
		 */
		public void setProduct(Product product) {
			this.product = product;
		}
		/**
		 * @return the imageUrl
		 */
		public String getImageUrl() {
			return ImageUrl;
		}
		/**
		 * @param imageUrl the imageUrl to set
		 */
		public void setImageUrl(String imageUrl) {
			ImageUrl = imageUrl;
		}
		@Override
		public String toString() {
			return "ProductImage [ProductImageId=" + ProductImageId + ", product=" + product + ", ImageUrl=" + ImageUrl
					+ "]";
		}
		
		
}
