package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class WinFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	//static WinFrame winScreen = new WinFrame();
	
	public WinFrame() throws HeadlessException {
		JMenuBar menuBar = new JMenuBar();
		JMenu optionMenu = new JMenu("Opcje");
		JMenuItem saveScore = new JMenuItem("Zapisz wynik");
		optionMenu.add(saveScore);
		menuBar.add(optionMenu);
		
		WinPanel winPanel = new WinPanel();
		winPanel.setBackground(Color.black);
		winPanel.setLayout(new GridLayout(4,1));
		add(winPanel);
		JLabel youWin = new JLabel();//"WYGRANA!", JLabel.CENTER);
		youWin.setFont(new Font("Serif", Font.PLAIN, 72));
		youWin.setForeground(Color.white);
		
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
		
		winPanel.add(youWin);
		winPanel.add(scorePanel);
		winPanel.add(playAgainPanel);
		winPanel.add(exitGamePanel);
		
		this.setJMenuBar(menuBar);
		
		ImageIcon logoI = new ImageIcon("ufo.png.");
		Image logo = logoI.getImage(); 
		this.setIconImage(logo);
		
		this.setSize(640, 520);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
    }
    public WinFrame(GraphicsConfiguration gc) {
        super(gc);
    }
    public WinFrame(String title) throws HeadlessException {
        super(title);
    }
    public WinFrame(String title, GraphicsConfiguration gc) {
        super(title, gc);
    }

//	public static void main(String[] args) {
//		WinFrame winScreen = new WinFrame();
//		winScreen.setVisible(true);
//	}
}
