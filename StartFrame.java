package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.imageio.ImageIO;
import javax.swing.*;


public class StartFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;

	static StartFrame startScreen = new StartFrame();
	
	static Music music = new Music(true);
	JPanel helloPanel;
	StartPanel startPanel;
	
	String startOrStop;
	//private BufferedImage backImage;
	
	public StartFrame() throws HeadlessException {
		
		this.setSize(640, 520);
		//this.setLayout(new GridLayout(3,1));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu musicMenu = new JMenu("MUSIC");
		JMenuItem stopAudio = new JMenuItem("STOP");
		stopAudio.addActionListener(e->{
			try {
				music.stop();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		JMenuItem playAudio = new JMenuItem("PLAY");
		playAudio.addActionListener(e->{
			try {
				music.play();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		JMenu volume = new JMenu("VOLUME");
		JSlider sliderVolume = new JSlider(JSlider.HORIZONTAL, 0, 5, 3);
		sliderVolume.setMajorTickSpacing(1);
		sliderVolume.setMinorTickSpacing(1);
	//	sliderVolume.addChangeListener(e->music.setVolume(sliderVolume.getVolume()));
	//	sliderVolume.setPaintTicks(true);
	//	sliderVolume.setPaintLabels(true);
	//	sliderVolume.add
		volume.add(sliderVolume);
		musicMenu.add(stopAudio);
		musicMenu.add(playAudio);
		musicMenu.add(volume);
		menuBar.add(musicMenu);
		this.setJMenuBar(menuBar);
		
		//Image logo = new ImageIcon(this.getClass().getResource("ufo.png")).getImage();
		ImageIcon logoI = new ImageIcon("ufo.png.");
		Image logo = logoI.getImage(); 
		this.setIconImage(logo);
		
		startPanel = new StartPanel();
		startPanel.setLayout(new GridLayout(2,1));
		add(startPanel);
		
		JPanel gapPanel = new JPanel();
		gapPanel.setOpaque(false);
		gapPanel.setLayout(new BorderLayout());
		
		JPanel infoPanel = new JPanel();
		infoPanel.setOpaque(false);
		JButton infoButton = new JButton();
		ActionListener infoListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, 
						"1. Wybierz pojazd\n"
						+ "2. Uruchom grę poprzez klikniecie przycisku START\n"
						+ "3. Gra:\n"
						+ "  Sterowanie pojazdem przy pomocy strzałek prawo lewo\n"
						+ "  Zderzenie z planetą lub meteorytem powoduje utratę życia\n"
						+ "  Złapanie baniaka z paliwem zwiększa poziom paliwa\n"
						+ "4. Gra kończy się po utracie 3 żyć, przy braku paliwa, bądz przy opuszczenu Układu Słonecznego\n"
						+ "5. Zapisz swój wynik\n"
						+ "6. Zagraj ponownie lub zamknij grę.", 
						"Informacje", JOptionPane.INFORMATION_MESSAGE, null);
			}	
		};
		infoButton.addActionListener(infoListener);
		ImageIcon infoIcon = new ImageIcon("info.png"); // load the image to a imageIcon
		Image imgInfo = infoIcon.getImage(); // transform it 
		Image newimgInfo = imgInfo.getScaledInstance(40, 40, Image.SCALE_SMOOTH); // scale it the smooth way  
		infoIcon = new ImageIcon(newimgInfo);  // transform it back  
		infoButton.setIcon(infoIcon);
		infoButton.setPreferredSize(new Dimension(40,40));
		//infoButton.setOpaque(false);
		infoButton.setBackground(Color.black);
		
		MusicPanel musicPanel = new MusicPanel();
		JButton musicButton = new JButton();		
		ActionListener musicListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//przerobic!!!
				JOptionPane.showMessageDialog(null, musicPanel, "Muzyka", JOptionPane.INFORMATION_MESSAGE, null);
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
		infoPanel.add(infoButton);
		
		gapPanel.add(infoPanel, BorderLayout.LINE_END);
		startPanel.add(gapPanel);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setOpaque(false);
		mainPanel.setLayout(new GridLayout(2,1));
		startPanel.add(mainPanel);
		
		JPanel vehiclePanel = new JPanel();
		vehiclePanel.setOpaque(false);
		vehiclePanel.setLayout(new BorderLayout());
		mainPanel.add(vehiclePanel);
		
		JPanel vehiclePanel1 = new JPanel();
		vehiclePanel1.setOpaque(false);//.setBackground(Color.black);
		
		//vehiclePanel1.setLayout(null);
		vehiclePanel1.setPreferredSize(new Dimension(640, 30));
		vehiclePanel.add(vehiclePanel1, BorderLayout.PAGE_START);
		
		JLabel chooseVehicle = new JLabel("Wybierz pojazd: ", JLabel.CENTER);
		chooseVehicle.setForeground(Color.white);
		chooseVehicle.setPreferredSize(new Dimension(640, 30));
		vehiclePanel1.add(chooseVehicle);
		
		JPanel vehiclePanel2 = new JPanel();
		vehiclePanel2.setOpaque(false);//.setBackground(new Color(0,0,0,65));
		vehiclePanel.add(vehiclePanel2);//, BorderLayout.CENTER);
		//vehiclePanel2.setPreferredSize(new Dimension(640, 60));

		ImageIcon choosePlaneIcon = new ImageIcon("samolot.png."); // load the image to a imageIcon
		Image imgPlane = choosePlaneIcon.getImage(); // transform it 
		Image newimgPlane = imgPlane.getScaledInstance(70, 70, Image.SCALE_SMOOTH); // scale it the smooth way  
		choosePlaneIcon = new ImageIcon(newimgPlane);  // transform it back  
		  
		ImageIcon chooseUfoIcon = new ImageIcon("ufo.png."); // load the image to a imageIcon
		Image imgUfo = chooseUfoIcon.getImage(); // transform it 
		Image newimgUfo = imgUfo.getScaledInstance(70, 70, Image.SCALE_SMOOTH); // scale it the smooth way  
		chooseUfoIcon = new ImageIcon(newimgUfo);  // transform it back  
		  
		ImageIcon chooseRocketIcon = new ImageIcon("rakieta.png."); // load the image to a imageIcon
		Image imgRocket = chooseRocketIcon.getImage(); // transform it 
		Image newimgRocket = imgRocket.getScaledInstance(70, 70, Image.SCALE_SMOOTH); // scale it the smooth way  
		chooseRocketIcon = new ImageIcon(newimgRocket);  // transform it back  
			
		JRadioButton choosePlane = new JRadioButton("Samolot");
		choosePlane.setForeground(Color.white);
		ActionListener planeListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				VehicleLabel.whatVehicle = 1;
			}	
		};
		choosePlane.addActionListener(planeListener);
		choosePlane.setOpaque(false);//.setBackground(new Color(0,0,0,65));
		//choosePlane.setOpaque(true);
		JRadioButton chooseUfo = new JRadioButton("Ufo");
		chooseUfo.setForeground(Color.white);
		ActionListener ufoListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				VehicleLabel.whatVehicle = 2;
			}	
		};
		chooseUfo.addActionListener(ufoListener);
		//chooseUfo.setBackground(new Color(0,0,0,65));
		chooseUfo.setOpaque(false);
		JRadioButton chooseRocket = new JRadioButton("Rakieta");
		chooseRocket.setForeground(Color.white);
		ActionListener rocketListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				VehicleLabel.whatVehicle = 3;
			}	
		};
		chooseRocket.addActionListener(rocketListener);
		//chooseRocket.setBackground(new Color(0,0,0,65));
		chooseRocket.setOpaque(false);
		
		ButtonGroup chooseYourFighter = new ButtonGroup();
		chooseYourFighter.add(choosePlane);
		chooseYourFighter.add(chooseUfo);
		chooseYourFighter.add(chooseRocket);
		
		choosePlane.setIcon(choosePlaneIcon);
		chooseUfo.setIcon(chooseUfoIcon);;
		chooseRocket.setIcon(chooseRocketIcon);
		
		vehiclePanel2.add(choosePlane);
		vehiclePanel2.add(chooseUfo);
		vehiclePanel2.add(chooseRocket);
		
		JPanel startPanel = new JPanel();
		mainPanel.add(startPanel);
		startPanel.setOpaque(false);
		JButton startButton = new JButton();
		ActionListener startListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				GameFrame gameScreen = new GameFrame();
				gameScreen.setVisible(true);
				ExecutorService exec = Executors.newFixedThreadPool(3);
				exec.execute(GameFrame.scoreL);
				exec.execute(GameFrame.heavenPanel);
				exec.execute(GameFrame.fuel);
				exec.shutdown();
				startScreen.setVisible(false);
			}	
		};
		startButton.addActionListener(startListener);
		ImageIcon startIcon = new ImageIcon("start.png."); // load the image to a imageIcon
		Image imgStart = startIcon.getImage(); // transform it 
		Image newimgStart = imgStart.getScaledInstance(250, 100, Image.SCALE_SMOOTH); // scale it the smooth way  
		startIcon = new ImageIcon(newimgStart);  // transform it back  
		startButton.setIcon(startIcon);
		//startButton.setBackground(Color.blue);
		//startButton.setForeground(Color.white);
		startButton.setPreferredSize(new Dimension(248, 98));
		startPanel.add(startButton);

    }

	
    public StartFrame(GraphicsConfiguration gc) {
        super(gc);
    }
    public StartFrame(String title) throws HeadlessException {
        super(title);
    }
    public StartFrame(String title, GraphicsConfiguration gc) {
        super(title, gc);
    }

	public static void main(String[] args) {
		startScreen.setVisible(true);
		String filepath = "muzyka.wav";
		music.PlayMusic(filepath);
	}

}
