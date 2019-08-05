package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

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
	public void getUser(String username) {
		Session session = sessionFactory.openSession();
		List<UserLogin> user = new ArrayList<UserLogin>();	
		session.beginTransaction();
		System.out.println(username);
		try {
			Query<UserLogin> queryObject = session.createQuery("from model.UserLogin where username like '%" + username + "%'");
			user = queryObject.list();
		} catch (NoResultException e) {
			System.out.println(e);
		}
		session.getTransaction().commit();
		if (session.getTransaction() != null) {
			session.close();
		}
		for (UserLogin u : user) {
			System.out.println(u.toString());
		}
		System.out.println(user.get(0));
		System.out.println("yo");
	}

	@Override
	public void addUserLogin(UserLogin userLogin) {
		// TODO Auto-generated method stub

	}

}
