package be.cuvelier;


import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;



public class Tournoi  {

	private List<Ordonnancement> ords;

	public Tournoi() {
		this.ords = new ArrayList<Ordonnancement>();
	}

	public void AjouterOrdonnancement(int type) {
		this.ords.add(new Ordonnancement(type));
	}

	public void Debuter() {
		for(Ordonnancement ord : ords) {
			ord.CreerMatch();
			ord.OrganiserMatch();
		}
	}

}
