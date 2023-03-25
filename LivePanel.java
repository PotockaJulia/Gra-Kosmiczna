package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
//import javax.swing.JFrame;
import javax.swing.JPanel;

public class LivePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private BufferedImage image;
	 
 	public LivePanel() {
 		super();
 		//this.setLayout(new GridLayout(1,3));
 		int howMany = 1;
 		
 		if(howMany == 3) {
	 		File imageFile1 = new File("3zycia.png");
	 		try {
	 			image = ImageIO.read(imageFile1);
	 		} catch (IOException e) {
	 			System.err.println("Blad odczytu obrazka");
	 			e.printStackTrace();
	 		}
 		}
 		else if(howMany == 2) {
 			File imageFile1 = new File("2zycia.png");
	 		try {
	 			image = ImageIO.read(imageFile1);
	 		} catch (IOException e) {
	 			System.err.println("Blad odczytu obrazka");
	 			e.printStackTrace();
	 		}
 		}
 		else if(howMany == 1) {
 			File imageFile1 = new File("1zycie.png");
	 		try {
	 			image = ImageIO.read(imageFile1);
	 		} catch (IOException e) {
	 			System.err.println("Blad odczytu obrazka");
	 			e.printStackTrace();
	 		}
 		}
 		else {
 			File imageFile1 = new File("brakzyc.png");
	 		try {
	 			image = ImageIO.read(imageFile1);
	 		} catch (IOException e) {
	 			System.err.println("Blad odczytu obrazka");
	 			e.printStackTrace();
	 		}
 		}
 		
 
 		Dimension dimension1 = new Dimension(image.getWidth(), image.getHeight());
 		setPreferredSize(dimension1);
 	}
 
 	public void paintComponent(Graphics g) {
 		Graphics2D g2d = (Graphics2D) g;
 		g2d.drawImage(image, 0, 0, this);
 		
 	}


}


