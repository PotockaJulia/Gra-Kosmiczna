package game;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class StartPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private BufferedImage backImage;
	
	
	public StartPanel() {
 		super();
 		
	 	File imageFile1 = new File("tlo.png");
	 	try {
			backImage = ImageIO.read(imageFile1);
	 	} 
	 	catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
	 		e.printStackTrace();
	 	}
 	}
	
 
 	public void paintComponent(Graphics g) {
 		Graphics2D g2d = (Graphics2D) g;
 		g2d.drawImage(backImage, 0, 0, this);
 	}

}
