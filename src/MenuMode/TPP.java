package menuMode;
import java.awt.Font;
import java.io.InputStream;
import gameMode.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.util.ResourceLoader;

import story.Cutscene;


public class TPP extends StateBasedGame{
	public static final String gamename = "Twitch Fights Pokemon";
	public static final int loadingScreen = 0;
	public static final int startMenu = 1;
	public static final int map = 2;
	public static final int story = 3;

	public static TrueTypeFont font;
	public static TrueTypeFont smallfont;
	
	static AppGameContainer appgc;
	
	public TPP(String gamename)
	{
		super(gamename);
	}
	
	public void initStatesList(GameContainer gc) throws SlickException{
//	      this.getState(loadingScreen).init(gc, this);
//	      this.getState(startMenu).init(gc, this);
//	      this.getState(map).init(gc, this);
//	      this.getState(story).init(gc, this);
		this.addState(new LoadingScreen(loadingScreen));
		this.addState(new StartMenu(startMenu));
		this.addState(new Map(map));
		this.addState(new Cutscene(story));
	      this.enterState(loadingScreen);
	   }
	
	public static void setFont(){
		try {
			InputStream inputStream	= ResourceLoader.getResourceAsStream("game_over.ttf");
			Font awtFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			awtFont = awtFont.deriveFont(84f); // set font size
			font = new TrueTypeFont(awtFont, false);
			awtFont = awtFont.deriveFont(60f); // set font size
			smallfont = new TrueTypeFont(awtFont, false);
	 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		
		try
		{
			appgc = new AppGameContainer(new TPP(gamename));
			appgc.setDisplayMode(600, 300, false);
			appgc.setShowFPS(false);
			appgc.setTargetFrameRate(60);
			appgc.start();
		}
		catch (SlickException ex)
		{
			ex.printStackTrace();
		}
	}
}