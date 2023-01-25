package com.estudos.curso.dao;

import javax.swing.JOptionPane;

import com.estudos.curso.modelo.Cliente;

public class SalvaCliente {

	public static void main(String[] args) {
		// instanciando um objeto cliente
		Cliente cliente = new Cliente();

		// lendo o nome do cliente do teclado e inserindo no banco
		String nome = JOptionPane.showInputDialog(null, "nome do cliente", "cadastro de cliente",
				JOptionPane.QUESTION_MESSAGE);

		if (nome != null) {
		//verificando se o usuario nao passou nenhum valor nulo
			cliente.setNome(nome);

			// chamando a interface DAO para salvar esse cliente no banco
			ClienteDAO clienteDAO = DAOFactory.getDAOFactory().getClienteDAO();
			// como abstraimos vamos usar apenas o ClienteDAO e nao o JdbcDAO
			clienteDAO.salvar(cliente);
			System.out.println("cliente salvo com sucesso.");
		}
		

	}

}
