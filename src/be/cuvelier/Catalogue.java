package be.cuvelier;

import java.util.List;

import be.dao.DAO;
import be.dao.JoueurDao;

public class Catalogue {
	
	private static Catalogue singleton = new Catalogue();
	private static DAO<Joueur> jdao = new JoueurDao(null);
    public Catalogue()
    { }

    public static Catalogue getInstance( )
    {
      return singleton;
    }

    public static List<Joueur> getList(){
    	
    	List<Joueur> j = jdao.findAll();
    	for (Joueur var : j) 
    	{ 
    		System.out.println("  - " + var.getNom() + " " + var.getPrenom() + " " + var.GetSexe());
    	}
    	return j;
    }

}
