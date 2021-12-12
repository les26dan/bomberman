package Bomberman.Sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound {
    public static Clip tilteScreen = Sound.getSound("titleScreen");
    public static Clip stageStart = Sound.getSound("stageStart"); // Nhạc bắt đầu màn chơi
    public static Clip stageTheme = Sound.getSound("stageTheme"); // Nhạc nền màn chơi
    public static Clip findTheExit = Sound.getSound("findTheExit"); // Nhạc khi tìm thấy Portal
    public static Clip stageComplete = Sound.getSound("stageComplete"); // Nhạc khi màn chơi hoàn thành
    public static Clip bonusStage = Sound.getSound("bonusStage"); // Nhạc màn chơi phụ
    public static Clip invincibility = Sound.getSound("invincibility"); //
    public static Clip lifeLost = Sound.getSound("lifeLost"); // Nhạc khi mất mạng
    public static Clip gameOver = Sound.getSound("gameOver"); // Nhạc khi game kết thúc
    public static Clip ending = Sound.getSound("ending"); // Nhạc khi kết thúc

    public static Clip eatItem = Sound.getSound("eatItem");
    public static Clip setBomb = Sound.getSound("setBomb");
    public static Clip bombExplode = Sound.getSound("bombExplode");
    public static Clip move1 = Sound.getSound("move1");
    public static Clip move2 = Sound.getSound("move2");

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
