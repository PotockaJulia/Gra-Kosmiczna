package game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PausePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private BufferedImage backgroundImage;

	public PausePanel() throws HeadlessException {
		setLayout(new GridLayout(2,1));
		setSize(640, 520);
		
		File imageFile1 = new File("pauza.png");
	 	try {
	 		backgroundImage = ImageIO.read(imageFile1);
	 	} 
	 	catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
	 		e.printStackTrace();
	 	}
		
		JPanel gapPanel = new JPanel();
		gapPanel.setOpaque(false);
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setOpaque(false);
		//buttonsPanel.setLayout(new BorderLayout());
		add(gapPanel);
		add(buttonsPanel);
		
		JButton resumeButton = new JButton();
		resumeButton.setBackground(Color.blue);
		resumeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GamePanel.gameState = GamePanel.playState;
				GamePanel.pauseFrame.setVisible(false);
			}
		});
		ImageIcon resumeIcon = new ImageIcon("wznow.png"); // load the image to a imageIcon
		Image imgStop = resumeIcon.getImage(); // transform it 
		Image newimgStop = imgStop.getScaledInstance(300, 100, Image.SCALE_SMOOTH); // scale it the smooth way  
		resumeIcon = new ImageIcon(newimgStop);  // transform it back  
		resumeButton.setIcon(resumeIcon);
		resumeButton.setPreferredSize(new Dimension(300,100));
		resumeButton.setOpaque(false);
		resumeButton.setBackground(Color.black);
		
		buttonsPanel.add(resumeButton);
	}
	
	public void paintComponent(Graphics g) {
 		Graphics2D g2d = (Graphics2D) g;
 		g2d.drawImage(backgroundImage.getScaledInstance(640, 520, Image.SCALE_SMOOTH), 0, 0, this);

 	}
}
