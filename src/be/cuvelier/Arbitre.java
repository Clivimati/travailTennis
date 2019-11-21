package be.cuvelier;

import java.util.Date;
import java.util.List;

public class Arbitre extends Personne {
	
	private List<Date> disponibilite;
	
	public Arbitre(int i,Date dispo, String n, String p) {
		super(i,n,p);
		disponibilite= (List<Date>) dispo;
	}
	
	public Arbitre() {}
	
	public List<Date> GetDisponibiliter() {
		return disponibilite;
	}

}
