package be.cuvelier;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import be.dao.DAO;
import be.dao.JoueurDao;
import be.dao.TennisConnection;


public class Ordonnancement {
	private List<Match> matches;
	
	public Ordonnancement(List<Match> matches) {
		setMatches(matches);
	}
	
	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}
	
	public List<Equipe> jouerMatches() {
		List<Equipe> listeEquipe = new ArrayList<Equipe>();
		for (var match : matches ) {
			Equipe equipeGagnante = match.jouerMatch();
			listeEquipe.add(equipeGagnante);
		}	
		return listeEquipe;
	};
	
	
}
