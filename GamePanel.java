package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	
	private BufferedImage image;
	private BufferedImage meteoritImage;
	int xPos, yPos, vx, vy;
	
	boolean isWorking = true;
	
	
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
	 	
	 	File imageFile2 = new File("kometa.png");
	 	try {
			meteoritImage = ImageIO.read(imageFile2);
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

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (isWorking) {
			Random r = new Random();
			xPos = 640;
			yPos = 300+r.nextInt(50);
			//int tmp = r.nextInt();
			vx = -(3+r.nextInt(10));
			vy = -(3+r.nextInt(10));
			
			//jeszcze musi sie pojawiac w losowych momentach
			xPos+=vx;
			yPos+=vy;
			repaint();
			
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
