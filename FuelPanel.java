package game;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class FuelPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	int fuelStatus=150;
	JLabel fuelLabel = new JLabel("paliwo");

	FuelPanel(){
		Dimension dimension1 = new Dimension(fuelStatus,25);
		setPreferredSize(dimension1);
		this.setBackground(Color.cyan);
		this.add(fuelLabel);
	}
	
}
