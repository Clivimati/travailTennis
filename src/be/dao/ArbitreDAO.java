package be.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
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
		Arbitre j = new Arbitre();
		try{
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
	ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Arbitre WHERE id_a  = " + id);
			if(result.first())
				j = new Arbitre();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return j;
	}

	
	public List<Arbitre> findAll() {
		List<Arbitre> aliste = new ArrayList<Arbitre>();
		try {
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
	ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Arbitre");
			while(result.next()) {
				 Arbitre a1 = new Arbitre();
				a1.setId(result.getInt("id_a"));
				a1.setNom(result.getString("nom_a"));
				a1.setPrenom(result.getString("prenom_a"));
				
				
				aliste.add(a1);
			}
			}
		catch(SQLException e){
			e.printStackTrace();
		}	
		return aliste;
	
	}

}
