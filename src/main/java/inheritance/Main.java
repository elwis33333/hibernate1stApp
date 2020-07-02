package inheritance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory managerFactory =
                Persistence.createEntityManagerFactory("mysqlPU");
        EntityManager entityManager = managerFactory.createEntityManager();
        System.out.println("Is open: " + entityManager.isOpen());

        Student student = new Student();
        student.setIndexId("123456");
        student.setFirstName("Tom");
        student.setLastName("Smith");

        Teacher teacher = new Teacher();
        teacher.setFirstName("John");
        teacher.setLastName("Doe");
        teacher.setScienceTitle("MhD");

        entityManager.getTransaction().begin();
        entityManager.persist(teacher);
        entityManager.persist(student);
        entityManager.getTransaction().commit();

        entityManager.close();
        managerFactory.close();
    }
}