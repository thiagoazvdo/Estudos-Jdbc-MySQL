package com.estudos.curso.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			// preparedstatement eh a funcao que executa o insert da string do comando sql
		} catch (SQLException e) {
			throw new DAOException("Erro salvando cliente", e);
		} finally {
			try {
				this.connection.close();
			} catch (Exception e) {
			}
		}

	}

	@Override
	public Cliente buscarPeloCodigo(Long codigo) {
		Cliente cliente = null;

		try {
			// string do comando sql para consulta no banco
			String sql = String.format("select * from cliente where codigo = %d", codigo);
			PreparedStatement ps = this.connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			// resultset eh a funcao que executa o select do preparedstatement da string sql
			while (rs.next()) {
				// enquanto tiverem clientes com o codigo informado por parametro instancie um
				// novo cliente e atribua o nome e codigo
				cliente = new Cliente();
				cliente.setCodigo(rs.getLong("codigo"));
				cliente.setNome(rs.getString("nome"));
			}

		} catch (SQLException e) { //tratamento de erro de conexao
			throw new DAOException("Erro salvando cliente", e);
		} finally {
			try {
				this.connection.close();
			} catch (Exception e) {
			}
		}
		//retornando o cliente
		return cliente;
	}

	@Override
	public List<Cliente> buscarTodos() {
		List<Cliente> clientes = new ArrayList<>();
		try {
			String sql = "select * from cliente";
			PreparedStatement ps = this.connection.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setCodigo(rs.getLong("codigo"));
				cliente.setNome(rs.getString("nome"));
				
				clientes.add(cliente);
			}
		} 
		catch (SQLException e) { //tratamento de erro de conexao
				throw new DAOException("Erro salvando cliente", e);
			} finally {
				try {
					this.connection.close();
				} catch (Exception e) {
				}
			}
		return clientes;
	}

}
