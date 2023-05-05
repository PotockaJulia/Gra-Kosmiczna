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
	//public static int score=0;
	//BufferedImage planeB;
	//BufferedImage ufoB;
	//BufferedImage rocketB;
	//private BufferedImage vehicleImage;
	static ScoreLabel scoreL;
	
	public GameFrame() throws HeadlessException {

		JPanel informationsPanel = new JPanel();
		add(informationsPanel, BorderLayout.PAGE_START);
		JPanel lives = new LivePanel();
		JPanel scorePanel = new JPanel();
		scoreL = new ScoreLabel();
		scorePanel.add(scoreL);
		//add(scorePanel);
		JPanel fuel = new FuelPanel();
		
		informationsPanel.setLayout(new BorderLayout());
		informationsPanel.setBackground(Color.gray);
		informationsPanel.add(lives, BorderLayout.LINE_START);
		informationsPanel.add(scorePanel, BorderLayout.CENTER);
		informationsPanel.add(fuel, BorderLayout.LINE_END);
		
		JPanel heavenPanel = new GamePanel();
		add(heavenPanel);
		
		this.setSize(640, 480);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
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
		// TODO Auto-generated method stub
		/*while (true) {
			score+=1;

			//setBackground(color[i]);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}*/
	}
    

	public static void main(String[] args) {
		GameFrame gameScreen = new GameFrame();
		gameScreen.setVisible(true);
		
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
		}, 300, SECONDS);*/
		
		ExecutorService exec = Executors.newFixedThreadPool(3);

		exec.execute(scoreL);

		exec.shutdown();
	}
	
	
}
