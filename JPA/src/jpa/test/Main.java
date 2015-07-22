package jpa.test;

import java.util.ArrayList;
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
	    em.getTransaction().commit();
	       
        User user = new User("Vasa", 20, "vasa@i.ua");
        User user1 = new User("Peta", 32,"peta@i.ua");
        User user2 = new User("Pipa", 42,"pipa@i.ua");
        User user3 = new User("Mupa", 21,"mupa@i.ua");
        
        Program office = new Program("Office", 235.0);
        Program photoshop = new Program("PhotoShop", 340.0);
        Program paint = new Program("Paint", 34.0);
        
        List<User> officeList = new ArrayList<>();
        officeList.add(user1);
        officeList.add(user2);
        office.setUsers(officeList);
        List<User> photoShopList = new ArrayList<>();
        photoShopList.add(user);
        photoShopList.add(user2);
        photoshop.setUsers(photoShopList);
        List<User> paintList = new ArrayList<>();
        paintList.add(user);
        paintList.add(user1);
        paintList.add(user3);
        paint.setUsers(paintList);
        
        serv.saveUser(user);
        serv.saveUser(user1);
        serv.saveUser(user2);
        serv.saveUser(user3);
        serv.saveProgram(office);
        serv.saveProgram(photoshop);
        serv.saveProgram(paint);

        /*user.setRole(r);*/
       /* user1.setRole(r);
        user2.setRole(r);
        user3.setRole(r);
        em.persist(r);*/
        /*em.persist(user);*/
    /*    em.persist(user1);
        em.persist(user2);
        em.persist(user3);*/
       
      
      
        List<User> list;
        list= em.createNamedQuery("User.getAll", User.class).getResultList();
        System.out.println(list);
        System.out.println(serv.getUserByName("vasa").toString());
        System.out.println(serv.getUserByName("pipa").toString());
        em.close();
        emf.close();
	}
}
