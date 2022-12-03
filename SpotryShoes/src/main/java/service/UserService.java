package service;




import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Repository.UserRepository;
import model.User;


public class UserService {

	public UserService() {
		// TODO Auto-generated constructor stub
	}
private ApplicationContext appContext;
	
	public ApplicationContext getAppContext() {
		return appContext;
	}
	
	public void setAppContext() {
		this.appContext = new ClassPathXmlApplicationContext("SportyShoesBeans.xml");
	}
	
	public int createUser(User user)
	{
		int id=0;
		
		try
		{
			setAppContext();
			UserRepository productcategoryRepo = (UserRepository) this.appContext.getBean("UserRepository");
			id = (int)productcategoryRepo.createUser(user);			
			return id;
		}
		catch(Exception e)
		{
			System.out.println("UserService failed : "+ e.getMessage());
			return id;
		}
	}
	

	public ArrayList<User>   getAllUser()
	{
		
		setAppContext();
		UserRepository userRepo = (UserRepository) this.appContext.getBean("UserRepository");
		ArrayList<User>  userList =  userRepo.getAllUser();
		return userList;		
		
	}
	
	public User  getAllUserByEmail(String email)
	{
		setAppContext();
		UserRepository userRepo = (UserRepository) this.appContext.getBean("UserRepository");
		User  user =  userRepo.getAllUserByEmail(email);
		return user;	
		
	}
	
	public User  getAllUserById(int id)
	{
		setAppContext();
		UserRepository userRepo = (UserRepository) this.appContext.getBean("UserRepository");
		User  user =  userRepo.getAllUserById(id);
		return user;
	}
	
	public int updateUser(User user)
	{
		int id=0;
		setAppContext();
		UserRepository userRepo = (UserRepository) this.appContext.getBean("UserRepository");
		id=userRepo.updateUser(user);
		return id;
	}


}
