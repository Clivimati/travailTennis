package be.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.sun.jdi.connect.spi.Connection;

import be.cuvelier.Joueur;

public class JoueurDao extends DAO<Joueur> {
	
	public JoueurDao(Connection conn){
		super(conn);
	}
	
	public boolean create(Joueur obj){		
		return false;
	}
	
	public boolean delete(Joueur obj){
		return false;
	}
	
	public boolean update(Joueur obj){
		return false;
	}
	
	public Joueur find(int id){
		Joueur j = new Joueur(id, null, 0, null, null);
		try{
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
	ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Joueur WHERE N�  = " + id);
			if(result.first())
				j = new Joueur(id,result.getString("sexe"),result.getInt("classement"),result.getString("nom"),result.getString("prenom"));
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


