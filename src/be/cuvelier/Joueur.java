package be.cuvelier;

public class Joueur extends Personne {
	
	private char sexe;
	private int classement;
	
	public Joueur(char s, int c, String n , String p) 
	{
		super(n,p);
		sexe=s;
		classement =c;
		
	}
	
	public char GetSexe() {
		return sexe;
	}

}
