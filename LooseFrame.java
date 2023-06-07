package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
	static LooseFrame looseScreen = new LooseFrame();
	
	public LooseFrame() throws HeadlessException {
		JMenuBar menuBar = new JMenuBar();
		JMenu optionMenu = new JMenu("Opcje");
		JMenuItem saveScore = new JMenuItem("Zapisz wynik");
		optionMenu.add(saveScore);
		menuBar.add(optionMenu);
		
		
		JPanel winPanel = new JPanel();
		winPanel.setBackground(Color.black);
		winPanel.setLayout(new GridLayout(4,1));
		add(winPanel);
		JLabel youWin = new JLabel("PRZEGRANA!", JLabel.CENTER);
		youWin.setFont(new Font("Serif", Font.PLAIN, 72));
		youWin.setForeground(Color.white);
		
		JLabel yourScore = new JLabel("WYNIK: "+ScoreLabel.score, JLabel.CENTER);
		yourScore.setFont(new Font("Serif", Font.PLAIN, 24));
		yourScore.setForeground(Color.white);
		
		JPanel playAgainPanel = new JPanel();
		JButton playAgainButton = new JButton();
		ActionListener playAgainListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				LivePanel.howMany = 3;
				ScoreLabel.score = 0;
				FuelPanel.counter = 500;
				GameFrame gameScreen = new GameFrame();
				gameScreen.setVisible(true);
				ExecutorService exec = Executors.newFixedThreadPool(3);
				exec.execute(GameFrame.scoreL);
				exec.execute(GameFrame.fuel);
				exec.execute(GameFrame.heavenPanel);
				exec.shutdown();
				looseScreen.setVisible(false);
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
		winPanel.add(yourScore);
		winPanel.add(playAgainPanel);
		winPanel.add(exitGamePanel);
		
		this.setJMenuBar(menuBar);
		
		ImageIcon logoI = new ImageIcon("ufo.png.");
		Image logo = logoI.getImage(); 
		this.setIconImage(logo);
		
		this.setSize(640, 480);
		//this.setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public LooseFrame(GraphicsConfiguration gc) {
        super(gc);
    }
    public LooseFrame(String title) throws HeadlessException {
        super(title);
    }
    public LooseFrame(String title, GraphicsConfiguration gc) {
        super(title, gc);
    }

	public static void main(String[] args) {
		looseScreen.setVisible(true);
	}
}
	
