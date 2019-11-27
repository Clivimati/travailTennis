package be.cuvelier;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import be.dao.ArbitreDAO;
import be.dao.DAO;
import be.dao.JoueurDao;
import be.dao.TennisConnection;



public class Match {
	
	private Equipe[] equipeTab = new Equipe[2];
	private int durer;
	private Date rencontre;
	private HashMap<Integer, Integer> setMap = new HashMap<Integer, Integer>();
	private ArrayList<int[]> scores;
	private int nbrSetMax;
	private Arbitre arbitre;
	private Court court;
	
	
	public static final int ID_EQUIPE_UNE = 0;
	public static final int ID_EQUIPE_DEUX = 1;
	
	public Match(Equipe equipeUne, Equipe equipeDeux, int NbrSetMax) {
		this.equipeTab[ID_EQUIPE_UNE] = equipeUne;
		this.equipeTab[ID_EQUIPE_DEUX] = equipeDeux;
		this.nbrSetMax = NbrSetMax;
		this.scores = new ArrayList<int[]>();
		this.durer = 2;
	}
	
	public Match() {}
	
	
	public Date getDate() {
		return rencontre;
	}
	
	public void setDate(Date rencontre) {
		this.rencontre = rencontre;
	}
	

	
	public Equipe jouerMatch() {
		
		setMap.put(Match.ID_EQUIPE_UNE, 0);
		setMap.put(Match.ID_EQUIPE_DEUX, 0);
		
		boolean gagnantMatch = false;
		while (gagnantMatch == false) {
			int vainqueurSet = jouerSet();
			ajouterVainqueurSet(vainqueurSet);
			gagnantMatch = verifierGagnant();
		}
		
		Equipe equipeVainqueur = recuperVainqueurMatch();
		
		return equipeVainqueur;
				
	}

	private Equipe recuperVainqueurMatch() {
		
		int setEquipe1= setMap.get(Match.ID_EQUIPE_UNE); // permet de connaitre l'id de l objet 
		int setEquipe2= setMap.get(Match.ID_EQUIPE_DEUX);
		
	    return equipeTab[(setEquipe1>setEquipe2)?Match.ID_EQUIPE_UNE:Match.ID_EQUIPE_DEUX]; // fait en sort de retourner le joueur qui a gagner
		
	}

	private void ajouterVainqueurSet(int vainqueurSet) {
		setMap.put(vainqueurSet, setMap.get(vainqueurSet) +1 ); // si il est vainceur on lui rajoute une valeur
	}

	private boolean verifierGagnant() {
		return (setMap.get(0) == nbrSetMax) || (setMap.get(1) == nbrSetMax);
	}
	
	private int jouerSet() {
		int[] scoreSet = {0,0};
		while (verifierScore(scoreSet))
		{
			int vainqueurJeu = jouerJeu();  // a chaque foi un ou 0 point va etre ajouter 
			scoreSet[vainqueurJeu] = scoreSet[vainqueurJeu] + 1;
		}
		this.scores.add(scoreSet);
		
		int indexVainqueur = recupererVainqueurSet(scoreSet);
		
		return indexVainqueur;
	}



	private int recupererVainqueurSet(int[] scoreSet) {
		int indexVainqueur = 0;
		
		for ( int i = 1; i < scoreSet.length; i++ )
		{
			if ( scoreSet[i] > scoreSet[indexVainqueur] ) indexVainqueur = i;
		}
		return indexVainqueur;
		
	}
	
	
	private int jouerJeu() {
		
		int rand= new Random().nextInt((1-0)+1)+0;
		return rand;
	}
	
	private boolean verifierScore(int[] scoreSet) {
		int score1 = scoreSet[0];
		int score2 = scoreSet[1];
		int scoreDiff = Math.abs(score1 - score2);
		
		if (this.scores.size() == (this.nbrSetMax - 1)) {
			if ((score1 == 6) || (score2 == 6)){ // si on est au dernier set celui a 6 gagne
				return false;
			}
		}
		else {
			if ((score1 > 5 || score2 > 5) && scoreDiff >= 2) { // le 1er plus grand que 5 et avec au mins 2 moins d'ecart
				return false;
			}
			if ((score1 == 7) || (score2 == 7)){
				return false;
			}
		}
		return true;
	}
	
	public String toString() {
		   return " " + this.equipeTab +
			  " " + this.rencontre +
			  " " + this.scores+
			  " "+arbitre;
		}
	
	    
}
