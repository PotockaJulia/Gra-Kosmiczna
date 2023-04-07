package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GameFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	Image img = Toolkit.getDefaultToolkit().getImage("tlo.jpg");
	File downpanel = new File("tlo.jpg");
	File plane = new File("samolot.png");
	File ufo = new File("ufo.png");
	File rocket = new File("rakieta.png");
	public static int whatVehicle = 1;
	public static int score=0;
	//BufferedImage planeB;
	//BufferedImage ufoB;
	//BufferedImage rocketB;
	private BufferedImage vehicleImage;
	
	public GameFrame() throws HeadlessException {
		

		JPanel informationsPanel = new JPanel();
		add(informationsPanel, BorderLayout.PAGE_START);
		JPanel lives = new LivePanel();
		JPanel scorePanel = new JPanel();
		JLabel scoreL = new JLabel("wynik: "+score);
		scorePanel.add(scoreL);
		JPanel fuel = new FuelPanel();
		
		informationsPanel.setLayout(new BorderLayout());
		informationsPanel.setBackground(Color.gray);
		informationsPanel.add(lives, BorderLayout.LINE_START);
		informationsPanel.add(scorePanel, BorderLayout.CENTER);
		informationsPanel.add(fuel, BorderLayout.LINE_END);
		
		JPanel heavenPanel = new GamePanel();
		add(heavenPanel);

		
		/*if(whatVehicle == 1) {
	 		try {
	 			vehicleImage = ImageIO.read(plane);
	 		} 
	 		catch (IOException e) {
	 			System.err.println("Blad odczytu obrazka");
	 			e.printStackTrace();
	 		}
 		}
 		else if(whatVehicle == 2) {
	 		try {
	 			vehicleImage = ImageIO.read(ufo);
	 		} 
	 		catch (IOException e) {
	 			System.err.println("Blad odczytu obrazka");
	 			e.printStackTrace();
	 		}
 		}
 		else if(whatVehicle == 3) {// || StartFrame.whatVehicle == 0) {
	 		try {
	 			vehicleImage = ImageIO.read(rocket);
	 		} 
	 		catch (IOException e) {
	 			System.err.println("Blad odczytu obrazka");
	 			e.printStackTrace();
	 		}
 		}
 		else {
 			System.out.println("Błąd wyboru pojazdu!");//zmienic na okno dialogowe błędu
 		}*/
		
		JPanel vehiclePanel = new GamePanel();
//		JLabel vehicleLabel = new JLabel() {
//			private static final long serialVersionUID = 1L;
//			@Override
//			protected void paintComponent(Graphics g) {
//				Graphics2D g2d = (Graphics2D) g;
//		 		g2d.drawImage(vehicleImage, 0, 0, this);
//			}
//		};
		JLabel vehicleLabel = new VehicleLabel();
		vehiclePanel.add(vehicleLabel);
		vehiclePanel.setPreferredSize(new Dimension(640, 80));
		
		//JLabel label = new JLabel("pojazd");
		//vehiclePanel.add(label);
		add(vehiclePanel, BorderLayout.PAGE_END);
		
		this.setSize(640, 480);
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
	
}
