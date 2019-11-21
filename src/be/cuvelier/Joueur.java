package be.cuvelier;

import java.io.Serializable;

public class Joueur extends Personne implements Serializable {
	private static final long serialVersionUID=1;
	
	private String sexe;
	private int classement;
	
	public Joueur() {}
	
	public Joueur(int i,String s, int c, String n , String p) 
	{
		super(i,n,p);
		sexe=s;
		classement =c;
		
	}
	
	public String GetSexe() {
		return sexe;
	}
	
	public int GetClass() {
		return classement;
	}

}
