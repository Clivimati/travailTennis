package be.cuvelier;

import java.util.List;
import java.util.Random;

import be.dao.DAO;
import be.dao.JoueurDao;

public class Equipe {
	
	private Joueur team[];
	private boolean nb_joueur;
	//private Catalogue cat = Catalogue.getInstance();
	private static DAO<Joueur> jdao = new JoueurDao(null);
	private int victoire =0;
	
	public Equipe() {}
	
	public Equipe(Joueur j1) 
	{
		nb_joueur = false;
		
		team = new Joueur[1];
		team[1]= j1;
		
	}
	
	public Equipe(Joueur j1, Joueur j2) {
		
		nb_joueur = true;
		team=new Joueur[2];
		
		team[1]= j1;
		team[2]= j2;
	}
	
	public boolean GetnbJoueur() {
		return nb_joueur;
	}
	
	public int getVictoire() {
		return victoire;
	}
	
	
	public Equipe FontionIntergerDE1() {
		
		Equipe eq1 = null ;
		for (int i = 1; i <= 128 ; i++  ) {
			Joueur j = jdao.find(i);
			eq1= new Equipe(j);	
		}
		
		return eq1;
			
	}
	
	public Equipe FonctionIntegrer2() {
		Equipe eq1 = null ;
		int id1 = new Random().nextInt((128 - 1) + 1) + 1;
		int id2 = new Random().nextInt((128 - 1) + 1) + 1;
		Joueur j1 = jdao.find(id1);
		Joueur j2 = jdao.find(id2);
		
		if(id1!= id2 && j1.GetSexe()=="F"&& j2.GetSexe()=="F" ) {
			eq1 = new Equipe(j1, j2);	
		}else if(id1!= id2 && j1.GetSexe()=="M"&& j2.GetSexe()=="M"){
			eq1= new Equipe(j1,j2);
		}else if (id1!= id2 &&j1.GetSexe()=="M" &&j2.GetSexe()=="F" ||j1.GetSexe()=="F" &&j2.GetSexe()=="M"){
			eq1 = new Equipe(j1,j2);
			
		}
		
    	return eq1;
		
	}
	

}
