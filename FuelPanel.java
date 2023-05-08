package game;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class FuelPanel extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	int fuelStatus=150;
	JLabel fuelLabel = new JLabel();
	//JProgressBar progressBar = new JProgressBar(0,500);
	boolean isWorking = true;

	FuelPanel(){
		//Dimension dimension1 = new Dimension(fuelStatus,25);
		//setPreferredSize(dimension1);
		this.setBackground(Color.cyan);
		this.add(fuelLabel);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (isWorking) {
			fuelStatus--;
			Dimension dimension1 = new Dimension(fuelStatus,25);
			setPreferredSize(dimension1);
			//fuelLabel.setText("%d %");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
