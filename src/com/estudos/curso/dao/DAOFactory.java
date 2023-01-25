package com.estudos.curso.dao;

import com.estudos.curso.dao.jdbc.JdbcDAOFactory;

public abstract class DAOFactory {
	
	public static DAOFactory getDAOFactory() {
		return new JdbcDAOFactory();
	}
	
	
	public abstract ClienteDAO getClienteDAO();

}
