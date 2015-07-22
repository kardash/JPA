package jpa.test;

import javax.persistence.EntityManager;

public class Service {

	EntityManager em;

	public Service(EntityManager em) {
		super();
		this.em = em;
	}

	public Service() {

	}

	/* SERVICES FOR ROLE!!! */

	public void saveRole(Role name) {
		if (getRoleByName(name.getName()) == null) {
			Role r = new Role("user");
			em.getTransaction().begin();
			em.persist(r);
			em.getTransaction().commit();
		} else {

			System.out.println("Role with this name already exist!!!");
		}

	}

	public void setUserToRole() {
		
	}
	
	public Role getRoleByName(String name) {
		return em.createNamedQuery("Role.getName", Role.class).setParameter("name", name).getSingleResult();

	}

	/* SERVICES FOR USER!!! */

	public void saveUser(User user) {
		if (getRoleByName("user") == null) {

			Role r = new Role("user");
			em.getTransaction().begin();
			em.persist(r);
			user.setRole(r);
			em.persist(user);
			em.getTransaction().commit();
		} else {
			em.getTransaction().begin();
			user.setRole(getRoleByName("user"));
			em.persist(user);
			em.getTransaction().commit();

		}

	}

	public User getUserByName(String name) {
		return em.createNamedQuery("User.getbyName", User.class).setParameter("name", name).getSingleResult();

	}

	/* SERVICES FOR PRICE!!! */

	public void saveProgram(Program program) {

		if (getRoleByName(program.getName()) == null) {

			em.getTransaction().begin();
			em.persist(program);
			em.getTransaction().commit();

		} else {
			System.out.println("Program with this name already exist!!!");
		}
	}
	
	public Program getProgramByName(String name) {
		return em.createNamedQuery("Program.getName", Program.class).setParameter("name", name).getSingleResult();
		
	}
}
