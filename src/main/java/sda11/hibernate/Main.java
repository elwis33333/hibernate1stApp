package sda11.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello in ORM");
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("mysqlPU");
        EntityManager entityManager = managerFactory.createEntityManager();
        System.out.println("Is open: "+entityManager.isOpen());
        ORMTypes t1 = new ORMTypes();
        t1.setAnInt(100);
        t1.setaDouble(99.99);
        t1.setaShort((short) 122);
        t1.setString("Piotr");
        t1.setaFloat((float) 18.14);
        t1.setPoryRoku(PoryRoku.LATO);
        ORMTypes t2 = new ORMTypes();
        t2.setArray(new int[]{1,2,3,4,5});
        t2.setDate(Date.from(Instant.now())); //wyswietli w bazie samą datę
        t2.setTime(Date.from(Instant.now())); //wyswietli w bazie samą godzinę
        t2.setTimestamp(Date.from(Instant.now())); //wyswietli w bazie datę oraz godzinę
        t2.setPassword("1234");
        entityManager.getTransaction().begin();
        entityManager.persist(t1);
        entityManager.persist(t2);
        entityManager.getTransaction().commit();
        entityManager.close();
        managerFactory.close();
    }
}