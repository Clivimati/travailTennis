package be.cuvelier;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;



public class Match {
	
	private Equipe[] equipeTab = new Equipe[2];
	private int durer;
	private int tour= 0;
	private Date date;
	private HashMap<Integer, Integer> score = new HashMap<Integer, Integer>();
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
	}
	
	public Match() {}
	
	
	
	
	public int GetTour() {
		return tour;
	}
	
	public int GetDure() {
		return durer;
	}
	
	public Date GetDateM() {
		return date;
	}
	
	public Arbitre Supperviser() {
		
		Arbitre a = new Arbitre();
		if(a.GetDisponibiliter()!= date) {
			return null;
		}
		
		return a;
	}
	public void JouerMatch(int NbrSetMax) {
		score.put(this.equipeTab[0].hashCode(), 0);
		score.put(this.equipeTab[1].hashCode(), 0);
		
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
			if ((score1 == 6) || (score2 == 6)){
				return false;
			}
		}
		else {
			if ((score1 > 5 || score2 > 5) && scoreDiff >= 2) {
				return false;
			}
			if ((score1 == 7) || (score2 == 7)){
				return false;
			}
		}
		return true;
	}
	
	    
	  public boolean tieBreak() {

	    	int s1 = new Random().nextInt((7 - 6) + 1) + 6;
	      	if( s1 ==7)
	      		return true;
	      	else
	      		return false;
	    }
	
	public int SwitchTour(Equipe win) {
		tour ++;
		return tour;
		
	}
	
	public void OrganiserMatch(Equipe e1, Equipe e2, Court t, Arbitre r) {
		
		///
	}
}
