package dao;

import java.util.HashMap;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import config.HibernateSessionFactory;

@Repository
public class MessageDAO {
	
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory = HibernateSessionFactory.getSingletonSessionFactory();

	// Default constructor
	public MessageDAO() {}
	
	/*public getMessages() {
		
	}*/
	
	public void insertMessage(int userId, String message, String timestamp) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createNativeQuery("INSERT INTO msc.message "
				+ "(user_id, message, time_of_message) "
				+ "VALUES (:userId, :message , :timestamp)");
		query.setParameter("userId", userId);
		query.setParameter("message", message);
		query.setParameter("timestamp", timestamp);
		query.executeUpdate();
		session.getTransaction().commit();
		if (session.getTransaction() != null) {
			session.close();
		}
	}
}