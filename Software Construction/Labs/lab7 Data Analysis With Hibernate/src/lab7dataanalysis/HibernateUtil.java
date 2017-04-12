
package lab7dataanalysis;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Dawoud Ali
 */
public class HibernateUtil {
    
    
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
    
public static void createSessionFactory() {
    Configuration configuration = new Configuration();
    configuration.configure();
    serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
    sessionFactory = configuration.buildSessionFactory(serviceRegistry);

}

public static SessionFactory getSessionFactory(){
	return sessionFactory;
}

}
