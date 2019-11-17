package be.cuvelier;

import java.util.Date;
import java.util.Random;

public class Match {
	
	
	
	private int durer;
	private int tour;
	private Date date;
	private int score;
	
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
	
	public void VerifierScore(Equipe[] team) 
	{
		int set = 1;
		Random r = new Random();
		r.nextInt(7 - 4);	
	}
}
