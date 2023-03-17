package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class StartFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	public StartFrame() throws HeadlessException {

		JPanel helloPanel = new JPanel();
		helloPanel.setBackground(Color.black);
		add(helloPanel);//, BorderLayout.CENTER);
		helloPanel.setLayout(new BorderLayout());
		JLabel hello = new JLabel("Space Adventure", JLabel.CENTER);
		hello.setFont(new Font("Serif", Font.PLAIN, 72));
		hello.setForeground(Color.white);
		helloPanel.add(hello, BorderLayout.CENTER);
		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(Color.black);
		helloPanel.add(infoPanel, BorderLayout.PAGE_END);
		JButton infoButton = new JButton("Informacje");
		infoButton.setBackground(Color.cyan);
		infoPanel.add(infoButton);
		
		JPanel vehiclePanel = new JPanel();
		add(vehiclePanel);
		vehiclePanel.setLayout(new GridLayout(3,1));
		
		JPanel vehiclePanel1 = new JPanel();
		JPanel vehiclePanel2 = new JPanel();
		JPanel vehiclePanel3 = new JPanel();
		vehiclePanel1.setBackground(Color.black);
		vehiclePanel2.setBackground(Color.black);
		vehiclePanel3.setBackground(Color.black);
		vehiclePanel.add(vehiclePanel1);
		vehiclePanel.add(vehiclePanel2);
		vehiclePanel.add(vehiclePanel3);
		
		JLabel chooseVehicle = new JLabel("Wybierz pojazd: ", JLabel.CENTER);
		chooseVehicle.setForeground(Color.white);
		JRadioButton choosePlane = new JRadioButton("Samolot");
		JRadioButton chooseUfo = new JRadioButton("Ufo");
		JRadioButton chooseRocket = new JRadioButton("Rakieta");//new ImageIcon("rocket.png"));
		ButtonGroup chooseYourFighter = new ButtonGroup();
		chooseYourFighter.add(choosePlane);
		chooseYourFighter.add(chooseUfo);
		chooseYourFighter.add(chooseRocket);
		
		vehiclePanel1.add(chooseVehicle);
		vehiclePanel3.add(choosePlane);
		vehiclePanel3.add(chooseUfo);
		vehiclePanel3.add(chooseRocket);
		
		JPanel startPanel = new JPanel();
		add(startPanel);
		startPanel.setBackground(Color.black);
		JButton startButton = new JButton("START");
		ActionListener startListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				GameFrame gameScreen = new GameFrame();
				gameScreen.setVisible(true);
			}	
		};
		
		startButton.addActionListener(startListener);
		startButton.setBackground(Color.blue);
		startButton.setForeground(Color.white);
		startButton.setPreferredSize(new Dimension(120, 60));
		//infoButton.addActionListener(infoListener);
		
		startPanel.add(startButton);
		//startPanel.add(infoButton);
		this.setSize(640, 480);
		this.setLayout(new GridLayout(3,1));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
    }
    public StartFrame(GraphicsConfiguration gc) {
        super(gc);
    }
    public StartFrame(String title) throws HeadlessException {
        super(title);
    }
    public StartFrame(String title, GraphicsConfiguration gc) {
        super(title, gc);
    }

	public static void main(String[] args) {
		StartFrame startScreen = new StartFrame();
		startScreen.setVisible(true);
	}

}
