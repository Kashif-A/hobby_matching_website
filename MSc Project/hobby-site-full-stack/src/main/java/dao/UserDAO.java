package dao;

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
	    Session session = sessionFactory.openSession(); // Get hibernate database session
		List<User> allUsers = new ArrayList<User>(); // Object to hold user data
		session.beginTransaction();	
		Query<User> query = session.createQuery("FROM model.User"); // Hibernate query to get all users from database
		allUsers = query.list(); // Convert result of query into list
		for(User user : allUsers) {
			user.setHobbies(getHobbies(user.getUser_id())); // As hobbies are held in a different table, they are populated separately
		}
		session.getTransaction().commit();
		if (session.getTransaction() != null) {
			session.close(); // Close transaction
		}
		return allUsers;
    }

	@SuppressWarnings("unchecked")
	public User getUser(int userID){
		Session session = sessionFactory.openSession();
		User searchedUser = new User();	
		session.beginTransaction();
		Query<User> queryObject = session.createQuery("from User where user_id =" + userID);
		searchedUser = queryObject.getSingleResult();
		session.getTransaction().commit();
		if (session.getTransaction() != null) {
			session.close();
		}
		return searchedUser;
	}
	
	public List<String> getHobbies(int userId){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<String> hobbies = session.createNativeQuery(""
			+ "SELECT hobby FROM msc.user_hobby "
			+ "INNER JOIN msc.user_detail ON msc.user_hobby.user_fk = " + userId
			+ " INNER JOIN msc.hobby ON msc.user_hobby.hobby_fk = msc.hobby.id;").getResultList();
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