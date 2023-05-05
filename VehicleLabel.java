package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class VehicleLabel extends JLabel{
	private static final long serialVersionUID = 1L;
	
	private BufferedImage image;
	private Image smallImage;

	File plane = new File("samolot.png.");
	File ufo = new File("ufo.png.");
	File rocket = new File("rakieta.png.");
	public static int whatVehicle = 1;

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
	}
	
	public void paintComponent(Graphics g2) {
		Graphics2D g2d = (Graphics2D) g2;
 		g2d.drawImage(smallImage, 0, 0, this);
	}
}