package be.cuvelier;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
	
private List<Joueur> joueurs;
	
	public Equipe(Joueur j1) {
		this.joueurs = new ArrayList<Joueur>();
		this.joueurs.add(j1);
	}
	public Equipe(Joueur j1, Joueur j2) {
		this.joueurs = new ArrayList<Joueur>();
		this.joueurs.add(j1);
		this.joueurs.add(j2);
	}
	public String toString() {
		String n =" ";
		for( Joueur j : joueurs)
		{
			n=n+j.toString();
			n=n+"  ";
		}
		return n;		  
	}
	
	public List<Joueur> getJoueur(){
		return joueurs;
	}

}
