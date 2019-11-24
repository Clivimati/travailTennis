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
				j = new Joueur(id,result.getInt("sexe"),result.getInt("classement"),result.getString("nom_j"),result.getString("prenom_j"));
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return j;
	}

	
	public List<Joueur> findAll() {
		
		List<Joueur> jliste = new ArrayList<Joueur>();
		try {
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
	ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Joueur");
			
			while(result.next()) {
				Joueur j1 = new Joueur();
				j1.setId(result.getInt("id_j"));
				j1.setNom(result.getString("nom_j"));
				j1.setPrenom(result.getString("prenom_j"));
				j1.setSex(result.getInt("sexe"));
				j1.setClassement(result.getInt("classement"));
				
				jliste.add(j1);
			}
				
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return jliste;
	}
}



