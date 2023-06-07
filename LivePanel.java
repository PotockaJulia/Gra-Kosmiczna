package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
//import javax.swing.JFrame;
import javax.swing.JPanel;

public class LivePanel extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;
	
	private BufferedImage image;
	public static int howMany = 3;
	public static int isCollision = 0;
	
	 
 	public LivePanel() {
 		super();
 		//this.setLayout(new GridLayout(1,3));

 		howManyLives();
 
 		Dimension dimension1 = new Dimension(image.getWidth(), image.getHeight());
 		setPreferredSize(dimension1);
 		setBackground(Color.black);
 	}
 	
 	private void howManyLives() {
 		if(howMany == 3) {
	 		File imageFile1 = new File("3zycia.png");
	 		try {
	 			image = ImageIO.read(imageFile1);
	 		} 
	 		catch (IOException e) {
	 			System.err.println("Blad odczytu obrazka");
	 			e.printStackTrace();
	 		}
 		}
 		else if(howMany == 2) {
 			File imageFile1 = new File("2zycia.png");
	 		try {
	 			image = ImageIO.read(imageFile1);
	 		} 
	 		catch (IOException e) {
	 			System.err.println("Blad odczytu obrazka");
	 			e.printStackTrace();
	 		}
 		}
 		else if(howMany == 1) {
 			File imageFile1 = new File("1zycie.png");
	 		try {
	 			image = ImageIO.read(imageFile1);
	 		} 
	 		catch (IOException e) {
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
 	}
 	
 
 	public void paintComponent(Graphics g) {
 		Graphics2D g2d = (Graphics2D) g;
 		g2d.drawImage(image, 0, 0, this);
 		
 		if(VehicleLabel.rveh.intersects(GamePanel.rkom1) || VehicleLabel.rveh.intersects(GamePanel.rkom2)) {
 			isCollision++;
 			//System.out.println(isCollision);
 		}
 		
 		if(isCollision>460) {
 			howMany--;
 			//System.out.println("bum");
 			isCollision = 0;
 		}
 		
 		howManyLives();
 		StartFrame.ifYouAlive();
 		//GamePanel.checkIfIsCollision();
 		repaint();	
 	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
	}


}
