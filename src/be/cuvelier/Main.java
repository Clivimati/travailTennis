package be.cuvelier;

import be.dao.DAO;
import be.dao.JoueurDao;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tournoi t = new Tournoi();
		
		t.AjouterOrdonnancement(Ordonnancement.SIMPLE_FEMME);
		t.AjouterOrdonnancement(Ordonnancement.SIMPLE_HOMME);
		t.AjouterOrdonnancement(Ordonnancement.MIXTE);
		
		t.Debuter();
		
		System.out.print("End");

	}

}
