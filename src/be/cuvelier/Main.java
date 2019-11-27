package be.cuvelier;

import be.dao.DAO;
import be.dao.JoueurDao;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Tournoi t = new Tournoi(Tournoi.SIMPLE_FEMME);
		t.inscrireJoueur();
		
			try {
				t.jouer();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
