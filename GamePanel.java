package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private BufferedImage image;
	
	public GamePanel() {
 		super();
 		
	 	File imageFile1 = new File("tlo.jpg");
	 	try {
			image = ImageIO.read(imageFile1);
	 	} 
	 	catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
	 		e.printStackTrace();
	 	}
 		
 	}
 
 	public void paintComponent(Graphics g) {
 		Graphics2D g2d = (Graphics2D) g;
 		g2d.drawImage(image, 0, 0, this);
 	}
}
