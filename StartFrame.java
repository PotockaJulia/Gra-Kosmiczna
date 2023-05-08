package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class StartFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;

	static StartFrame startScreen = new StartFrame();
	
	public StartFrame() throws HeadlessException {
		
		this.setSize(640, 470);
		this.setLayout(new GridLayout(3,1));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		 
		JPanel helloPanel = new JPanel();
		helloPanel.setBackground(Color.black);
		add(helloPanel, BorderLayout.CENTER);
		helloPanel.setLayout(new BorderLayout());
		
		JLabel hello = new JLabel("Space Adventure", JLabel.CENTER);
		hello.setFont(new Font("Serif", Font.PLAIN, 72));
		hello.setForeground(Color.white);
		helloPanel.add(hello, BorderLayout.CENTER);
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(Color.black);
		helloPanel.add(infoPanel, BorderLayout.PAGE_END);
		
		JButton infoButton = new JButton("Informacje");
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
		infoButton.setBackground(Color.blue);
		infoPanel.add(infoButton);
		
		
		JPanel vehiclePanel = new JPanel();
		add(vehiclePanel);
		vehiclePanel.setLayout(new GridLayout(2,1));
		
	
		JPanel vehiclePanel1 = new JPanel();
		vehiclePanel1.setBackground(Color.black);
		//vehiclePanel1.setLayout(null);
		//vehiclePanel1.setBounds(0, 0, 640, 80);
		vehiclePanel.add(vehiclePanel1);
		
		JLabel chooseVehicle = new JLabel("Wybierz pojazd: ", JLabel.CENTER);
		chooseVehicle.setForeground(Color.white);
		
		vehiclePanel1.add(chooseVehicle);
		
		
		JPanel vehiclePanel2 = new JPanel();
		vehiclePanel2.setBackground(Color.black);
		vehiclePanel.add(vehiclePanel2);
	

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
		ActionListener planeListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				VehicleLabel.whatVehicle = 1;
			}	
		};
		choosePlane.addActionListener(planeListener);
		choosePlane.setBackground(Color.black);
		choosePlane.setOpaque(true);
		JRadioButton chooseUfo = new JRadioButton("Ufo");
		ActionListener ufoListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				VehicleLabel.whatVehicle = 2;
			}	
		};
		chooseUfo.addActionListener(ufoListener);
		chooseUfo.setBackground(Color.black);
		chooseUfo.setOpaque(true);
		JRadioButton chooseRocket = new JRadioButton("Rakieta");
		ActionListener rocketListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				VehicleLabel.whatVehicle = 3;
			}	
		};
		chooseRocket.addActionListener(rocketListener);
		chooseRocket.setBackground(Color.black);
		chooseRocket.setOpaque(true);
		
		
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
		add(startPanel);
		startPanel.setBackground(Color.black);
		JButton startButton = new JButton("START");
		ActionListener startListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				GameFrame gameScreen = new GameFrame();
				gameScreen.setVisible(true);
				ExecutorService exec = Executors.newFixedThreadPool(3);
				exec.execute(gameScreen.scoreL);
				exec.execute(GameFrame.heavenPanel);
				exec.execute(GameFrame.fuel);
				exec.shutdown();
				startScreen.setVisible(false);
			}	
		};
		
		startButton.addActionListener(startListener);
		startButton.setBackground(Color.red);
		startButton.setForeground(Color.white);
		startButton.setPreferredSize(new Dimension(120, 60));
		//infoButton.addActionListener(infoListener);
		
		startPanel.add(startButton);
		//startPanel.add(infoButton);
		
		
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
	}

}

