package be.cuvelier;

public class Joueur extends Personne {
	
	private int pti;
	private String sexe;
	private int classement;
	public Joueur(int pt,String s, int c, String n , String p) 
	{
		super(n,p);
		pti= pt;
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
