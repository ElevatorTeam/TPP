package gameMode;

import java.awt.Font;
import java.io.IOException;
import java.io.InputStream;
import menuMode.*;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.ResourceLoader;

public class Map extends BasicGameState {
	private int state;
	public static gameUpdate gameManager;
	
	public Map(int state) {
		 this.state = state;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
	}
	
	public static void gameInitMethod() throws SlickException{
		gameManager = new gameUpdate();
		gameManager.initMethod();
	}
	
	public static void mapinit() throws SlickException{
		gameManager.mapInit();
	}
	
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException{
		gameManager.renderMethod(gc, g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		gameManager.updateMethod(gc, sbg, delta);
	}

	@Override
	public int getID() {
		return this.state;
	}
}