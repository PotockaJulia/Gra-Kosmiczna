package game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import game.VehicleLabel.MovingAdapter;

public class GamePanel extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	
	private BufferedImage backImage;
	private BufferedImage meteoritImage, meteoritImage2;
	int xPos1, yPos1, xPos2, yPos2, vx1, vy1, vx2, vy2;
	
	boolean isWorking = true;
	private BufferedImage image;
	//private BufferedImage backImage;
	private Image smallImage;
	private int lx = 260;
	

	File plane = new File("samolot.png.");
	File ufo = new File("ufo.png.");
	File rocket = new File("rakieta.png.");
	public static int whatVehicle = 1;
	
	
	public GamePanel() {
 		super();
 		
	 	File imageFile1 = new File("tlo.jpg");
	 	try {
			backImage = ImageIO.read(imageFile1);
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
	 	File imageFile3 = new File("kometa2.png");
	 	try {
			meteoritImage2 = ImageIO.read(imageFile3);
	 	} 
	 	catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
	 		e.printStackTrace();
	 	}
	 	
	 	Random r = new Random();
	 	
	 	xPos1 = 620;
	 	xPos2 = -20;
		yPos1 = r.nextInt(30);
		yPos2 = r.nextInt(30);
		//int tmp = r.nextInt();
		vx1 = -(5+r.nextInt(2));
		vy1 = -(3+r.nextInt(2));
		vx2 = (5+r.nextInt(2));
		vy2 = (3+r.nextInt(2));
		
		setLayout(new BorderLayout());
		VehicleLabel vehicleLabel = new VehicleLabel();
		add(vehicleLabel, BorderLayout.PAGE_END);
		
 	}
	
 
 	public void paintComponent(Graphics g) {
 		Graphics2D g2d = (Graphics2D) g;
 		g2d.drawImage(backImage, 0, 0, this);
 		//g2d.drawImage(smallImage, lx, 320, this);
 		
 		//if(ScoreLabel.score == 40) {
			g2d.drawImage(meteoritImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH), xPos1, yPos1, this);
			g2d.drawImage(meteoritImage2.getScaledInstance(50, 50, Image.SCALE_SMOOTH), xPos2, yPos2, this);
 		//}
 	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (isWorking) {
			xPos1+=vx1;
			yPos1-=vy1;
			xPos2+=vx2;
			yPos2+=vx2;
			repaint();
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
