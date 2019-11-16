package be.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

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
		Joueur j = new Joueur();
		try{
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
	ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Eleve WHERE elv_id = " + id);
			if(result.first())
				j = new Joueur(0, id, result.getString("elv_nom"), result.getString("elv_prenom"));
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return j;
	}

	
	public Joueur findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}


}
