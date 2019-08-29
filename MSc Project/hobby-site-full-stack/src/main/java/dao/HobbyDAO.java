package dao;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
	
	public void populateHobbiesLinkedToUser(String[] hobbies, int user_id) {
		HashMap<String,Integer> hobbiesMap = new HashMap<String, Integer>();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Object[]> hobbiesFromDatabase = getHobbyList();
		for(Object[] h : hobbiesFromDatabase) {
			String key = h[1].toString();
			int value = Integer.parseInt(h[0].toString());
			hobbiesMap.put(key, value);
		}
		for(String h : hobbies) {
			int hobbyId = hobbiesMap.get(h);
			String SQLquery = "INSERT INTO msc.user_hobby (hobby_fk, user_fk) VALUES (1,?)";
			session.createNativeQuery(SQLquery)
				   .setParameter(hobbyId, user_id)
				   .executeUpdate();
		}
		if (session.getTransaction() != null) {
			session.close();
		}
	}
}