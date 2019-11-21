package be.cuvelier;

public class Personne {
	
	int id;
	public String nom;
	public String prenom;
	
	public Personne(int i,String n, String p) 
	{
		id=i;
		nom=n;
		prenom=p;
	}
	
	public Personne() {}
	
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}

}
