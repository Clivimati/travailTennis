package be.cuvelier;

import java.util.Date;
import java.util.Random;

public class Match {
	
	Equipe [] team ;
	Ordonnancement ord;
	private int durer;
	private int tour= 0;
	private Date date;
	private int score;
	
	public Match() {}
	
	@SuppressWarnings("deprecation")
	public Match(Equipe e1, Equipe e2, Court t, Arbitre r) {
		Supperviser();
		jouerMatch(e1,e2);
		int temps = new Random().nextInt((3 - 1) + 1) + 1;
		durer = temps;
		int month  = new Random().nextInt((7 - 5) + 1) + 5;
		int jour = new Random().nextInt((30 - 1) + 1) + 1;
		int year= 2020;
		date = new Date(year, month, jour);
	}
	
	public int GetScore() {
		return score;
	}
	
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
	
	public Equipe[] jouerMatch(Equipe e1 , Equipe e2) {
		
		team = new Equipe [2];
		team[1]= e1;
		team[2]=e2;
		return team;	
	}
	
	public void VerifierScore(Equipe[] team) 
	{
		int set = 1;	
		
	}
	
	public int SwitchTour(Equipe win) {
		tour ++;
		return tour;
		
	}
	
	public void OrganiserMatch(Equipe e1, Equipe e2, Court t, Arbitre r) {
		
		if(ord.GetType()=="SM") {
			Match n1= new Match (e1,e2,t,r);
		}else if (ord.GetType()=="SF") {
			Match n1= new Match (e1,e2,t,r);
		}else if (ord.GetType()=="DF") {
			Match n1= new Match (e1,e2,t,r);
		}else if (ord.GetType()=="DM") {
			Match n1= new Match (e1,e2,t,r);
		}else if (ord.GetType()=="DMi") {
			
		}
	}
}
