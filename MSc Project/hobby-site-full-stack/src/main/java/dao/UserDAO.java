package dao;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import config.HibernateSessionFactory;
import model.User;

@Repository
public class UserDAO {
	
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory = HibernateSessionFactory.getSingletonSessionFactory();

	// Default constructor
	public UserDAO() {}
	
	@SuppressWarnings("unchecked")
	public List<User> listUsers(){
	    Session session = sessionFactory.openSession();
		List<User> allUsers = new ArrayList<User>();
		session.beginTransaction();	
		Query<User> query = session.createQuery("FROM model.User");
		allUsers = query.list();
		getHobbies();
		session.getTransaction().commit();
		if (session.getTransaction() != null) {
			session.close();
		}
		return allUsers;
    }

	@SuppressWarnings("unchecked")
	public List<User> getUser(int userID){
		Session session = sessionFactory.openSession();
		List<User> searchedUsers = new ArrayList<User>();	
		session.beginTransaction();
		Query<User> queryObject = session.createQuery("from User where user_id like '%" + userID + "%'");
		searchedUsers = queryObject.list();
		session.getTransaction().commit();
		if (session.getTransaction() != null) {
			session.close();
		}
		return searchedUsers;
	}
	
	private Object getHobbies(){
		Session session = sessionFactory.openSession();
		//List<String> hobbies = new ArrayList<String>();	
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<String> hobbies = session.createNativeQuery(""
			+ "SELECT msc.hobby.hobby FROM user_detail\r\n" + 
			"	INNER JOIN msc.user_hobby ON msc.user_detail.id = msc.user_hobby.user_fk\r\n" + 
			"	INNER JOIN msc.hobby ON msc.hobby.id = msc.user_hobby.hobby_fk\r\n" + 
			"     WHERE msc.user_detail.id = 2").getResultList();
		System.out.println(hobbies.get(0));
		session.getTransaction().commit();
		if (session.getTransaction() != null) {
			session.close();
		}
		return hobbies;
	}

	public void addUser(User user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("Creating and saving User");
		session.persist(user);
		session.getTransaction().commit();
		System.out.println("Success! User was added to the database");
		if (session.getTransaction() != null) {
			session.close();
		}
	}

	public String deleteUser(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String noEntityFound = "";
		try {
			User user = (User) session.load(User.class, new Integer(id));
			if(user != null){
				session.delete(user);
				session.getTransaction().commit();
				return "User with id " + user.getUser_id() + " successfully deleted!";
			}
		} catch (EntityNotFoundException e) {
			noEntityFound = "No User with that id exists";
			session.close();
		}
		return noEntityFound;
	}	
}