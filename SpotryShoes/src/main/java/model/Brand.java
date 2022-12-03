package model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Brand")
public class Brand {

	public Brand() {
		
	}
	
	
	private int BrandId;
	private String Name;
	private LocalDateTime CreateDateTime;
	private LocalDateTime UpdateDateTime;
	private boolean isActiveFlag;
	/**
	 * @return the brandId
	 */
	@Id
    @Column(name = "BrandId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getBrandId() {
		return BrandId;
	}
	/**
	 * @param brandId the brandId to set
	 */
	public void setBrandId(int brandId) {
		BrandId = brandId;
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
	 * @return the isActiveFlag
	 */
	public boolean isActiveFlag() {
		return isActiveFlag;
	}
	/**
	 * @param isActiveFlag the isActiveFlag to set
	 */
	public void setActiveFlag(boolean isActiveFlag) {
		this.isActiveFlag = isActiveFlag;
	}
	@Override
	public String toString() {
		return "Brand [BrandId=" + BrandId + ", Name=" + Name + ", CreateDateTime=" + CreateDateTime
				+ ", UpdateDateTime=" + UpdateDateTime + ", isActiveFlag=" + isActiveFlag + "]";
	}
	
	
	

}
