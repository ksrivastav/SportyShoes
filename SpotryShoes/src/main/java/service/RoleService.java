package service;


import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Repository.RoleRepository;
import model.Role;


public class RoleService {

	public RoleService() {
		// TODO Auto-generated constructor stub
	}
	

private ApplicationContext appContext;
	
	public ApplicationContext getAppContext() {
		return appContext;
	}
	
	public void setAppContext() {
		this.appContext = new ClassPathXmlApplicationContext("SportyShoesBeans.xml");
	}
	
	public int createRole(Role role)
	{
		int id=0;
		
		try
		{
			setAppContext();
			RoleRepository rolerepo = (RoleRepository) this.appContext.getBean("RoleRepository");
			id = (int)rolerepo.createRole(role);			
			return id;
		}
		catch(Exception e)
		{
			System.out.println("Role failed : "+ e.getMessage());
			return id;
		}
	}
	
	
	public ArrayList<Role>   getAllRole()
	{
		
		setAppContext();
		RoleRepository roleRepo = (RoleRepository) this.appContext.getBean("RoleRepository");
		ArrayList<Role>  roleList =  roleRepo.getAllRole();
		return roleList;		
		
	}
	
	

	
}
