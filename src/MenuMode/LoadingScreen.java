package menuMode;

import gameMode.Attacks;
import gameMode.Chars;
import gameMode.Map;

import java.awt.Font;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.util.ResourceLoader;
import org.lwjgl.input.Mouse;


import java.io.InputStream;

public class LoadingScreen extends BasicGameState{

	private int state;
	int framecount;
	boolean doneLoading =false;
	String dots = "";

	public LoadingScreen(int state) {
		 this.state = state;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		TPP.setFont();
		framecount=0;
}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.setFont(TPP.font);
		g.setColor(Color.red);
		g.drawString("Loading Now" + dots, gc.getWidth()/3, gc.getHeight()/30*12);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		if(framecount%30==0){
			if(dots.equals(""))
				dots=".";
			else if(dots.equals("."))
				dots="..";
			else if(dots.equals(".."))
				dots="...";
			else if(dots.equals("..."))
				dots=".";
		}
		if(framecount==90)
			load();
		
		if(doneLoading){
			TPP.appgc.setDisplayMode(1280, 720, false);
			sbg.enterState(TPP.startMenu);
		}
		
		framecount++;
	}
	
	public void load(){
		new Chars();
		new Attacks();
		Chars.createSpriteSheets();
		Chars.createAnimations();
		Attacks.createSpriteSheets();
		Attacks.createAnimations();
		try {
			Map.gameInitMethod();
			StartMenu.menuInit();
		} catch (SlickException e) {
			e.printStackTrace();
		}
		doneLoading=true;
	}
	
	@Override
	public int getID() {
		return this.state;
	}
}
