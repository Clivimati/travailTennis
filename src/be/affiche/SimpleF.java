package be.affiche;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.cuvelier.Tournoi;

import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;

public class SimpleF extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleF frame = new SimpleF();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SimpleF() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 410);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		Panel panel = new Panel();
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		

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
