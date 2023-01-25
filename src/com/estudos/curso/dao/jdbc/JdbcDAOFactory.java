package com.estudos.curso.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import com.estudos.curso.dao.ClienteDAO;
import com.estudos.curso.dao.DAOFactory;

public class JdbcDAOFactory extends DAOFactory {

	// criando a conexao para passar para cada um dos DAOS
	private Connection connection;

	// construtor
	public JdbcDAOFactory() {
		try {
			// carregando o driver para recuperar a conexao com o banco de dados
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost/cadastro_cliente", "root", "root");
		} catch (Exception e) {
			// tratando caso de erro com conexao
			throw new RuntimeException("Erro recuperando conexao com o banco", e);
		}
	}

	@Override
	public ClienteDAO getClienteDAO() {
		return new JdbcClienteDAO(connection);
	}

}
