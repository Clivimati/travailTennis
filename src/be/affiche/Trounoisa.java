package be.affiche;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import be.cuvelier.Equipe;
import be.cuvelier.Joueur;
import be.cuvelier.Match;
import be.cuvelier.Ordonnancement;
import be.cuvelier.Tournoi;

public class Trounoisa extends JFrame {

	private JPanel contentPane;
	private Tournoi tour;
	/**
	 * Launch the application.
	 */
	public Trounoisa(Tournoi tour) {
		this.tour=tour;
		try {
			this.tour.ajouterOrd();
			this.tour.jouer();
			Affichage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Create the frame.
	 */
	public Trounoisa() {
		getContentPane().setBackground(new Color(240, 248, 255));}
	
	public void Affichage() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setContentPane(contentPane);
		 
		List<Ordonnancement> ords= this.tour.getOrds();
		getContentPane().setLayout(new GridLayout(0, ords.size(), 0, 0));
		for(Ordonnancement ord : ords) {
			
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(ord.getMatches().size(), 0, 0, 0));
		
		List<Match> match = ord.getMatches(); 
		for(Match m : match) {
			
			Equipe vainc=m.recuperVainqueurMatch();
			Equipe perd=m.recuperPerdantMatch();
			JPanel panel2 = new JPanel();
			panel2.setLayout(new GridLayout(3, 0, 0, 0));
			panel.add(panel2);
			String labelvainceur= vainc.toString();
			String labelperdant=perd.toString();
			
			JLabel lblvainc = new JLabel(labelvainceur);
				panel2.add(lblvainc);
				lblvainc.setForeground(Color.green);
				JLabel labelscore = new JLabel(m.getScore());
				panel2.add(labelscore );
				
				JLabel label2= new JLabel(labelperdant);
				panel2.add(label2);
				label2.setForeground(Color.RED);
				
		}
		
		}
		
	}

}
