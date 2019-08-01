package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import config.HibernateSessionFactory2;
import model.UserLogin;

@Repository
public class UserLoginImpl implements UserLoginDAO {
	
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory = HibernateSessionFactory2.getSingletonSessionFactory();
	
	public UserLoginImpl() {}

	@SuppressWarnings("unchecked")
	@Override
	public UserLogin getUser(String username) {
		Session session = sessionFactory.openSession();
		UserLogin user = new UserLogin();	
		session.beginTransaction();
		Query<UserLogin> queryObject = session.createQuery("from UserLogin");
		 //where username like '%" + username + "%'"
		user = queryObject.getSingleResult();
		session.getTransaction().commit();
		if (session.getTransaction() != null) {
			session.close();
		}
		return user;
	}

	@Override
	public void addUserLogin(UserLogin userLogin) {
		// TODO Auto-generated method stub

	}

}
