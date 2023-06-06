package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import static game.Music.setVolume;

public class MusicPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	int isMusic=0;
	
	public MusicPanel() {
		super();
		setLayout(new GridLayout(2,1));
		JPanel startstopPanel = new JPanel();
		startstopPanel.setBackground(Color.black);
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
					ImageIcon startstopIcon = new ImageIcon("stop.png"); 
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
					ImageIcon startstopIcon = new ImageIcon("play.png"); 
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
		startstopPanel.add(startstopButton);
		add(startstopPanel);
		
		JPanel sliderPanel = new JPanel();
		sliderPanel.setBackground(Color.black);
		sliderPanel.setLayout(new BorderLayout());
		JPanel labelPanel = new JPanel();
		labelPanel.setOpaque(false);
		JLabel volumeLabel = new JLabel("Głośność:");
		volumeLabel.setForeground(Color.white);
		
		JSlider volumeSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 80);
		volumeSlider.setMajorTickSpacing(10);
		volumeSlider.setPaintLabels(true);
		volumeSlider.setForeground(Color.WHITE);
		volumeSlider.setOpaque(false);
		volumeSlider.setOpaque(false);
		volumeSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				setVolume((float)volumeSlider.getValue()/100);
			}
		});
		
		labelPanel.add(volumeLabel);
		sliderPanel.add(labelPanel, BorderLayout.PAGE_START);
		sliderPanel.add(volumeSlider, BorderLayout.CENTER);
		add(sliderPanel);
	}
}
