package be.dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
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
		Joueur j = new Joueur();
		try{
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
	ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Joueur WHERE id_j  = " + id);
			if(result.first())
				j = new Joueur(id,result.getString("sexe"),result.getInt("classement"),result.getString("nom_j"),result.getString("prenom_j"));
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return j;
	}

	
	public List<Joueur> findAll() {
		
		List<Joueur> j = new ArrayList<Joueur>();
		try {
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
	ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Joueur");
			if(result.first())
				j = new ArrayList<Joueur>(result.getInt("nom_j"));
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return j;
	}
}



