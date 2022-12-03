package model;

import java.time.LocalDateTime;

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
@Table(name = "OrderDetails")
public class OrderDetails {

	public OrderDetails() {
		// TODO Auto-generated constructor stub
	}
	
	private int OrderDetailId;
	private Order  Order;
	private Product Product;
	private double ProductPricePaid;
	private LocalDateTime CreateDateTime;
	private LocalDateTime UpdateDateTime;
	private int Quantity;
	/**
	 * @return the orderDetailId
	 */
	@Id
    @Column(name = "OrderDetailId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getOrderDetailId() {
		return OrderDetailId;
	}
	/**
	 * @param orderDetailId the orderDetailId to set
	 */
	public void setOrderDetailId(int orderDetailId) {
		OrderDetailId = orderDetailId;
	}
	/**
	 * @return the order
	 */
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "OrderId")
	public Order getOrder() {
		return Order;
	}
	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		Order = order;
	}
	
	/**
	 * @return the productPricePaid
	 */
	public double getProductPricePaid() {
		return ProductPricePaid;
	}
	/**
	 * @param productPricePaid the productPricePaid to set
	 */
	public void setProductPricePaid(double productPricePaid) {
		ProductPricePaid = productPricePaid;
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
	 * @return the product
	 */
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ProductId")
	public Product getProduct() {
		return Product;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		Product = product;
	}
	
	
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return Quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	@Override
	public String toString() {
		return "OrderDetails [OrderDetailId=" + OrderDetailId + ", Order=" + Order + ", Product=" + Product
				+ ", ProductPricePaid=" + ProductPricePaid + ", CreateDateTime=" + CreateDateTime + ", UpdateDateTime="
				+ UpdateDateTime + "]";
	}
	
	

	
	

}
