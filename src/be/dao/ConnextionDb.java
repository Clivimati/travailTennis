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
			//Vérifie si le driver pour la connexion à une base de données Access est présent
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		}
		catch(ClassNotFoundException ex){
			JOptionPane.showMessageDialog(null,"Classe de driver introuvable " + ex.getMessage());
			System.exit(0);
		}
	
	//Permet de préparer la connexion avec la base de données
	Connection connect = null;
	//Permet de préparer la requête
	Statement stmt = null;
	//Permet de récupérer le resultat
	ResultSet res = null;
	
	try
	{
		//Associe la connexion de la base de données
		//La classe DriverManager va permettre de se connecter à une source de données
		//La méthode getConnection permet de définir la base de données que l'on va utiliser
		connect = DriverManager.getConnection("jdbc:ucanaccess://./player.accdb");
		
		//On écrit la requête à éxécuter
		String requete = "SELECT marque,modele FROM Voiture";
		//On crée la requête qui va être envoyé à la base de données
		stmt = connect.createStatement();
		//On éxecute la requête et le resultat est stocké dans un objet de type ResultSet
		res = stmt.executeQuery(requete);
		
		String marque;
		String modele;
		
		//On parcours le résultat de la requête
		while(res.next()){
			//Associe la données de la première colonne du résultat (La marque de la voiture)
			marque = res.getString(1);
			//Associe la données de la deuxième colonne du résultat (Le modèle de la voiture)
			modele = res.getString(2);
			//Affiche dans la console les valeurs retournées par la requête
			System.out.println("Marque : " + marque + "\nModèle : " + modele + "\n-------------------");
		}
	}
	catch(SQLException e){
		//Capture une eventuelle erreur si la connexion n'a pas pu s'établir avec la base de données
		JOptionPane.showMessageDialog(null, "Erreur JDBC : " + e.getMessage());
	}
	
	finally{
				
				try{
					if(res != null){
						//Libère l'objet resultat si celui-ci est null
						res.close();
					}
					if(stmt != null){
						//Libère l'objet requête si celui-ci est null
						stmt.close();
					}
					if(connect != null){
						//Libère l'object connexion si celui-ci est null
						connect.close();
					}
				}
			catch(SQLException ex){
				ex.printStackTrace();
			}
		}
	}
}




