package game;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class GamePanel extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	
	private BufferedImage backgroundImage;
	private BufferedImage meteoritImage, meteoritImage2, fuelImage;
	private BufferedImage MarsImage, JowiszImage, SaturnImage, UranImage, NeptunImage;
	static int yPos1,  yPos2,  fyPos, MyPos, JyPos, SyPos, UyPos, NyPos;
	int xPos1, xPos2, vx1, vy1, vx2, vy2;
	int fxPos, fvy;
	int MxPos, JxPos, SxPos, UxPos, NxPos, Mvy, Jvy, Svy, Uvy, Nvy;
	final int xPos10 = 620;
	int yPos10 = 2;
	final int xPos20 = -20;
	int yPos20 = 16;
	static Rectangle rkom1;
	static Rectangle rkom2;
	static Rectangle rfuel, rMars, rJowisz, rSaturn, rUran, rNeptun;
	public static int isCollision1 = 0;
	public static int isCollision2 = 0;
	public static int catchFuel = 0;
	public static int planetCollision = 0;
	
	boolean isWorking = true;
	//private int lx = 260;
	static boolean kom1 = false;

	File plane = new File("samolot.png.");
	File ufo = new File("ufo.png.");
	File rocket = new File("rakieta.png.");
	public static int whatVehicle = 1;
	
	static int gameState = 0;
	static int pauseState = 1;
	static int playState = 2;
	JFrame stopFrame;
	JButton resumeButton;
	static JFrame pauseFrame;
	MusicPanel musicPanel = new MusicPanel();
	JFrame musicFrame = new JFrame();
	
	
	
	public GamePanel() {
 		super();
 		setLayout(new BorderLayout());
 		addKeyListener(new KlikAdapter());
 		setFocusable(true);
 		
 		gameState = playState;
 		
	 	File imageFile1 = new File("tlo.jpg");
	 	try {
	 		backgroundImage = ImageIO.read(imageFile1);
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
	 	File imageFile4 = new File("paliwo.png");
	 	try {
			fuelImage = ImageIO.read(imageFile4);
	 	} 
	 	catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
	 		e.printStackTrace();
	 	}
	 	File imageFile5 = new File("mars.png");
	 	try {
			MarsImage = ImageIO.read(imageFile5);
	 	} 
	 	catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
	 		e.printStackTrace();
	 	}
	 	File imageFile6 = new File("jowisz.png");
	 	try {
			JowiszImage = ImageIO.read(imageFile6);
	 	} 
	 	catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
	 		e.printStackTrace();
	 	}
	 	File imageFile7 = new File("saturn.png");
	 	try {
			SaturnImage = ImageIO.read(imageFile7);
	 	} 
	 	catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
	 		e.printStackTrace();
	 	}
	 	File imageFile8 = new File("uran.png");
	 	try {
			UranImage = ImageIO.read(imageFile8);
	 	} 
	 	catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
	 		e.printStackTrace();
	 	}
	 	File imageFile9 = new File("neptun.png");
	 	try {
			NeptunImage = ImageIO.read(imageFile9);
	 	} 
	 	catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
	 		e.printStackTrace();
	 	}
	 	
	 	
	 	Random r = new Random();
	 	
	 	
	 	xPos1 = xPos10;
	 	yPos1 = yPos10;
		xPos2 = xPos20;
		yPos2 = yPos20;
		vx1 = -(5+r.nextInt(3));
		vy1 = (5+r.nextInt(3));
		vx2 = (5+r.nextInt(3));
		vy2 = (5+r.nextInt(3));
		
		fyPos = -600;
		fxPos =20+r.nextInt(580);
		fvy = (2+r.nextInt(3));
		
		
		MyPos = -1200;
		MxPos = r.nextInt(520);
		Mvy = (3+r.nextInt(3));
		JyPos = 550;
		JxPos = r.nextInt(460);
		Jvy = (4+r.nextInt(3));
		SyPos = 550;
		SxPos = r.nextInt(460);
		Svy = (4+r.nextInt(3));
		UyPos = 550;
		UxPos = r.nextInt(500);
		Uvy = (4+r.nextInt(3));
		NyPos = 550;
		NxPos = r.nextInt(500);
		Nvy = (4+r.nextInt(3));
		
		VehicleLabel vehicleLabel = new VehicleLabel();
		add(vehicleLabel, BorderLayout.PAGE_END);
 	}
 	
 	
 	
 	
 	public void paintComponent(Graphics g) {
 		setPlanetPos();
 		Graphics2D g2d = (Graphics2D) g;
 		//g2d.drawImage(backImage, 0, 0, this);
 		g2d.drawImage(backgroundImage, 0, 0, this);

		g2d.drawImage(meteoritImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH), xPos1, yPos1, this);
		g2d.drawImage(meteoritImage2.getScaledInstance(50, 50, Image.SCALE_SMOOTH), xPos2, yPos2, this);
		g2d.drawImage(fuelImage.getScaledInstance(40, 40, Image.SCALE_SMOOTH), fxPos, fyPos, this);
		
		if(ScoreLabel.score >=78 && ScoreLabel.score<=400)
			g2d.drawImage(MarsImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH), MxPos, MyPos, this);
		else if (ScoreLabel.score >= 628 && ScoreLabel.score <= 1100)
			g2d.drawImage(JowiszImage.getScaledInstance(180, 180, Image.SCALE_SMOOTH), JxPos, JyPos, this);
		else if (ScoreLabel.score >= 1276 && ScoreLabel.score <= 1800)
			g2d.drawImage(SaturnImage.getScaledInstance(200, 80, Image.SCALE_SMOOTH), SxPos, SyPos, this);
		else if (ScoreLabel.score >= 2718 && ScoreLabel.score <= 3200)
			g2d.drawImage(UranImage.getScaledInstance(120, 120, Image.SCALE_SMOOTH), UxPos, NyPos, this);
		else if (ScoreLabel.score >= 4344 && ScoreLabel.score <= 4800)
			g2d.drawImage(NeptunImage.getScaledInstance(120, 120, Image.SCALE_SMOOTH), NxPos, NyPos, this);

		
		rkom1 = new Rectangle(xPos1, yPos1, 50, 50);
		rkom2 = new Rectangle(xPos2, yPos2, 50, 50);
		rfuel = new Rectangle(fxPos, fyPos, 40, 40);
		rMars = new Rectangle(MxPos, MyPos, 100, 100);
		rJowisz = new Rectangle(JxPos, JyPos, 180, 180);
		rSaturn = new Rectangle(SxPos, SyPos, 200, 80);
		rUran = new Rectangle(UxPos, UyPos, 120, 120);
		rNeptun = new Rectangle(NxPos, NyPos, 120, 120);
 		
 		//checkIfIsCollision();
 	}
 	
 	private void setPlanetPos() {
 		if(ScoreLabel.score==78) MyPos = -140;
 		else if(ScoreLabel.score == 628) JyPos = -180;
 		else if(ScoreLabel.score == 1276) SyPos = -200;
 		else if(ScoreLabel.score == 2718) UyPos = -120;
 		else if(ScoreLabel.score == 4344) NyPos = -120;
 	}
 	
 	public static void Collision() {
 		if(VehicleLabel.rveh.intersects(rkom1)) {
 			isCollision1++;
 			//System.out.println(isCollision);
 		}
 		else if( VehicleLabel.rveh.intersects(rkom2)) {
 			isCollision2++;
 		}
 		if( VehicleLabel.rveh.intersects(rfuel)) {
 			catchFuel++;
 		}
 		
 		if( VehicleLabel.rveh.intersects(rMars)) planetCollision++;
 		else if( VehicleLabel.rveh.intersects(rJowisz)) planetCollision++;
 		else if( VehicleLabel.rveh.intersects(rSaturn)) planetCollision++;
 		else if( VehicleLabel.rveh.intersects(rUran)) planetCollision++;
 		else if( VehicleLabel.rveh.intersects(rNeptun)) planetCollision++;
 
 		
 		if(isCollision1>15) {
 			LivePanel.howMany--;
 			yPos1 = 600; 
 			//System.out.println("bum");
 			isCollision1 = 0;
 		}
 		else if(isCollision2>15) {
 			LivePanel.howMany--;
 			yPos2 = 600; 
 			//System.out.println("bum");
 			isCollision2 = 0;
 		}
 		if(catchFuel>10) {
 			FuelPanel.counter+=50;
 			fyPos = 1000;
 			catchFuel=0;
 		}
 		if(planetCollision>8) {
 			LivePanel.howMany--;
 			MyPos = 600;
 			JyPos = 600;
 			SyPos = 600;
 			UyPos = 600;
 			NyPos = 600;
 			//System.out.println("kraksa!");
 			planetCollision=0;
 			
 		}
 	}


 	public class KlikAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			
			if (key == KeyEvent.VK_ESCAPE) { 
				gameState = pauseState;
				pauseFrame = new JFrame();
				pauseFrame.setSize(640,520);
				PausePanel pausePanel = new PausePanel();
				pauseFrame.add(pausePanel);
				pauseFrame.setVisible(true);
			}
			
			if (key == KeyEvent.VK_LEFT && VehicleLabel.lx > 2) { 
				VehicleLabel.lx-=4;
				repaint();
			}
			else if (key == KeyEvent.VK_RIGHT && VehicleLabel.lx < (640-80-2)) { 
				VehicleLabel.lx+=4;
				repaint();
			}
			if(key == KeyEvent.VK_M) {
//				JFrame musicFrame = new JFrame();
//				musicPanel = new MusicPanel();
				musicFrame.add(musicPanel);
				musicFrame.setBackground(Color.black);
				musicFrame.setSize(400, 250);
				musicFrame.setVisible(true);
			}
		}
	}
 	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (isWorking) {
			//meteoryty i paliwo
			int v = 5;
			if(ScoreLabel.score > 1200) v=3;
			else if(ScoreLabel.score > 2800) v=5;
			else if(ScoreLabel.score > 4000) v=8;
			
			Random r = new Random();
			if(gameState == playState) {
				xPos1+=vx1;
				yPos1+=vy1;
				xPos2+=vx2;
				yPos2+=vx2;
				fyPos+=fvy;
				MyPos+=Mvy;
				JyPos+=Jvy;
				SyPos+=Svy;
				UyPos+=Uvy;
				NyPos+=Nvy;
				repaint();
				
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
				
			if(xPos1 <= -3600 || yPos1 >= 3200) {
				xPos1 = xPos10;
				yPos1 = r.nextInt(14);
				vx1 = -(v+r.nextInt(3));
				vy1 = (v+r.nextInt(3));
				
			}
			else if(xPos2 >= 4200 || yPos2 >= 3800) {
				xPos2 = xPos20;
				yPos2 = r.nextInt(10);
				vx2 = (v+r.nextInt(3));
				vy2 = (v+r.nextInt(3));
			}
			else if(fyPos >= 2800) {
				fyPos= -200;
				fxPos =20+r.nextInt(560);
				fvy = (2+r.nextInt(2));
			}
		}
	}
}
