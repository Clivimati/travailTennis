package be.cuvelier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;



public class Match {
	
	Equipe [] team ;
	Ordonnancement ord;
	private int durer;
	private int tour= 0;
	private Date date;
	private int[][] score;
	private Arbitre arbitre;
	private Court court;
	private final List<Equipe> listeEquipe = new ArrayList<Equipe>();
	
	public Match(Equipe e1, Equipe e2) {
		this.listeEquipe.add(e1);
		this.listeEquipe.add(e2);
	}
	
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
	
	
	
	public int[][] GetScore() {
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
	
	public void verifierScore( Equipe e1 , Equipe e2, int numtype) 
	{
		int set = 1;	
		score = new int[2][numtype+2];	
		int win1=0;
		int win2=0;
		jouerMatch(e1,e2);
		
		while ( set !=numtype+1) {
		int s1 = new Random().nextInt((7 - 1) + 1) + 1;
	    int s2 = new Random().nextInt((7 - 1) + 1) + 1;
	     	if( s1 == 6 && s2 == 6 ){
	    		if(tieBreak() == true) {
	    			set ++;
	    			s1 =7;
	    			score[1][set]=s1;
	    			score[2][set]=s2;
	    			win1 ++;
	    			System.out.println(score[1][set] +" "+ score[2][set]);
	    			
	    			
	    		}else if (tieBreak()== false){
	    			set ++;
	    			s2=7;
	    			score[1][set]=s1;
	    			score[2][set]=s2;
	    			win2++;
	    			System.out.println(score[1][set] +" "+ score[2][set]);
	    		}
	    	}
			else if (s1 == 7 && s2 == 5 || s1 ==6 && s2 ==4 ) {
			 	set ++;
	    		score[1][set]=s1;
    			score[2][set]=s2;
	    		win1++;
	    		System.out.println(score[1][set] +" "+ score[2][set]);
	    }else if(s2 == 7 && s1 == 5 || s2 ==6 && s1 ==4) {
	    	set++;
	    	score[1][set]=s1;
			score[2][set]=s2;
			win2++;
	    	System.out.println(score[1][set] +" "+ score[2][set]);
	    }else if ( s1 ==6 && s1 >s2+2) {
	    	set ++;
	    	score[1][set]=s1;
			score[2][set]=s2;
			win1++;
	    	System.out.println(score[1][set] +" "+ score[2][set]);
	    }else if ( s2 ==6 && s2 > s1+2) {
	    	set++;
	    	score[1][set]=s1;
			score[2][set]=s2;
			win2++;
	    	System.out.println(score[1][set] +" "+ score[2][set]);
	    }else if(s1 <=5 && s2 <=5  ) {
	    	 s1 = new Random().nextInt((7 - 4) + 1) + 4;
			 s2 = new Random().nextInt((7 - 4) + 1) + 4;
			 if(s1 == 7 && s2 == 5 || s1 ==6 && s2 ==4) {
				 set ++;
				 score[1][set]=s1;
				 score[2][set]=s2;
				 win1++;
				 System.out.println(score[1][set] +" "+ score[2][set]);
			 }else if(s2 == 7 && s1 == 5 || s2 ==6 && s1 ==4)
			 {		set++;
				 	score[1][set]=s1;
					score[2][set]=s2;
					win2++;
			    	System.out.println(score[1][set] +" "+ score[2][set]); 
			 }else if ( s2 ==4 && s1 ==4) {
				 	 int t = new Random().nextInt((2- 1) + 1) + 1;
					 if(t == 2) {
						 set++;
						 score[1][set]=s1+t;
						 score[2][set]=s2;
						 win1++;
						 System.out.println(score[1][set] +" "+ score[2][set]); 
					 }else if( t ==1) {
						 set++;
						 score[1][set]=s1;
						 score[2][set]=s2+2;
						 win2++;
						 System.out.println(score[1][set] +" "+ score[2][set]);
					 }
				 	
			 }
	    	}
		}if(numtype ==3 && win1 ==2 || numtype==5 && win1 >=3)
		{
			
		}else if(numtype ==3 && win2 ==2 || numtype==5 && win2 >=3) {
			
			
		}
		
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
