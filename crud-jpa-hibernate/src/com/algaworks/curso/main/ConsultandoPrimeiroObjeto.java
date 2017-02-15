package com.algaworks.curso.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.curso.modelo.Cliente;

public class ConsultandoPrimeiroObjeto {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager em = emf.createEntityManager();
		
		try {
			//1L quer dizer que o ID 1 será um Long
			Cliente cliente = em.find(Cliente.class, 5L);
			
			if(cliente != null){
				System.out.println("Nome: " + cliente.getNome());
				System.out.println("Idade: " + cliente.getIdade());
				System.out.println("Profissao: " + cliente.getProfissao());
				System.out.println("Sexo: " + cliente.getSexo());
			}else{
				System.out.println("Nenhum cliente encontrado!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}

	}

}
