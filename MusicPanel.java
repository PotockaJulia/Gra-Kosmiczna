package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class MusicPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	int isMusic=0;
	
	public MusicPanel() {
		super();
		JButton startstopButton = new JButton();
		startstopButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				isMusic+=1;
				System.out.println(isMusic);
				if(isMusic%2==0) {
					try {
						StartFrame.music.play();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
					ImageIcon startstopIcon = new ImageIcon("play.png"); 
					Image imgStartstop = startstopIcon.getImage();
					Image newimgStartstop = imgStartstop.getScaledInstance(100, 100, Image.SCALE_SMOOTH); 
					startstopIcon = new ImageIcon(newimgStartstop);
					startstopButton.setIcon(startstopIcon);
				}	
				else {
					try {
						StartFrame.music.stop();
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ImageIcon startstopIcon = new ImageIcon("stop.png"); 
					Image imgStartstop = startstopIcon.getImage();
					Image newimgStartstop = imgStartstop.getScaledInstance(100, 100, Image.SCALE_SMOOTH); 
					startstopIcon = new ImageIcon(newimgStartstop);
					startstopButton.setIcon(startstopIcon);
				}
			}
		});
		ImageIcon startstopIcon = new ImageIcon("stop.png"); 
		Image imgStartstop = startstopIcon.getImage();
		Image newimgStartstop = imgStartstop.getScaledInstance(100, 100, Image.SCALE_SMOOTH); 
		startstopIcon = new ImageIcon(newimgStartstop);
		startstopButton.setIcon(startstopIcon);
		startstopButton.setPreferredSize(new Dimension(100,100));
		startstopButton.setBackground(Color.black);
		add(startstopButton);
		JSlider volumeSlider = new JSlider(JSlider.HORIZONTAL, 0, 5, 3);
		volumeSlider.setMajorTickSpacing(1);
		volumeSlider.setMinorTickSpacing(1);
		add(volumeSlider);
	}
}
