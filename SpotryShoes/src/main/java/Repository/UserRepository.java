package Repository;



import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;

import model.User;


public class UserRepository {

	public UserRepository() {
		// TODO Auto-generated constructor stub
	}
	
	private HibernateTemplate hibTemplate;

	public HibernateTemplate getHibTemplate() {
		return hibTemplate;
	}
	
	public void setHibTemplate(HibernateTemplate hibTemplate) {
		this.hibTemplate = hibTemplate;
	}
	
	
	public int createUser(User user)
	{
		int id = 0;
		
		try {
			
			
						
			Session session = hibTemplate.getSessionFactory().openSession();			
			session.beginTransaction();			
			System.out.println(user.toString());
			id = (int) session.save(user);			
			session.getTransaction().commit();			
			return id;
		}
		
		catch(Exception e)
		{
			System.out.println("User creation failed:  " + e.getMessage());
			return id;
		}
		
		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<User>   getAllUser()
	{
		
		Session session = this.hibTemplate.getSessionFactory().openSession();
		Query<User> query = session.createQuery("From User");
		ArrayList<User>  userList = (ArrayList<User>) query.getResultList();		
		return userList;		
		
	}
	
	@SuppressWarnings("unchecked")
	public User  getAllUserByEmail(String email)
	{
		
		Session session = this.hibTemplate.getSessionFactory().openSession();
		Query<User> query = session.createQuery("From User where Email=:Email");		
		query.setParameter("Email", email);
		User  user = (User) query.getSingleResult();		
		return user;		
		
	}
	
	@SuppressWarnings("unchecked")
	public User  getAllUserById(int id)
	{
		
		Session session = this.hibTemplate.getSessionFactory().openSession();
		Query<User> query = session.createQuery("From User where UserId=:UserId");		
		query.setParameter("UserId", id);
		User  user = (User) query.getSingleResult();		
		return user;		
		
	}
	
	public int updateUser(User user)
	{
		int id = 0;
		
		try {
			
			
						
			Session session = hibTemplate.getSessionFactory().openSession();			
			session.beginTransaction();			
			System.out.println(user.toString());
			session.update(user);
			id = user.getUserId();
			session.getTransaction().commit();			
			return id;
		}
		
		catch(Exception e)
		{
			System.out.println("User update failed:  " + e.getMessage());
			return id;
		}
		
		
	}

	

}
