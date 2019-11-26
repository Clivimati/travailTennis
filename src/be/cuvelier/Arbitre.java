package be.cuvelier;

import java.util.Date;
import java.util.List;

public class Arbitre extends Personne {
	
	private List<Date> indisponibiliter;
	
	public Arbitre(int i,Date indisponibilite , String n, String p) {
		super(i,n,p);
		this.indisponibiliter= (List<Date>)indisponibilite;
	}
	
	public Arbitre() {}
	
	

}
