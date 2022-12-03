package Repository;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;

import model.UserRoles;


public class UserRolesRepository {

	public UserRolesRepository() {
		// TODO Auto-generated constructor stub
	}
	

	private HibernateTemplate hibTemplate;

	public HibernateTemplate getHibTemplate() {
		return hibTemplate;
	}
	
	public void setHibTemplate(HibernateTemplate hibTemplate) {
		this.hibTemplate = hibTemplate;
	}
	
	
	public int createUserRoles(UserRoles userRoles)
	{
		int id = 0;
		
		try {
			
			
						
			Session session = hibTemplate.getSessionFactory().openSession();			
			session.beginTransaction();			
			System.out.println(userRoles.toString());
			id = (int) session.save(userRoles);			
			session.getTransaction().commit();			
			return id;
		}
		
		catch(Exception e)
		{
			System.out.println("UserRoles creation failed:  " + e.getMessage());
			return id;
		}
		
		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<UserRoles>   getAllUserRoles()
	{
		
		Session session = this.hibTemplate.getSessionFactory().openSession();
		Query<UserRoles> query = session.createQuery("From UserRoles");
		ArrayList<UserRoles>  userRolesList = (ArrayList<UserRoles>) query.getResultList();		
		return userRolesList;		
		
	}
	
	@SuppressWarnings("unchecked")
	public UserRoles   getAllUserRolesByUserId(int UserId)
	{
		
		Session session = this.hibTemplate.getSessionFactory().openSession();
		Query<UserRoles> query = session.createQuery("From UserRoles where userId=: UserId");
		query.setParameter("UserId", UserId);
		UserRoles  userRoles = (UserRoles) query.getSingleResult();		
		return userRoles;		
		
	}
	
}
