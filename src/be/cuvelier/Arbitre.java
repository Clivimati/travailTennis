package be.cuvelier;

import java.util.Date;
import java.util.List;

public class Arbitre extends Personne {
	
	private List<Date> disponibilite;
	
	public Arbitre(Date dispo, String n, String p) {
		super(n,p);
		disponibilite= (List<Date>) dispo;
	}
	
	public List<Date> GetDisponibiliter() {
		return disponibilite;
	}

}
