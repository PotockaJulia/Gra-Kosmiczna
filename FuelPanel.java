package game;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class FuelPanel extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	//int fuelStatus=150;
	//JLabel fuelLabel = new JLabel();
	JProgressBar progressBar = new JProgressBar(0,500);
	boolean isWorking = true;

	FuelPanel(){
		//Dimension dimension1 = new Dimension(fuelStatus,25);
		//setPreferredSize(dimension1);
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		Dimension dimension1 = new Dimension(150, 25);
		progressBar.setPreferredSize(dimension1);
		progressBar.setBackground(Color.black);
		progressBar.setForeground(Color.green);
		//this.setBackground(Color.cyan);
		this.add(progressBar);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (isWorking) {
			//fuelStatus--;
			//Dimension dimension1 = new Dimension(fuelStatus,25);
			//setPreferredSize(dimension1);
			//fuelLabel.setText("%d %");
			int counter =500;
			while (counter > 0) {
				progressBar.setValue(counter);
				counter--;
				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
	}
	
}
