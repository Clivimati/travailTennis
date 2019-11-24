package be.cuvelier;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import be.dao.DAO;
import be.dao.JoueurDao;
import be.dao.TennisConnection;



public class Ordonnancement {

	private List<Match> matches;
	private int type;
	private int nbrSetGagnant;
	
	public static final int SIMPLE_HOMME = 1;
	public static final int SIMPLE_FEMME = 2;
	public static final int DOUBLE_HOMME = 3;
	public static final int DOUBLE_FEMME = 4;
	public static final int MIXTE = 5;

	
	public Ordonnancement(int type) {
		this.type = type;
		this.nbrSetGagnant = CalculerSet();
		this.matches = new ArrayList<Match>();
	}
	
	private int CalculerSet() {
		switch (this.type) {
		case Ordonnancement.SIMPLE_HOMME:
			return 5;
		default:
			return 3;
		}
	}

	public void CreerMatch() {
		
		
		DAO<Joueur> jDAO = new JoueurDao(TennisConnection.getInstance());
		List<Joueur> listeJoueur = jDAO.findAll();
		Collections.shuffle(listeJoueur);
		for(int i = 0 ; i < 64 ; i++) {
			if (this.type == Ordonnancement.SIMPLE_HOMME) {
				Joueur j1 = listeJoueur.stream().filter( j -> j.getSex() == Joueur.HOMME).findAny().get();
				listeJoueur.remove(j1);
				Joueur j2 = listeJoueur.stream().filter( j -> j.getSex() == Joueur.HOMME).findAny().get();
				listeJoueur.remove(j2);
				
				Equipe e1 = new Equipe(j1);
				Equipe e2 = new Equipe(j2);
				
				this.matches.add(new Match(e1,e2));
			}
			else if(this.type == Ordonnancement.SIMPLE_FEMME){
				Joueur j1 = listeJoueur.stream().filter( j -> j.getSex() == Joueur.FEMME).findAny().get();
				listeJoueur.remove(j1);
				Joueur j2 = listeJoueur.stream().filter( j -> j.getSex() == Joueur.FEMME).findAny().get();
				listeJoueur.remove(j2);
				
				Equipe e1 = new Equipe(j1);
				Equipe e2 = new Equipe(j2);
				
				this.matches.add(new Match(e1,e2));
			}
			else if(this.type == Ordonnancement.DOUBLE_HOMME){
				Joueur j1 = listeJoueur.stream().filter( j -> j.getSex() == Joueur.HOMME).findAny().get();
				listeJoueur.remove(j1);
				Joueur j2 = listeJoueur.stream().filter( j -> j.getSex() == Joueur.HOMME).findAny().get();
				listeJoueur.remove(j2);
				Joueur j3 = listeJoueur.stream().filter( j -> j.getSex() == Joueur.HOMME).findAny().get();
				listeJoueur.remove(j3);
				Joueur j4 = listeJoueur.stream().filter( j -> j.getSex() == Joueur.HOMME).findAny().get();
				listeJoueur.remove(j4);
				
				Equipe e1 = new Equipe(j1,j2);
				Equipe e2 = new Equipe(j3,j4);
				
				this.matches.add(new Match(e1,e2));
			}
			else if(this.type == Ordonnancement.DOUBLE_FEMME){
				Equipe[] eTab = new Equipe[2];
				for (int k = 0 ; k < 2 ; k++) {
					Joueur j1 = listeJoueur.stream().filter( j -> j.getSex() == Joueur.FEMME).findAny().get();
					listeJoueur.remove(j1);
					Joueur j2 = listeJoueur.stream().filter( j -> j.getSex() == Joueur.FEMME).findAny().get();
					listeJoueur.remove(j2);
					eTab[k] = new Equipe(j1,j2);
				}
				this.matches.add(new Match(eTab[0],eTab[1]));
			}
			else if(this.type == Ordonnancement.MIXTE){
				Equipe[] eTab = new Equipe[2];
				for (int k = 0 ; k < 2 ; k++) {
					Joueur j1 = listeJoueur.stream().filter( j -> j.getSex() == Joueur.FEMME).findAny().get();
					listeJoueur.remove(j1);
					Joueur j2 = listeJoueur.stream().filter( j -> j.getSex() == Joueur.HOMME).findAny().get();
					listeJoueur.remove(j2);
					eTab[k] = new Equipe(j1,j2);
				}
				this.matches.add(new Match(eTab[0],eTab[1]));
			}
		}
	}
	
	public int getType(){  
		return type; 
 	} 
	
	public int getSetGagant() {
		return nbrSetGagnant;
	}
	
	public void OrganiserMatch() {
		// TODO Auto-generated method stub
		
	};
	
}
