package MenuMode;

import java.awt.Font;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;


public class MenuCommands {
	
	Image menu;
	int state;
    Audio wowEffect;
    boolean wowtime;
    Audio cageEffect;
    boolean cagetime;
    boolean IsThereAI = true;
	Image exitGame;
	public static Audio theme;
	boolean playTheme = true;
	int Screen = 0;
	boolean clickable=false;
    
    public void initMain() throws SlickException{
		exitGame = new Image("resources/images/exitGame.png");
		
		try {
	        theme = AudioLoader.getAudio("OGG", ResourceLoader.getResourceAsStream("resources/music/menu.ogg"));
	     } catch (IOException e){
	        e.printStackTrace();
	    }	
	}
    
    public void initLevel() throws SlickException{
		menu = new Image("resources/images/menu.png");
		wowtime=true;
		
		 try {
		        wowEffect = AudioLoader.getAudio("OGG", new FileInputStream("resources/music/wow.ogg"));
		     } catch (IOException e){
		        e.printStackTrace();
		    }
		try {
			cageEffect = AudioLoader.getAudio("OGG", new FileInputStream("resources/music/wow.ogg"));
        } catch (IOException e) {
        	e.printStackTrace();
        }
	}

}
