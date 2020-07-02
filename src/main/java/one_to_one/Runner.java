package one_to_one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class Runner {

    public static void main(String[] args) {
        EntityManagerFactory managerFactory =
                Persistence.createEntityManagerFactory("mysqlPU");
        EntityManager entityManager = managerFactory.createEntityManager();
        System.out.println("Is open: " + entityManager.isOpen());

        Post post1 = new Post();
        post1.setTitle("Java is fun");
        post1.setContent("TLTR;");
        PostDetails details1 = new PostDetails();
        details1.setRedactor("Smith");
        details1.setCreationTimestamp(new Date());
        details1.setModificationTimestamp(new Date());
Comment comment1 = new Comment();
Comment comment2 = new Comment();
comment1.setNickName("FB");
comment2.setNickName("FB2");
comment1.setComment("aaaaaaassasdaaa");
comment2.setComment("coment 2");
//dodanie rekordu do nowej tablicy
        entityManager.getTransaction().begin();
        entityManager.persist(post1);
        entityManager.persist(details1);
        post1.setDetails(details1);
        post1.addComment(comment1);
        post1.addComment(comment2);
        entityManager.getTransaction().commit();
//wyświetlenie z tablicy
        entityManager.getTransaction().begin();
        Post post = entityManager.createQuery("FROM Post p WHERE p.id=1", Post.class).getSingleResult();
        System.out.println(post);
        System.out.println(post.getDetails());
        post.getComments().forEach(System.out::println);
        entityManager.getTransaction().commit();

        entityManager.close();
        managerFactory.close();
    }
}