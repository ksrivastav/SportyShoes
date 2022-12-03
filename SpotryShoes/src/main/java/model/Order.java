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
@Table(name = "SalesOrder")
public class Order {

	public Order() {
		// TODO Auto-generated constructor stub
	}
	
	private int OrderId;
	private User user;
	private String Status;
	private double OrderAmount;
	private LocalDateTime CreateDateTime;
	private LocalDateTime UpdateDateTime;
	/**
	 * @return the orderId
	 */
	@Id
    @Column(name = "OrderId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getOrderId() {
		return OrderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	/**
	 * @return the user
	 */
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "UserId")
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return Status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		Status = status;
	}
	/**
	 * @return the orderAmount
	 */
	public double getOrderAmount() {
		return OrderAmount;
	}
	/**
	 * @param orderAmount the orderAmount to set
	 */
	public void setOrderAmount(double orderAmount) {
		OrderAmount = orderAmount;
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
	
	

}
