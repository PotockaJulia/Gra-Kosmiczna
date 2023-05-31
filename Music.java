package game;


import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class Music  { 
	

	
	public boolean musicon;
	public Music(boolean musicison){
		musicon = musicison;
		
		
	}
	
	static Clip clip ;
	public  void PlayMusic(String location) {
		
		if(musicon==true){
		try {
			File musicPath = new File(location);
			if(musicPath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
			}
			else {
				System.out.println("Can't find file");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		}
		
		
	}
	public void play() throws IOException {
        clip.start();
    }
    public void stop() throws IOException {

        clip.stop();
    }

}
