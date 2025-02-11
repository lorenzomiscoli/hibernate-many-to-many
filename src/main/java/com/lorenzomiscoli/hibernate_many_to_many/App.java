package com.lorenzomiscoli.hibernate_many_to_many;

import com.lorenzomiscoli.hibernate_many_to_many.entities.Role;
import com.lorenzomiscoli.hibernate_many_to_many.entities.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {

	public static void main(String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("default");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		User user = new User();
		user.setUsername("root");
		Role role = new Role();
		role.setName("ADMIN");
		em.persist(user);
		em.persist(role);
		user.addRole(role);
		em.getTransaction().commit();
		em.close();
		emFactory.close();
	}

}
