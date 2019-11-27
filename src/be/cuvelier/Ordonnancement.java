package be.cuvelier;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import be.dao.ArbitreDAO;
import be.dao.DAO;
import be.dao.TennisConnection;

public class Ordonnancement {
	private List<Match> matches;
	private Date debut;
	private Date fin;
	
	public Ordonnancement(List<Match> matches,Date debut) {
		setMatches(matches);
		this.debut = debut;
	}
	
	public List<Match> getMatches() {
		return matches;
	}
	
	public Date getDebut() {
		return debut;
	}
	
	public Date getFin() {
		return fin;
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
	
	public void organiserMatch() {	
		System.out.print("DEBUT");
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		int count = 1;
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.debut);
		DAO<Arbitre> jDAO = new ArbitreDAO(TennisConnection.getInstance());
		List<Arbitre> arbitrelist = jDAO.findAll();
		for(var match: matches) {
			if(count <= 2) {
				int rand= new Random().nextInt((4-1)+1)+1;
				Arbitre ar1=arbitrelist.get(rand);
				System.out.print(ar1.nom);
				count++;	
			}else {
				count =1;
				cal.add(Calendar.HOUR_OF_DAY, 2);
				if( !(cal.get(Calendar.HOUR_OF_DAY) <=18) ) {
					cal.add(Calendar.DATE, 1);
					cal.set(Calendar.HOUR_OF_DAY,10);
				}
				
			}
			match.setDate(cal.getTime());
			System.out.println(formatter.format(match.getDate()));
			
		}
		cal.add(Calendar.HOUR_OF_DAY, 2);
		this.fin = cal.getTime();
		System.out.println("FIN");
	}
	
}
