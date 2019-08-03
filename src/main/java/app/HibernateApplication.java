package app;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;

public class HibernateApplication {
    public static void main(String[] args) {
        Student student = Student.builder().age(10).firstName("Kasun").lastName("Perera").build();
        SessionFactory sessionFactory =
                new Configuration()
                        .configure()
                        .addAnnotatedClass(Student.class)
                        .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();
        Serializable save = session.save(student);
        session.getTransaction().commit();

        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        Student student1 = currentSession.get(Student.class, 1);
        currentSession.getTransaction().commit();
        System.out.println(student1);
        sessionFactory.close();
    }
}
