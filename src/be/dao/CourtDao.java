package be.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import be.cuvelier.Court;

public class CourtDao extends DAO<Court> {
	
	public CourtDao(Connection conn){
		super(conn);
	}
	
	public boolean create(Court obj){		
		return false;
	}
	
	public boolean delete(Court obj){
		return false;
	}
	
	public boolean update(Court obj){
		return false;
	}
	
	public Court find(int id){
		Court j = new Court();
		try{
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
	ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Court WHERE id_c  = " + id);
			if(result.first())
				j = new Court();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return j;
	}

	
	public List<Court> findAll() {
		List<Court> aliste = new ArrayList<Court>();
		try {
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
	ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Court");
			while(result.next()) {
				 Court a1 = new Court();
				a1.setIdc(result.getInt("id_c"));
				a1.setCouvert(result.getInt("couvert"));
				a1.setType(result.getString("typeS"));
				a1.setNbrspct(result.getInt("nbsp"));
					
				aliste.add(a1);
				}
			}
		catch(SQLException e){
			e.printStackTrace();
		}	
		return aliste;
	
	}
}
