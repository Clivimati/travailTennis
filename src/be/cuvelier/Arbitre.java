package be.cuvelier;

import java.util.Date;

public class Arbitre extends Personne {
	
	private Date disponibilite;
	
	public Arbitre(Date dispo, String n, String p) {
		super(n,p);
		disponibilite= dispo;
	}

}
