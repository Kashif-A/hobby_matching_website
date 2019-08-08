package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import config.HibernateSessionFactory2;
import model.UserLogin;

@Repository
public class UserLoginDAO {
	
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory = HibernateSessionFactory2.getSingletonSessionFactory();

	// Default constructor
	public UserLoginDAO() {}
	
	@SuppressWarnings("unchecked")
	public List<UserLogin> listUsers(){
	    Session session = sessionFactory.openSession();
		List<UserLogin> allUsers = new ArrayList<UserLogin>();
		session.beginTransaction();	
		Query<UserLogin> query = session.createQuery("FROM model.UserLogin");
		allUsers = query.list();
		session.getTransaction().commit();
		if (session.getTransaction() != null) {
			session.close();
		}
		return allUsers;
    }

	@SuppressWarnings({ "unchecked", "deprecation" })
	public UserLogin getUser(String username){
		Session session = sessionFactory.openSession();
		UserLogin searchedFilm = new UserLogin();	
		session.beginTransaction();
		Query<UserLogin> queryObject = session.createQuery("from UserLogin U where username = :username ");
		queryObject.setString("username", username);
		try {
			searchedFilm = queryObject.getSingleResult();
			session.getTransaction().commit();
			if (session.getTransaction() != null) {
				session.close();
			}
			return searchedFilm;
		} catch(NoResultException ex) {
			return null;
		}
	}

	public void addUser(UserLogin user) {
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
			UserLogin user = (UserLogin) session.load(UserLogin.class, new Integer(id));
			if(user != null){
				session.delete(user);
				session.getTransaction().commit();
				return "Film with id " + user.getUser_id() + " successfully deleted!";
			}
		} catch (EntityNotFoundException e) {
			noEntityFound = "No film with that id exists";
			session.close();
		}
		return noEntityFound;
	}	
}