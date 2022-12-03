package Repository;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;

import model.Role;

public class RoleRepository {

	public RoleRepository() {
		// TODO Auto-generated constructor stub
	}
	
	private HibernateTemplate hibTemplate;

	public HibernateTemplate getHibTemplate() {
		return hibTemplate;
	}
	
	public void setHibTemplate(HibernateTemplate hibTemplate) {
		this.hibTemplate = hibTemplate;
	}
	
	
	public int createRole(Role role)
	{
		int id = 0;
		
		try {
			
			
						
			Session session = hibTemplate.getSessionFactory().openSession();			
			session.beginTransaction();			
			System.out.println(role.toString());
			id = (int) session.save(role);			
			session.getTransaction().commit();			
			return id;
		}
		
		catch(Exception e)
		{
			System.out.println("Role creation failed:  " + e.getMessage());
			return id;
		}
		
		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Role>   getAllRole()
	{
		
		Session session = this.hibTemplate.getSessionFactory().openSession();
		Query<Role> query = session.createQuery("From Role");
		ArrayList<Role>  roleList = (ArrayList<Role>) query.getResultList();		
		return roleList;		
		
	}
	
}
