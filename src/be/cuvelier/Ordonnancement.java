package be.cuvelier;


import java.util.ArrayList;
import java.util.List;

public class Ordonnancement {

	private List<Match> match ;
	private String type;
	private int nrbSetGagant;
	
	public Ordonnancement(int set) {
		type = "S";
		String ok;
		if(set == 3) {
			ok=type+"F";
			match = new ArrayList<Match>();
			return;
		}if(set == 5) {
			ok=type+"M";
			match = new ArrayList<Match>();
			return;
		}
		
	}
	
	public Ordonnancement (String t) {
		type = "D";
		nrbSetGagant = 3;
		String ok;
		if( t == "F") {
			
			ok=type + t;
			match = new ArrayList<Match>();
			return;
		}else if(t=="M") {
			ok=type + t;
			match = new ArrayList<Match>();
			return;
		}else if(t=="Mi") {
			ok=type + t;
			match = new ArrayList<Match>();
			return;
			}else {
				System.out.print("Impossible de cree votre tableau");
			}
		
	}
	
	public String GetType(){  
		return type; 
 	} 
	
	public int GetSetGagant() {
		return nrbSetGagant;
	}
	
	public List<Match> GetMatch(){
		return match;
	}
	
	public void AjouterMatch(Match jeu) {
		match.add(jeu);
		
	}

}
