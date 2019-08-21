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

@Repository
public class HobbyDAO {
	
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory = HibernateSessionFactory.getSingletonSessionFactory();

	// Default constructor
	public HobbyDAO() {}
	
	public List<Object[]> getHobbyList() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Object[]> hobby = session.createNativeQuery("SELECT * FROM msc.hobby")
									.getResultList();
		session.getTransaction().commit();
		if (session.getTransaction() != null) {
			session.close();
		}
		return hobby;
	}
}