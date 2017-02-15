package com.algaworks.curso.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.curso.modelo.Cliente;

public class AtualizandoPrimeiroObjeto {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager em = emf.createEntityManager();
		
		Cliente cliente = em.find(Cliente.class, 5L);
		
		try {
			em.getTransaction().begin();
			cliente.setNome("Juquinha");
			cliente.setIdade(30);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			e.getMessage();
		}
		System.out.println("Atualizado com sucesso!");

		em.close();
		
	}

}
