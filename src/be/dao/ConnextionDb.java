package be.dao;

import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import java.sql.Connection;

public class ConnextionDb {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		try
		{
			//V�rifie si le driver pour la connexion � une base de donn�es Access est pr�sent
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		}
		catch(ClassNotFoundException ex){
			JOptionPane.showMessageDialog(null,"Classe de driver introuvable " + ex.getMessage());
			System.exit(0);
		}
	
	//Permet de pr�parer la connexion avec la base de donn�es
	Connection connect = null;
	//Permet de pr�parer la requ�te
	Statement stmt = null;
	//Permet de r�cup�rer le resultat
	ResultSet res = null;
	
	try
	{
		//Associe la connexion de la base de donn�es
		//La classe DriverManager va permettre de se connecter � une source de donn�es
		//La m�thode getConnection permet de d�finir la base de donn�es que l'on va utiliser
		connect = DriverManager.getConnection("jdbc:ucanaccess://./player.accdb");
		
		//On �crit la requ�te � �x�cuter
		String requete = "SELECT marque,modele FROM Voiture";
		//On cr�e la requ�te qui va �tre envoy� � la base de donn�es
		stmt = connect.createStatement();
		//On �xecute la requ�te et le resultat est stock� dans un objet de type ResultSet
		res = stmt.executeQuery(requete);
		
		String marque;
		String modele;
		
		//On parcours le r�sultat de la requ�te
		while(res.next()){
			//Associe la donn�es de la premi�re colonne du r�sultat (La marque de la voiture)
			marque = res.getString(1);
			//Associe la donn�es de la deuxi�me colonne du r�sultat (Le mod�le de la voiture)
			modele = res.getString(2);
			//Affiche dans la console les valeurs retourn�es par la requ�te
			System.out.println("Marque : " + marque + "\nMod�le : " + modele + "\n-------------------");
		}
	}
	catch(SQLException e){
		//Capture une eventuelle erreur si la connexion n'a pas pu s'�tablir avec la base de donn�es
		JOptionPane.showMessageDialog(null, "Erreur JDBC : " + e.getMessage());
	}
	
	finally{
				
				try{
					if(res != null){
						//Lib�re l'objet resultat si celui-ci est null
						res.close();
					}
					if(stmt != null){
						//Lib�re l'objet requ�te si celui-ci est null
						stmt.close();
					}
					if(connect != null){
						//Lib�re l'object connexion si celui-ci est null
						connect.close();
					}
				}
			catch(SQLException ex){
				ex.printStackTrace();
			}
		}
	}
}




