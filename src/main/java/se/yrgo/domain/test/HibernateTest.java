package se.yrgo.domain.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import se.yrgo.domain.Student;
import se.yrgo.domain.Tutor;

import java.util.List;
import java.util.Set;

public class HibernateTest {
    private static SessionFactory sessionFactory = null;

    public static void main(String[] args) {
        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();

        Tutor newTutor = new Tutor("Stare-4237", "Nahid Vafaie", 70770);
        Student student1 = new Student("Anton Bringner");
        Student student2 = new Student("Amanda Vasilis");
        Student student3 = new Student("Adam Johansson");

        newTutor.addStudentToTeachingGroup(student1);
        newTutor.addStudentToTeachingGroup(student2);
        newTutor.addStudentToTeachingGroup(student3);

        Tutor theTutor = session.get(Tutor.class, 21);
        List<Student> students = theTutor.getTeachingGroup();
        for (Student student : students) {
            System.out.println("The student: " + student + " || " + "The tutor: " + theTutor.getName());
        }

        Transaction tx = session.beginTransaction();

//        session.save(student1);
//        session.save(student2);
//        session.save(student3);
//        session.save(newTutor);


        tx.commit();
        session.close();
    }

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new org.hibernate.cfg.Configuration();
            configuration.configure();

            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
}
