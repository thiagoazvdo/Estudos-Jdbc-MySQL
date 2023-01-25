package com.estudos.curso;

import java.util.List;

import com.estudos.curso.dao.ClienteDAO;
import com.estudos.curso.dao.DAOFactory;
import com.estudos.curso.modelo.Cliente;

public class BuscaTodosClientes {
	public static void main(String[] args) {
		ClienteDAO clienteDAO = DAOFactory.getDAOFactory().getClienteDAO();

		List<Cliente> clientes = clienteDAO.buscarTodos();

		for (Cliente cliente : clientes) {
			System.out.println("---------- Cliente encontrado ----------");
			System.out.printf("Código: %d\n", cliente.getCodigo());
			System.out.printf("Nome: %s\n", cliente.getNome());
			System.out.println();

		}

	}

}
