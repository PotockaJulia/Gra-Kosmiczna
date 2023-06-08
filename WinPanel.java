package game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class WinPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private BufferedImage backgroundImage;

	public WinPanel() throws HeadlessException {
		setLayout(new GridLayout(2,1));
		setSize(640, 520);
		
		File imageFile1 = new File("przegrana.png");
	 	try {
	 		backgroundImage = ImageIO.read(imageFile1);
	 	} 
	 	catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
	 		e.printStackTrace();
	 	}
	}
	
	public void paintComponent(Graphics g) {
 		Graphics2D g2d = (Graphics2D) g;
 		g2d.drawImage(backgroundImage.getScaledInstance(640, 520, Image.SCALE_SMOOTH), 0, 0, this);

 	}
	
}
