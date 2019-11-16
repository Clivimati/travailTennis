package be.dao;

import java.util.List;

import com.sun.jdi.connect.spi.Connection;

import be.cuvelier.Joueur;

public abstract class DAO <T> {
protected Connection connect = null;
	
	public DAO(Connection conn){
		this.connect = conn;
	}
	
	public abstract boolean create(T obj);
	
	public abstract boolean delete(T obj);
	
	public abstract boolean update(T obj);
	
	public abstract T find(int id);
	
	public abstract List<Joueur> findAll();
}



