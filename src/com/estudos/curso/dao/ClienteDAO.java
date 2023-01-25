package com.estudos.curso.dao;

import java.util.List;

import com.estudos.curso.modelo.Cliente;

public interface ClienteDAO {

	public void salvar(Cliente cliente);

	public Cliente buscarPeloCodigo(Long codigo);

	public List<Cliente> buscarTodos();

}
