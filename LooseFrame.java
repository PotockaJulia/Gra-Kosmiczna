package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		JLabel yourScore = new JLabel("WYNIK: "+GameFrame.score, JLabel.CENTER);
		yourScore.setFont(new Font("Serif", Font.PLAIN, 24));
		yourScore.setForeground(Color.white);
		
		JPanel playAgainPanel = new JPanel();
		JButton playAgainButton = new JButton("SPROBUJ JESZCZE RAZ");
		ActionListener playAgainListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				GameFrame gameScreen = new GameFrame();
				gameScreen.setVisible(true);
				looseScreen.setVisible(false);
			}	
		};
		playAgainButton.addActionListener(playAgainListener);
		playAgainButton.setBackground(Color.blue);
		playAgainButton.setForeground(Color.white);
		playAgainButton.setPreferredSize(new Dimension(180, 60));
		playAgainPanel.add(playAgainButton);
		playAgainPanel.setBackground(Color.black);

		JPanel exitGamePanel = new JPanel();
		JButton exitGameButton = new JButton("ZAKONCZ");
		playAgainPanel.add(playAgainButton);
		ActionListener exitGameListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}	
		};
		exitGameButton.addActionListener(exitGameListener);
		exitGameButton.setBackground(Color.red);
		exitGameButton.setForeground(Color.white);
		exitGameButton.setPreferredSize(new Dimension(120, 40));
		exitGamePanel.add(exitGameButton);
		exitGamePanel.setBackground(Color.black);
		
		winPanel.add(youWin);
		winPanel.add(yourScore);
		winPanel.add(playAgainPanel);
		winPanel.add(exitGamePanel);
		this.setJMenuBar(menuBar);
		
		this.setSize(640, 480);
		//this.setLayout(new BorderLayout());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
	

	
