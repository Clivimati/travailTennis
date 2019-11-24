package be.cuvelier;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import be.dao.DAO;
import be.dao.JoueurDao;
import be.dao.TennisConnection;



public class Tournoi  {

	private List<Ordonnancement> ords;

	public Tournoi() {
		this.ords = new ArrayList<Ordonnancement>();
	}

	public static final int SIMPLE_HOMME = 1;
	public static final int SIMPLE_FEMME = 2;
	public static final int DOUBLE_HOMME = 3;
	public static final int DOUBLE_FEMME = 4;
	public static final int MIXTE = 5;
	
	public static final int NBR_MATCHES_DEFAUT = 64;
	
	private ArrayList<Ordonnancement> listeOrdonnancement;
	private int nbrSetGagnant;
	private int type;


	public Tournoi(int type) {
		this.type = type;
		this.nbrSetGagnant = calculerSet();
		this.listeOrdonnancement = new ArrayList<Ordonnancement>();
		
	}
	
	private int calculerSet() {
		switch (this.type) {
		case Tournoi.SIMPLE_HOMME:
			return 3;
		default:
			return 2;
		}
	}
	public void inscrireJoueur() {
		Ordonnancement ord = new Ordonnancement(genererMatchesAleatoire(NBR_MATCHES_DEFAUT)); // genere le 1er ordonnacement totalement alleatoire
		this.listeOrdonnancement.add(ord);
	}
	
	private List<Match> genererMatchesAleatoire(int nbrMatches){
		DAO<Joueur> jDAO = new JoueurDao(TennisConnection.getInstance());
		List<Joueur> listeJoueur = jDAO.findAll(); //appele le DAO avec tout les joueurs
		Collections.shuffle(listeJoueur); // permet de faire melanger la liste
		var matches = new ArrayList<Match>();
		for(int i = 0 ; i < nbrMatches ; i++) {
			if (this.type == Tournoi.SIMPLE_HOMME) {
				Equipe[] eTab = new Equipe[2];
				for (int k = 0 ; k < 2 ; k++) {
					Joueur j1 = listeJoueur.stream().filter( j -> j.getSex() == Joueur.HOMME).findAny().get(); // trouve n'importe quel joueur dans la liste
					listeJoueur.remove(j1); // l'enleve de cette liste comme ça impossible d'avoir 2 fois le même joueur
					eTab[k] = new Equipe(j1);
				}
				matches.add(new Match(eTab[0],eTab[1], this.nbrSetGagnant)); // crée tout les match du 1er tour
			}
			else if(this.type == Tournoi.SIMPLE_FEMME){
				Equipe[] eTab = new Equipe[2];
				for (int k = 0 ; k < 2 ; k++) {
					Joueur j1 = listeJoueur.stream().filter( j -> j.getSex() == Joueur.FEMME).findAny().get();
					listeJoueur.remove(j1);
					eTab[k] = new Equipe(j1);
				}
				matches.add(new Match(eTab[0],eTab[1], this.nbrSetGagnant));
			}
			else if(this.type == Tournoi.DOUBLE_HOMME){
				Equipe[] eTab = new Equipe[2];
				for (int k = 0 ; k < 2 ; k++) {
					Joueur j1 = listeJoueur.stream().filter( j -> j.getSex() == Joueur.HOMME).findAny().get();
					listeJoueur.remove(j1);
					Joueur j2 = listeJoueur.stream().filter( j -> j.getSex() == Joueur.HOMME).findAny().get();
					listeJoueur.remove(j2);
					eTab[k] = new Equipe(j1,j2);
				}
				matches.add(new Match(eTab[0],eTab[1], this.nbrSetGagnant));
			}
			else if(this.type == Tournoi.DOUBLE_FEMME){
				Equipe[] eTab = new Equipe[2];
				for (int k = 0 ; k < 2 ; k++) {
					Joueur j1 = listeJoueur.stream().filter( j -> j.getSex() == Joueur.FEMME).findAny().get();
					listeJoueur.remove(j1);
					Joueur j2 = listeJoueur.stream().filter( j -> j.getSex() == Joueur.FEMME).findAny().get();
					listeJoueur.remove(j2);
					eTab[k] = new Equipe(j1,j2);
				}
				matches.add(new Match(eTab[0],eTab[1], this.nbrSetGagnant));
			}
			else if(this.type == Tournoi.MIXTE){
				Equipe[] eTab = new Equipe[2];
				for (int k = 0 ; k < 2 ; k++) {
					Joueur j1 = listeJoueur.stream().filter( j -> j.getSex() == Joueur.FEMME).findAny().get();
					listeJoueur.remove(j1);
					Joueur j2 = listeJoueur.stream().filter( j -> j.getSex() == Joueur.HOMME).findAny().get();
					listeJoueur.remove(j2);
					eTab[k] = new Equipe(j1,j2);
				}
				matches.add(new Match(eTab[0],eTab[1], this.nbrSetGagnant));
			}
		}
		return matches;
	}
	
	


}
