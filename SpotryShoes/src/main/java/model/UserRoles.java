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
@Table(name = "UserRoles")
public class UserRoles {

	public UserRoles() {
		// TODO Auto-generated constructor stub
	}
	
	private int UserRolesId;
	private Role role;
	private User user;
	
	
	
	/**
	 * @return the userRolesId
	 */
	@Id
    @Column(name = "UserRolesId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getUserRolesId() {
		return UserRolesId;
	}
	/**
	 * @param userRolesId the userRolesId to set
	 */
	public void setUserRolesId(int userRolesId) {
		UserRolesId = userRolesId;
	}
	/**
	 * @return the role
	 */
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RoleId")
	public Role getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
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
	
	

}
