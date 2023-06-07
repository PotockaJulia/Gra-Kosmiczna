package game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class VehicleLabel extends JLabel{
	private static final long serialVersionUID = 1L;
	
	private BufferedImage image;
	private Image smallImage;
	public static int lx = 260;
	

	File plane = new File("samolot.png.");
	File ufo = new File("ufo.png.");
	File rocket = new File("rakieta.png.");
	public static int whatVehicle = 1;
	static Rectangle rveh;


	public VehicleLabel() {
		super();

		if(whatVehicle == 1) {
	 		try {
	 			image = ImageIO.read(plane);
	 		} 
	 		catch (IOException e) {
	 			System.err.println("Blad odczytu obrazka");
	 			e.printStackTrace();
	 		}
 		}
 		else if(whatVehicle == 2) {
	 		try {
	 			image = ImageIO.read(ufo);
	 		} 
	 		catch (IOException e) {
	 			System.err.println("Blad odczytu obrazka");
	 			e.printStackTrace();
	 		}
 		}
 		else if(whatVehicle == 3) {// || StartFrame.whatVehicle == 0) {
	 		try {
	 			image = ImageIO.read(rocket);
	 		} 
	 		catch (IOException e) {
	 			System.err.println("Blad odczytu obrazka");
	 			e.printStackTrace();
	 		}
 		}
 		else {
 			System.out.println("Błąd wyboru pojazdu!");//zmienic na okno dialogowe błędu
 		}
		smallImage = image.getScaledInstance(80,  80, Image.SCALE_SMOOTH);
		Dimension dimension1 = new Dimension(80, 80);
 		setPreferredSize(dimension1);
 		
 		setBackground(new Color(0,0,0,65));//prawie transparentne
 		//setBackground(Color.blue);
	}
	
	public void paintComponent(Graphics g2) {
		Graphics2D g2d = (Graphics2D) g2;
 		g2d.drawImage(smallImage, lx, 0, this);
 		rveh = new Rectangle(lx, this.getY(), 80, 80);

	}
}
