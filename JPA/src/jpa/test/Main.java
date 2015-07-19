package jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {

		   
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
		EntityManager em = emf.createEntityManager();
        User user = new User("Vasa", 20);
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

	}
}
