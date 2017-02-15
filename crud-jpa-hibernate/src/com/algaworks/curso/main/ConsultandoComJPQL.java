package com.algaworks.curso.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.curso.modelo.Cliente;

public class ConsultandoComJPQL {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager em = emf.createEntityManager();
		
		List<Cliente> clientes = em.createQuery("from Cliente c", Cliente.class).getResultList();
		for(Cliente cliente : clientes){
			System.out.println("Codigo: " + cliente.getCodigo());
			System.out.println("Nome: " + cliente.getNome());
			System.out.println("Sexo: " + cliente.getSexo());
			System.out.println("Profisso: " + cliente.getProfissao());
			System.out.println("---------------------------");
		}

	}

}
