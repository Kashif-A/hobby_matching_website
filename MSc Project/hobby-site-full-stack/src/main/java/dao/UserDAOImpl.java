package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import config.HibernateSessionFactory2;
import model.User;

/**
 * FilmDAO Interface Implementation. This class is used to carry out database
 * interactions using Hibernate.
 * 
 * @author Kashif Ahmed - 18061036
 * @version 1.0
 * @since   March 2019
 */
@Repository
public class UserDAOImpl implements UserDAO {
	
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory = HibernateSessionFactory2.getSingletonSessionFactory();

	// Default constructor
	public UserDAOImpl() {}
	
	@SuppressWarnings("unchecked")
	public List<User> listUsers(){
	    Session session = sessionFactory.openSession();
		List<User> allUsers = new ArrayList<User>();
		session.beginTransaction();	
		Query<User> query = session.createQuery("FROM model.User");
		allUsers = query.list();
		session.getTransaction().commit();
		if (session.getTransaction() != null) {
			session.close();
		}
		return allUsers;
    }

	@SuppressWarnings("unchecked")
	public List<User> getUser(int userID){
		Session session = sessionFactory.openSession();
		List<User> searchedFilm = new ArrayList<User>();	
		session.beginTransaction();
		Query<User> queryObject = session.createQuery("from User where user_id like '%" + userID + "%'");
		searchedFilm = queryObject.list();
		session.getTransaction().commit();
		if (session.getTransaction() != null) {
			session.close();
		}
		return searchedFilm;
	}

	@Override
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

	@Override
	public void updateUser(User user, int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("Updating Film");
		User userToUpdate = (User) session.load(User.class, new Integer(id));
		userToUpdate.setFirst_name(user.getFirst_name());
		userToUpdate.setLast_name(user.getLast_name());
		userToUpdate.setGender(user.getGender());
		userToUpdate.setStatus(user.getStatus());
		session.saveOrUpdate(userToUpdate);
		session.getTransaction().commit();
		System.out.println("Success! Film updated");
		if (session.getTransaction() != null) {
			session.close();
		}
	}

	@Override
	public String deleteUser(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String noEntityFound = "";
		try {
			User user = (User) session.load(User.class, new Integer(id));
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