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
		boolean hasWinner = false;
		while (hasWinner == false) {
			int winner = (int) (Math.random() * ( 1 - 0 ));
			score.put(this.equipeTab[winner].hashCode(), score.get(this.equipeTab[winner]) + 1);
			hasWinner = VerifierResultat(NbrSetMax);
		}
	};
	
	public boolean VerifierResultat(int nbrSetMax) {
		return false;
	}
	
	public void verifierScore( Equipe e1 , Equipe e2, int numtype) 
	{
		int set = 1;	
		scor = new int[2][numtype+2];	
		int win1=0;
		int win2=0;

		
		while ( set !=numtype+1) {
		int s1 = new Random().nextInt((7 - 1) + 1) + 1;
	    int s2 = new Random().nextInt((7 - 1) + 1) + 1;
	     	if( s1 == 6 && s2 == 6 ){
	    		if(tieBreak() == true) {
	    			set ++;
	    			s1 =7;
	    			scor[1][set]=s1;
	    			scor[2][set]=s2;
	    			win1 ++;
	    			System.out.println(scor[1][set] +" "+ scor[2][set]);
	    			
	    			
	    		}else if (tieBreak()== false){
	    			set ++;
	    			s2=7;
	    			scor[1][set]=s1;
	    			scor[2][set]=s2;
	    			win2++;
	    			System.out.println(scor[1][set] +" "+ scor[2][set]);
	    		}
	    	}
			else if (s1 == 7 && s2 == 5 || s1 ==6 && s2 ==4 ) {
			 	set ++;
	    		scor[1][set]=s1;
    			scor[2][set]=s2;
	    		win1++;
	    		System.out.println(scor[1][set] +" "+ scor[2][set]);
	    }else if(s2 == 7 && s1 == 5 || s2 ==6 && s1 ==4) {
	    	set++;
	    	scor[1][set]=s1;
			scor[2][set]=s2;
			win2++;
	    	System.out.println(scor[1][set] +" "+ scor[2][set]);
	    }else if ( s1 ==6 && s1 >s2+2) {
	    	set ++;
	    	scor[1][set]=s1;
			scor[2][set]=s2;
			win1++;
	    	System.out.println(scor[1][set] +" "+ scor[2][set]);
	    }else if ( s2 ==6 && s2 > s1+2) {
	    	set++;
	    	scor[1][set]=s1;
			scor[2][set]=s2;
			win2++;
	    	System.out.println(scor[1][set] +" "+ scor[2][set]);
	    }else if(s1 <=5 && s2 <=5  ) {
	    	 s1 = new Random().nextInt((7 - 4) + 1) + 4;
			 s2 = new Random().nextInt((7 - 4) + 1) + 4;
			 if(s1 == 7 && s2 == 5 || s1 ==6 && s2 ==4) {
				 set ++;
				 scor[1][set]=s1;
				 scor[2][set]=s2;
				 win1++;
				 System.out.println(scor[1][set] +" "+ scor[2][set]);
			 }else if(s2 == 7 && s1 == 5 || s2 ==6 && s1 ==4)
			 {		set++;
				 	scor[1][set]=s1;
					scor[2][set]=s2;
					win2++;
			    	System.out.println(scor[1][set] +" "+ scor[2][set]); 
			 }else if ( s2 ==4 && s1 ==4) {
				 	 int t = new Random().nextInt((2- 1) + 1) + 1;
					 if(t == 2) {
						 set++;
						 scor[1][set]=s1+t;
						 scor[2][set]=s2;
						 win1++;
						 System.out.println(scor[1][set] +" "+ scor[2][set]); 
					 }else if( t ==1) {
						 set++;
						 scor[1][set]=s1;
						 scor[2][set]=s2+2;
						 win2++;
						 System.out.println(scor[1][set] +" "+ scor[2][set]);
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
