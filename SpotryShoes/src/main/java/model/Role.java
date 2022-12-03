package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Role")
public class Role {

	public Role() {
		// TODO Auto-generated constructor stub
	}
	
	private int RoleId;
	private String Name;
	/**
	 * @return the roleId
	 */
	@Id
    @Column(name = "RoleId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getRoleId() {
		return RoleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(int roleId) {
		RoleId = roleId;
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
	
	

}
