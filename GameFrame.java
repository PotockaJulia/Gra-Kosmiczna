package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;


public class GameFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	public GameFrame() throws HeadlessException {
		int score=0;
		
		JPanel informationsPanel = new JPanel();
		add(informationsPanel, BorderLayout.PAGE_START);
		JPanel lives = new LivePanel();
		JPanel scorePanel = new JPanel();
		JLabel scoreL = new JLabel("wynik: "+score);
		scorePanel.add(scoreL);
		JPanel fuel = new JPanel();
		JLabel fuelL = new JLabel("paliwo");
		fuel.add(fuelL);
		
		informationsPanel.setLayout(new BorderLayout());
		informationsPanel.setBackground(Color.gray);
		informationsPanel.add(lives, BorderLayout.LINE_START);
		informationsPanel.add(scorePanel, BorderLayout.CENTER);
		informationsPanel.add(fuel, BorderLayout.LINE_END);
		
		JPanel heavenPanel = new JPanel();
		heavenPanel.setBackground(Color.black);
		add(heavenPanel);
		
		JPanel vehiclePanel = new JPanel();
		vehiclePanel.setBackground(Color.black);
		vehiclePanel.setPreferredSize(new Dimension(640, 60));
		add(vehiclePanel, BorderLayout.PAGE_END);
		JButton vehicleIcon = new JButton("pojazd");
		vehiclePanel.add(vehicleIcon);
		
		this.setSize(640, 480);
		//this.setLayout(new GridLayout(2,1));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
    }
    public GameFrame(GraphicsConfiguration gc) {
        super(gc);
    }
    public GameFrame(String title) throws HeadlessException {
        super(title);
    }
    public GameFrame(String title, GraphicsConfiguration gc) {
        super(title, gc);
    }

	public static void main(String[] args) {
		GameFrame gameScreen = new GameFrame();
		gameScreen.setVisible(true);
	}
	/*public void showGameFrame() {
		GameFrame gameScreen = new GameFrame();
		gameScreen.setVisible(true);
	}*/
}
