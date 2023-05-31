package game;


import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.JOptionPane;

public class Music  { 
	
	public boolean musicon;
	
	public Music(boolean musicison){
		musicon = musicison;
	}
	
	static Clip clip;
	
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
    
    static public void setVolume(float volume) {
        if (volume < 0f || volume > 1f)
            throw new IllegalArgumentException("Volume not valid: " + volume);
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(20f * (float) Math.log10(volume));
    }
    
    static public float getVolume() {
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        return (float) Math.pow(10f, gainControl.getValue() / 20f);
    }

}
