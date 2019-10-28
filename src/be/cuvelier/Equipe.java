package be.cuvelier;

public class Equipe {
	
	private Joueur eq[];
	private int nb_joueur;
	
	public Equipe(int nb) 
	{
		if(nb<= 2) {
		eq = new Joueur[nb];
		}else {
			System.out.print("Impossible de créer de plus grande equipe");
		}
	}

}
