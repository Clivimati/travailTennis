package be.affiche;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import java.awt.BorderLayout;
import java.awt.Button;
import javax.swing.JMenuBar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import be.cuvelier.Tournoi;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainPage {
	
	private Tournoi t;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public JButton createButton(String libel, int type) {
		JButton btn_1 = new JButton(libel);
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Trounoisa f;
				try {
					f = new Trounoisa(new Tournoi(type));
					f.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				frame.dispose();
				
			}
		});
		
		btn_1.setFont(new Font("Arial", Font.BOLD, 11));
		btn_1.setBackground(new Color(255, 215, 0));
		return btn_1;
	}

	/**
	 * Create the application.
	 */
	public MainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 248, 255));
		frame.setBounds(100, 100, 563, 424);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		JButton btn_1;
		btn_1=createButton("Simple Femme", Tournoi.SIMPLE_FEMME);
		menuBar.add(btn_1);
		JButton btn_2;
		btn_2=createButton("Simple Homme", Tournoi.SIMPLE_HOMME);
		menuBar.add(btn_2);
		JButton btn_3;
		btn_3=createButton("Double Femme", Tournoi.DOUBLE_FEMME);
		menuBar.add(btn_3);
		JButton btn_4;
		btn_4=createButton("Double Homme", Tournoi.DOUBLE_HOMME);
		menuBar.add(btn_4);
		JButton btn_5;
		btn_5=createButton("Mixte", Tournoi.MIXTE);
		menuBar.add(btn_5);
		
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Le grand Slam");
		lblNewLabel.setFont(new Font("Haettenschweiler", Font.PLAIN, 66));
		lblNewLabel.setForeground(new Color(95, 158, 160));
		lblNewLabel.setBackground(new Color(173, 216, 230));
		lblNewLabel.setBounds(122, 42, 403, 64);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblBienvenusSurLa = new JLabel("Bienvenus sur la page principal");
		lblBienvenusSurLa.setForeground(new Color(51, 51, 102));
		lblBienvenusSurLa.setBackground(new Color(255, 255, 0));
		lblBienvenusSurLa.setFont(new Font("Arial", Font.BOLD, 16));
		lblBienvenusSurLa.setBounds(139, 133, 270, 19);
		frame.getContentPane().add(lblBienvenusSurLa);
		
		JLabel lblMenu = new JLabel("MENU");
		lblMenu.setBackground(new Color(255, 255, 255));
		lblMenu.setFont(new Font("Arial", Font.BOLD, 41));
		lblMenu.setForeground(new Color(255, 204, 0));
		lblMenu.setBounds(196, 175, 161, 55);
		frame.getContentPane().add(lblMenu);
		
		JLabel lab_1 = new JLabel("");
		lab_1.setBounds(304, 78, 311, 284);
		frame.getContentPane().add(lab_1);
		Image img = new ImageIcon(this.getClass().getResource("/d652b1a5ece16b079c7271631e24a01a.png_wh860.png")).getImage();
		lab_1.setIcon(new ImageIcon(img));
		
	
	}
}
