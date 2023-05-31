package game;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GameFrame extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;
	Image img = Toolkit.getDefaultToolkit().getImage("tlo.jpg");
	File downpanel = new File("tlo.jpg");
	File plane = new File("samolot.png");
	File ufo = new File("ufo.png");
	File rocket = new File("rakieta.png");
	public static int whatVehicle = 1;
	static ScoreLabel scoreL;
	static GameFrame gameScreen; 
	static GamePanel heavenPanel;
	static FuelPanel fuel;
	
	
	public GameFrame() throws HeadlessException {

		JPanel informationsPanel = new JPanel();
		add(informationsPanel, BorderLayout.PAGE_START);
		JPanel lives = new LivePanel();
		JPanel scorePanel = new JPanel();
		scoreL = new ScoreLabel();
		scorePanel.add(scoreL);
		//add(scorePanel);
		fuel = new FuelPanel();
		
		informationsPanel.setLayout(new BorderLayout());
		informationsPanel.setBackground(Color.gray);
		informationsPanel.add(lives, BorderLayout.LINE_START);
		informationsPanel.add(scorePanel, BorderLayout.CENTER);
		informationsPanel.add(fuel, BorderLayout.LINE_END);
		
		heavenPanel = new GamePanel();
		add(heavenPanel);
		
		ImageIcon logoI = new ImageIcon("ufo.png.");
		Image logo = logoI.getImage(); 
		this.setIconImage(logo);
		
		this.setSize(640, 520);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	
    public GameFrame(GraphicsConfiguration gc) {
        super(gc);
    }
    public GameFrame(String title) throws HeadlessException {
        super(title);
    }
    public GameFrame(String title, GraphicsConfiguration gc) {
        super(title, gc);
    }
    
    @Override
	public void run() {

	}
    

	public static void main(String[] args) {
		gameScreen = new GameFrame();
		gameScreen.setVisible(true);
		if(ScoreLabel.score == 4344) {
			gameScreen.setVisible(false);
			WinFrame winScreen = new WinFrame();
			winScreen.setVisible(true);
		}
		
		//GameFrame r1=new ();    
        //Thread t1 =new Thread(gameScreen);    
        // this will call run() method   
        //t1.run();    
		/*final ScheduledExecutorService scheduler = 
			       Executors.newScheduledThreadPool(2);
			scheduler.schedule(new Runnable() {
	         @Override
				public void run() { 
	         //System.out.println("Koniec programu po 20 sekundach"); 
	         scheduler.shutdownNow();
	         //System.exit(0);
	         gameScreen.setVisible(false);
	         WinFrame winFrame = new WinFrame();
	         winFrame.setVisible(true);
	         }
		}, 284, SECONDS);*/
		
		ExecutorService exec = Executors.newFixedThreadPool(3);

		exec.execute(scoreL);
		exec.execute(heavenPanel);
		exec.execute(fuel);

		exec.shutdown();
		
		
	}
	
	
}
