package game;

import javax.swing.JLabel;

public class ScoreLabel extends JLabel implements Runnable {
	private static final long serialVersionUID = 1L;

	boolean isWorking = true;
	int a = 97;

	ScoreLabel() {
		super();
	}
	
	
	@Override
	public void run() {

		while (isWorking) {
			int t;
			for (double i=0; i<=4344.146; i+=1) {
			//int score = 0;
				//double s = a*t*t/2;
				String value = String.format("%.0f mln km", i);
				setText(value);
				if(i>=628.336) t=85;
				else if(i>=2718.326) t=39;
				else t=159;
				try {
					Thread.sleep(t);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			//score++;
			}
		}
	}
}
