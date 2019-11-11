package be.cuvelier;

import java.util.Iterator;

public class Ordonnancement {

	private Iterator<Match> match ;
	private String type;
	private int nrbSetGagant;
	
	public String GetType(){  
		return type; 
 	} 
	
	public int GetSetGagant() {
		return nrbSetGagant;
	}
	
	public Iterator<Match> GetMatch(){
		return match;
	}

}
