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
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainPage {

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
		
		JButton btn_1 = new JButton("Simple Femme");
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleF f = new SimpleF();
				f.setVisible(true);
				frame.dispose();
			}
		});
		
		btn_1.setFont(new Font("Arial", Font.BOLD, 11));
		btn_1.setBackground(new Color(255, 215, 0));
		
		menuBar.add(btn_1);
		
		JButton btn_2 = new JButton("Simple Homme");
		btn_2.setBackground(new Color(173, 216, 230));
		btn_2.setFont(new Font("Arial", Font.BOLD, 11));
		btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				SimpleH f = new SimpleH();
				f.setVisible(true);
			}
		});
		menuBar.add(btn_2);
		
		JButton btn_3 = new JButton("Double Femme");
		btn_3.setBackground(new Color(255, 215, 0));
		btn_3.setFont(new Font("Arial", Font.BOLD, 11));
		btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			DoubleF f = new DoubleF();
			f.setVisible(true);
			}
		});
		menuBar.add(btn_3);
		
		JButton btn_4 = new JButton("Double Homme");
		btn_4.setBackground(new Color(173, 216, 230));
		btn_4.setFont(new Font("Arial", Font.BOLD, 11));
		btn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				DoubleH f = new DoubleH();
				f.setVisible(true);
			}
		});
		menuBar.add(btn_4);
		
		JButton btn_5 = new JButton("Double Mixte");
		btn_5.setBackground(new Color(173, 216, 230));
		btn_5.setFont(new Font("Arial", Font.BOLD, 11));
		btn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Mixte f = new Mixte();
				f.setVisible(true);
			}
		});
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
