package game;

import java.sql.Time;

import javax.swing.JLabel;

public class ScoreLabel extends JLabel implements Runnable {
	private static final long serialVersionUID = 1L;

	static boolean isWorkingL = true;
	//int a = 97;
	public static int score = 0;
	
	ScoreLabel() {
		super();
	}
	
	
	@Override
	public void run() {
		//if(GamePanel.gameState == GamePanel.playState) {
			while (isWorkingL) {
				int t;
				for (double i=0; i<4344; i+=1) {
					String value = String.format("%d mln km", score);
					setText(value);
					if(GamePanel.gameState == GamePanel.playState) {
						score++;
						if(i>=628) t=70;//100s to trwa, od Jowisza
						else if(i>=2718) t=30;//to 60s, od Uranu
						else t=140;//trwa 100s, do Jowisza
						
						try {
							Thread.sleep(t);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					if (i==4344) isWorkingL = false;
				}
			}
		//}
		
	}
}
