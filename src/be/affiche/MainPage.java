package be.affiche;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import java.awt.BorderLayout;
import java.awt.Button;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		frame.setBounds(100, 100, 464, 424);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JButton btn_1 = new JButton("New button");
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				SimpleF f = new SimpleF();
				f.setVisible(true);
			}
		});
		menuBar.add(btn_1);
		
		JButton btn_2 = new JButton("New button");
		btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				SimpleH f = new SimpleH();
				f.setVisible(true);
			}
		});
		menuBar.add(btn_2);
		
		JButton btn_3 = new JButton("New button");
		btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			DoubleF f = new DoubleF();
			f.setVisible(true);
			}
		});
		menuBar.add(btn_3);
		
		JButton btn_4 = new JButton("New button");
		btn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				DoubleH f = new DoubleH();
				f.setVisible(true);
			}
		});
		menuBar.add(btn_4);
		
		JButton btn_5 = new JButton("New button");
		btn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Mixte f = new Mixte();
				f.setVisible(true);
			}
		});
		menuBar.add(btn_5);
		frame.getContentPane().setLayout(null);
		
	
	}

}
