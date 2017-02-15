package com.algaworks.curso.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.curso.modelo.Cliente;

public class RemovendoPrimeiroObjeto {
	
	public static void main(String args[]){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager em = emf.createEntityManager();
		
		Cliente cliente = em.find(Cliente.class, 4L);
		
		try {
			em.getTransaction().begin();
			em.remove(cliente);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			e.getMessage();
		}
		
		em.close();
		
		System.out.println("Removido com sucesso!");
		
	}
}
