package com.estudos.curso.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.estudos.curso.dao.ClienteDAO;
import com.estudos.curso.dao.DAOException;
import com.estudos.curso.modelo.Cliente;

public class JdbcClienteDAO implements ClienteDAO {

	private Connection connection;
	// criando a conexao (sql.connection)

	// criando o construtor
	public JdbcClienteDAO(Connection connection) {
		this.connection = connection;
	}

	// implementando o metodo salvar da classe clienteDAO
	@Override
	public void salvar(Cliente cliente) {
		try { // tratamento em caso de erro com a conexao
			String sql = String.format("insert into cliente (nome) values ('%s')", cliente.getNome());
			// criando a string sql para deixar o comando pronto para rodar no sgbd
			PreparedStatement ps = this.connection.prepareStatement(sql);
			ps.executeUpdate();
			// preparedstatement eh a funcao que executa a string do comando sql
		} catch (SQLException e) {
			throw new DAOException("Erro salvando cliente", e);
		} finally {
			try {
				this.connection.close();
			} catch (Exception e) {
			}
		}
	}

}
