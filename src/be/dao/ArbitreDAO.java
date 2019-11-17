package be.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.jdi.connect.spi.Connection;

import be.cuvelier.Arbitre;



public class ArbitreDAO extends DAO<Arbitre> {
	
	public ArbitreDAO(Connection conn){
		super(conn);
	}
	
	public boolean create(Arbitre obj){		
		return false;
	}
	
	public boolean delete(Arbitre obj){
		return false;
	}
	
	public boolean update(Arbitre obj){
		return false;
	}
	
	public Arbitre find(int id){
		Arbitre j = new Arbitre(null, null, null);
		try{
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
	ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Arbitre WHERE N°  = " + id);
			if(result.first())
				j = new Arbitre();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return j;
	}

	
	public List<Joueur> findAll() {
		return null;
	
	}

}
