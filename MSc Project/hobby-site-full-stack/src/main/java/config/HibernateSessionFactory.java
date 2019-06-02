package config;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import model.User;

public class HibernateSessionFactory {
    private static  SessionFactory sessionFactory;
    
    // Private Constructor
    private HibernateSessionFactory() {}
    
    public static synchronized SessionFactory getSingletonSessionFactory() {
        if (sessionFactory == null) {
            try {
            	org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://URL:3306/filmsDB?autoReconnect=true&useSSL=false");
                settings.put(Environment.USER, "uname");
                settings.put(Environment.PASS, "pwd");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.C3P0_MIN_SIZE, "1");
                settings.put(Environment.C3P0_MAX_SIZE, "5");
                settings.put(Environment.C3P0_MAX_STATEMENTS, "50");
                settings.put(Environment.C3P0_ACQUIRE_INCREMENT, "1");
                // New property to fix DB issues with Jboss7
                settings.put(Environment.C3P0_IDLE_TEST_PERIOD, "40");
                settings.put(Environment.C3P0_TIMEOUT, "30");
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                		.applySettings(configuration.getProperties())
                		.build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    // Prevent cloning of SessionFactory to ensure object is Singleton
    public Object clone() throws CloneNotSupportedException{
    	throw new CloneNotSupportedException();
    }
}
