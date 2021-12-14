package Bomberman.Sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound {
    private Clip clip;

    public Sound(String url) {
        try {
            File file = new File("res\\sounds\\" + url + ".wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            this.clip = AudioSystem.getClip();
            this.clip.open(audioStream);
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    public void play() {
        clip.setMicrosecondPosition(0);
        clip.start();
    }

    public void pause() {
        clip.stop();
    }

    public void loop() {
        play();
        clip.loop(clip.LOOP_CONTINUOUSLY);
    }

    public static Clip getSound(String url) {
        Clip clip = null;
        try {
            File file = new File("res\\sounds\\" + url + ".wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
        return clip;
    }
}
