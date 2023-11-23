package Logica;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class sessionManagerCreator {
    static SessionFactory sessionFactory;
    static{
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new Configuration().configure(ClassLoader.getSystemResource("hibernate.cfg.xml"))
                    .buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
