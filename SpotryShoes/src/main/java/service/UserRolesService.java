package service;


import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Repository.UserRolesRepository;
import model.UserRoles;



public class UserRolesService{

	public UserRolesService() {
		// TODO Auto-generated constructor stub
	}
	


private ApplicationContext appContext;
	
	public ApplicationContext getAppContext() {
		return appContext;
	}
	
	public void setAppContext() {
		this.appContext = new ClassPathXmlApplicationContext("SportyShoesBeans.xml");
	}
	
	public int createUserRoles(UserRoles userRole)
	{
		int id=0;
		
		try
		{
			setAppContext();
			UserRolesRepository rolerepo = (UserRolesRepository) this.appContext.getBean("UserRolesRepository");
			id = (int)rolerepo.createUserRoles(userRole);			
			return id;
		}
		catch(Exception e)
		{
			System.out.println("UserRoles failed : "+ e.getMessage());
			return id;
		}
	}
	
	public ArrayList<UserRoles>   getAllUserRoles()
	{
		
		setAppContext();
		UserRolesRepository userRolesRepo = (UserRolesRepository) this.appContext.getBean("UserRolesRepository");
		ArrayList<UserRoles>  userRolesList =  userRolesRepo.getAllUserRoles();
		return userRolesList;		
		
	}
	
	public UserRoles   getAllUserRolesByUserId(int UserId)
	{
		setAppContext();
		UserRolesRepository userRolesRepo = (UserRolesRepository) this.appContext.getBean("UserRolesRepository");
		UserRoles  userRoles =  userRolesRepo.getAllUserRolesByUserId(UserId);
		return userRoles;	
		
	}
	
	
}
