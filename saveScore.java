package game;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class saveScore extends JFrame {
	
	/**
	 * 
	 */
	static saveScore saveScreen = new saveScore();
	
	private static final long serialVersionUID = 1L;
	ScoreLabel scoreLabel = new ScoreLabel();
	JInternalFrame frame = new JInternalFrame();
	FileWriter fwrite;
	JTextField nick;
	JLabel yourScore;
	JLabel player;
	JButton saveButton;
	JPanel main;
	
	
	public saveScore() {
		// TODO Auto-generated constructor stub
		this.setTitle("SAVE YOUR SCORE");
		this.setSize(320, 120);
		nick = new JTextField(15);
		yourScore = new JLabel("Your score: " + ScoreLabel.score);
		player = new JLabel("Player name: ");
		saveButton = new JButton("Save score");
		saveButton.addActionListener(e->{
			try {
				Save();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		main = new JPanel();
		main.setLayout(new GridLayout(4,1));
		main.add(player);
		main.add(nick);
		main.add(yourScore);
		main.add(saveButton);
		this.add(main);
		
	}

	
	public void Save() throws IOException {
		String nickname = nick.getText();
	
		if(nickname.equals("")){
			this.dispose();
		}
		else {
			BufferedWriter write = new BufferedWriter(new FileWriter("rekordy.txt", true));
			write.append(nickname + "\tScore: " + ScoreLabel.score + "\n");
			write.close();
			this.dispose();
		}
		 

	}
	
	public static void main(String[] args) {
		saveScreen.setVisible(true);
	}
}
