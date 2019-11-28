package be.cuvelier;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JOptionPane;

import be.dao.DAO;
import be.dao.JoueurDao;
import be.dao.TennisConnection;



public class Tournoi  {

	public Tournoi() {
		
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
	
	public List<Ordonnancement> getOrds(){
		return listeOrdonnancement;
	}
	
	private int calculerSet() {
		switch (this.type) {
		case Tournoi.SIMPLE_HOMME:
			return 3;
		default:
			return 2;
		}
	}
	public void ajouterOrd() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		cal.set(Calendar.HOUR_OF_DAY,10);
		cal.set(Calendar.MINUTE,0);
		Ordonnancement ord = new Ordonnancement(genererMatchesAleatoire(NBR_MATCHES_DEFAUT),cal.getTime());
		
		
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
	

	
	public  List<Match> matchSuivants(List<Equipe> eqliste){
		List<Match> mliste = new ArrayList<Match>();
		int taille = (eqliste.size()/2)-1;
		for(int i = 0 ; i <= taille ; i++ ) {
			Equipe e1 = eqliste.stream().findFirst().get();
			eqliste.remove(e1);
			Equipe e2 = eqliste.stream().findFirst().get();
			eqliste.remove(e2);
			
			mliste.add(new Match(e1,e2,this.nbrSetGagnant));
		}
		return mliste;
	}
	
	public void jouer() throws Exception {
		if (listeOrdonnancement.size() > 0) {
			boolean nextTour;
			do {
				nextTour = false;
				Ordonnancement dernierTour = listeOrdonnancement.get(listeOrdonnancement.size() - 1);
				dernierTour.organiserMatch();
				List<Equipe>vainqueurs = dernierTour.jouerMatches();
				if (vainqueurs.size() > 1) {
					nextTour = true;
					List<Match> mliste = matchSuivants(vainqueurs);
					String mat = String.valueOf(mliste);
					SimpleDateFormat formatte = new SimpleDateFormat("dd-MM-yyyy HH:mm");
					Calendar cal = Calendar.getInstance();
					cal.setTime(dernierTour.getFin());
					cal.add(Calendar.DATE, 1);
					cal.set(Calendar.HOUR_OF_DAY,10);
					Ordonnancement prochainTour = new Ordonnancement(mliste,cal.getTime());
					System.out.println(formatte.format(cal.getTime()));
					this.listeOrdonnancement.add(prochainTour);
					
				}
			}while(nextTour );
				
		}
		else {
			throw new Exception("Aucun match à jouer");
		}
	}
	
	
	

}
