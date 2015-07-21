package jpa.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
      
		   
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
		EntityManager em = emf.createEntityManager();
		Service serv = new Service(em);
		Role r = new Role("user");
		   em.getTransaction().begin();
	        em.persist(r);
        User user = new User("Vasa", 20);;
        User user1 = new User("Peta", 32);
        User user2 = new User("Pipa", 42);
        User user3 = new User("Mupa", 21);
        user.setRole(r);
       /* user1.setRole(r);
        user2.setRole(r);
        user3.setRole(r);
        em.persist(r);*/
        em.persist(user);
    /*    em.persist(user1);
        em.persist(user2);
        em.persist(user3);*/
       
        em.getTransaction().commit();
 /*       serv.save(user);
        serv.save(user1);
        serv.save(user2);
        serv.save(user3);*/
        List<User> list;
        list= em.createNamedQuery("User.getAll", User.class).getResultList();
        System.out.println(list);
        System.out.println(serv.getbyName("vasa").toString());
        System.out.println(serv.getbyName("pupa").toString());
        em.close();
        emf.close();
	}
}
