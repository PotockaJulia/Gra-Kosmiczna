package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class GamePanel extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	
	private BufferedImage backgroundImage;
	private BufferedImage meteoritImage, meteoritImage2;
	int xPos1, yPos1, xPos2, yPos2, vx1, vy1, vx2, vy2;
	final int xPos10 = 640;
	int yPos10 = 20;
	final int xPos20 = -20;
	int yPos20 = 16;
	
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
	
	
	public GamePanel() {
 		super();
 		setLayout(new BorderLayout());
 		addKeyListener(new StopAdapter());
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
	 	
	 	Random r = new Random();
	 	
	 	
	 	xPos1 = xPos10;
	 	yPos1 = yPos10;
		xPos2 = xPos20;
		yPos2 = yPos20;
		vx1 = -(5+r.nextInt(3));
		vy1 = (5+r.nextInt(3));
		vx2 = (5+r.nextInt(3));
		vy2 = (5+r.nextInt(3));
		
		
		JPanel gapPanel = new JPanel();
		gapPanel.setOpaque(false);
		gapPanel.setLayout(new BorderLayout());
		
		
		resumeButton = new JButton("Wznów");
		resumeButton.setSize(200,80);
		resumeButton.setBackground(Color.blue);
		resumeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gameState = playState;
				stopFrame.setVisible(false);
			}
		});
		
		JPanel infoPanel = new JPanel();
		infoPanel.setOpaque(false);
		JButton stopButton = new JButton();
		ActionListener stopListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//zatrzymanie czasu i wyswietlenie panelu z opcja wznow
				//ta sama funkcjonalnosc przy wcisnieciu przycisku esc!!!
				gameState = pauseState;
				stopFrame = new JFrame();
				stopFrame.setBackground(Color.black);
				stopFrame.add(resumeButton);
				stopFrame.setSize(640, 520);
				stopFrame.setVisible(true);
			}	
		};
		stopButton.addActionListener(stopListener);
		ImageIcon stopIcon = new ImageIcon("stop.png"); // load the image to a imageIcon
		Image imgStop = stopIcon.getImage(); // transform it 
		Image newimgStop = imgStop.getScaledInstance(40, 40, Image.SCALE_SMOOTH); // scale it the smooth way  
		stopIcon = new ImageIcon(newimgStop);  // transform it back  
		stopButton.setIcon(stopIcon);
		stopButton.setPreferredSize(new Dimension(40,40));
		//infoButton.setOpaque(false);
		stopButton.setBackground(Color.black);
		
		MusicPanel musicPanel = new MusicPanel();
		JButton musicButton = new JButton();		
		ActionListener musicListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame musicFrame = new JFrame();
				musicFrame.add(musicPanel);
				musicFrame.setBackground(Color.black);
				musicFrame.setSize(400, 250);
				musicFrame.setVisible(true);
			}	
		};
		musicButton.addActionListener(musicListener);
		
		ImageIcon musicIcon = new ImageIcon("music.png");
		Image imgMusic = musicIcon.getImage(); // transform it 
		Image newimgMusic = imgMusic.getScaledInstance(40, 40, Image.SCALE_SMOOTH); // scale it the smooth way  
		musicIcon = new ImageIcon(newimgMusic);  // transform it back  
		musicButton.setIcon(musicIcon);
		musicButton.setPreferredSize(new Dimension(40,40));
		musicButton.setBackground(Color.black);
		
		infoPanel.add(musicButton);
		infoPanel.add(stopButton);
		gapPanel.add(infoPanel, BorderLayout.LINE_END);
		add(gapPanel, BorderLayout.PAGE_START);
		
		//add(infoPanel, BorderLayout.PAGE_START);
		
		VehicleLabel vehicleLabel = new VehicleLabel();
		add(vehicleLabel, BorderLayout.PAGE_END);
 	}
	
 
 	public void paintComponent(Graphics g) {
 		Graphics2D g2d = (Graphics2D) g;
 		//g2d.drawImage(backImage, 0, 0, this);
 		g2d.drawImage(backgroundImage, 0, 0, this);

		g2d.drawImage(meteoritImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH), xPos1, yPos1, this);
		g2d.drawImage(meteoritImage2.getScaledInstance(50, 50, Image.SCALE_SMOOTH), xPos2, yPos2, this);

 	}

 	public class StopAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			
			if (key == KeyEvent.VK_ESCAPE) { 
				gameState = pauseState;
				stopFrame = new JFrame();
				stopFrame.setBackground(Color.black);
				stopFrame.add(resumeButton);
				stopFrame.setSize(640, 520);
				stopFrame.setVisible(true);
			}
			
			if (key == KeyEvent.VK_LEFT && VehicleLabel.lx > 2) { 
				VehicleLabel.lx-=3;
				repaint();
			}
			if (key == KeyEvent.VK_RIGHT && VehicleLabel.lx < (640-80-2)) { 
				VehicleLabel.lx+=3;
				repaint();
			}
		}
	}
 	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (isWorking) {
			Random r = new Random();
			if(gameState == playState) {
				xPos1+=vx1;
				yPos1+=vy1;
				xPos2+=vx2;
				yPos2+=vx2;
				repaint();
				
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
				
			if(xPos1 <= -1100 || yPos1 >= 1600) {
				xPos1 = xPos10;
				yPos1 = r.nextInt(20);
				vx1 = -(5+r.nextInt(3));
				vy1 = (5+r.nextInt(3));
				
			}
			else if(xPos2 >= 2200 || yPos2 >= 2700) {
				xPos2 = xPos20;
				yPos2 = r.nextInt(20);
				vx2 = (5+r.nextInt(3));
				vy2 = (5+r.nextInt(3));
			}
			
		}
	}
}
