package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class LooseFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private BufferedImage backgroundImage;
	JPanel loosePanel;
	//static LooseFrame looseScreen = new LooseFrame();
	
	public LooseFrame() throws HeadlessException {
		JMenuBar menuBar = new JMenuBar();
		JMenu optionMenu = new JMenu("Opcje");
		JMenuItem saveScore = new JMenuItem("Zapisz wynik");
		optionMenu.add(saveScore);
		menuBar.add(optionMenu);
		
		
		loosePanel = new LoosePanel();
		loosePanel.setBackground(Color.black);
		loosePanel.setLayout(new GridLayout(4,1));
		add(loosePanel);
		
		JLabel youLoose = new JLabel();//"PRZEGRANA!", JLabel.CENTER);
		youLoose.setFont(new Font("Serif", Font.PLAIN, 72));
		youLoose.setForeground(Color.white);
		
		JPanel scorePanel = new JPanel();
		scorePanel.setLayout(new BorderLayout());
		scorePanel.setOpaque(false);
		JLabel yourScore = new JLabel("WYNIK: "+ScoreLabel.score, JLabel.CENTER);
		yourScore.setBounds(50, 50, yourScore.getWidth(), yourScore.getHeight());
		yourScore.setFont(new Font("Serif", Font.PLAIN, 24));
		yourScore.setForeground(Color.white);
		scorePanel.add(yourScore, BorderLayout.PAGE_END);
		
		JPanel playAgainPanel = new JPanel();
		playAgainPanel.setOpaque(false);
		JButton playAgainButton = new JButton();
		ActionListener playAgainListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				LivePanel.howMany = 3;
				ScoreLabel.score = 0;
				FuelPanel.counter = 500;
				StartFrame.looseScreen.setVisible(false);
				StartFrame.gameScreen.setVisible(true);
				
			}	
		};
		playAgainButton.addActionListener(playAgainListener);
		ImageIcon playAgainIcon = new ImageIcon("playAgain.png.");
		Image imgPlayAgain = playAgainIcon.getImage();
		Image newimgPlayAgain = imgPlayAgain.getScaledInstance(300, 100, Image.SCALE_SMOOTH);
		playAgainIcon = new ImageIcon(newimgPlayAgain);  
		playAgainButton.setIcon(playAgainIcon);
		playAgainButton.setForeground(Color.white);
		playAgainButton.setPreferredSize(new Dimension(300,100));
		playAgainPanel.add(playAgainButton);
		playAgainPanel.setBackground(Color.black);

		JPanel exitGamePanel = new JPanel();
		exitGamePanel.setOpaque(false);
		JButton exitGameButton = new JButton();
		playAgainPanel.add(playAgainButton);
		ActionListener exitGameListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}	
		};
		exitGameButton.addActionListener(exitGameListener);
		exitGameButton.setBackground(Color.red);
		ImageIcon exitIcon = new ImageIcon("exit.png.");
		Image imgExit = exitIcon.getImage();
		Image newimgExit = imgExit.getScaledInstance(200, 60, Image.SCALE_SMOOTH);
		exitIcon = new ImageIcon(newimgExit);  
		exitGameButton.setIcon(exitIcon);
		exitGameButton.setForeground(Color.white);
		exitGameButton.setPreferredSize(new Dimension(200,60));
		exitGamePanel.add(exitGameButton);
		exitGamePanel.setBackground(Color.black);
		
		loosePanel.add(youLoose);
		loosePanel.add(scorePanel);
		loosePanel.add(playAgainPanel);
		loosePanel.add(exitGamePanel);
		
		this.setJMenuBar(menuBar);
		
		ImageIcon logoI = new ImageIcon("ufo.png.");
		Image logo = logoI.getImage(); 
		this.setIconImage(logo);
		
		this.setSize(640, 520);
		//this.setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void paintComponent(Graphics g) {
 		Graphics2D g2d = (Graphics2D) g;
 		g2d.drawImage(backgroundImage.getScaledInstance(640, 520, Image.SCALE_SMOOTH), 0, 0, this);

 	}

//	public static void main(String[] args) {
//		LooseFrame looseScreen = new LooseFrame();
//		looseScreen.setVisible(true);
//	}
}
