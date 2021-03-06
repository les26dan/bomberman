package Bomberman.Sound;

import javax.sound.sampled.Clip;

public class SoundController {
    private Sound curMusic;
    private Sound stageStart = new Sound(STAGE_START);
    private Sound stageTheme = new Sound(STAGE_THEME);
    private Sound stageComplete = new Sound(STAGE_COMPLETE);
    private Sound ending = new Sound(ENDING);
    private Sound lifeLost = new Sound(LIFE_LOST);

    public static final String TITLE_SCREEN = "tilteScreen";
    public static final String STAGE_START = "stageStart";
    public static final String STAGE_THEME = "stageTheme";
    public static final String FIND_THE_EXIT = "findTheExit";
    public static final String STAGE_COMPLETE = "stageComplete";
    public static final String ENDING = "ending";
    public static final String LIFE_LOST = "lifeLost";

    public static final String EAT_ITEM = "eatItem";
    public static final String SET_BOMB = "setBomb";
    public static final String BOMB_EXPLODE = "bombExplode";
    public static final String MOVE_1 = "move1";
    public static final String MOVE_2 = "move2";

    public static Clip move1 = Sound.getSound("move1");
    public static Clip move2 = Sound.getSound("move2");

    public Sound getCurMusic() {
        return curMusic;
    }

    public void setCurMusic(Sound curMusic) {
        this.curMusic = curMusic;
    }

    public void playCurMusic() {
        curMusic.loop();
    }

    public void changeMusic(String url) {
        if(curMusic != null) {
            curMusic.pause();
        }
        if(url.equals(STAGE_START)) {
            curMusic = stageStart;
        } else if(url.equals(STAGE_THEME)) {
            curMusic = stageTheme;
        } else if(url.equals(STAGE_COMPLETE)) {
            curMusic = stageComplete;
        } else if(url.equals(ENDING)) {
            curMusic = ending;
        } else {
            curMusic = lifeLost;
        }
        playCurMusic();
    }

}
