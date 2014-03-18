package gameMode;

import java.io.IOException;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.ResourceLoader;

import MenuMode.TPP;

public class gameRender {
	static Image land;
	static Animation Player1Sprite;
	static Animation Player2Sprite;
	static Image fire1;
	static Image fire2;
	static Image hud;
	static Image hit1; //"boom" image, when someone gets hit
	static Image hit2;
	//win related vars
	static Image wnner;
	static Image win1;
	static Image win2;
	int winx=2000; // location of you're winner
	int winy=2000;
	int win1x=2000; // "player1 has won!"
	int win1y=2000;
	int win2x=2000; // "player2 has won!"
	int win2y=2000;
	static int play1X=450; // Location of player 1
	static int play1Y=400;
	static int Vel1X=0;
	static int Vel1Y=0;
	static int play2X=900; // Location of player 2
	static int play2Y=400;
	static int Vel2X=0;
	static int Vel2Y=0;
	static int fire1X = 2000; // location of fireball for player 1
	static int fire1Y = 2000;
	static int fire2X = 2000; // location of fireball for player 2
	static int fire2Y = 2000;
	static Boolean bool1=false; //whether player 1 is firing
	static Boolean bool2=false; //whether player 2 is firing
	static Velocity player1;
	static Velocity proj1;
	static Velocity player2;
	static VelocityAI aiPlayer;
	static Velocity proj2;
	static Circle projCircle1 = null;
	static Circle projCircle2 = null;
	static int playerhit1=0; // score of player 1
	static int playerhit2=0;
	static boolean CanBeHit1 =true; //Can this person be hit?
	static boolean CanBeHit2 =true;
	public boolean dogepossible;
	public boolean cagepossible;
    static Audio music;
	static boolean musicCheck=true;
    static Audio wow;
    static Audio shoot;
	static boolean shootCheck=true;
    static Audio shoot2;
	static boolean shootCheck2=true;
    static Audio hit;
	static boolean hitCheck=true;
	static int hitx1=2000;
	static int hitx2=2000;
	static int hity1=2000;
	static int hity2=2000;
	static int tiex =2000;
	static int tiey =2000;
	public int mapControl;
	public boolean IsThisAI = false;
	
	public void initMethod() 
			throws SlickException{
		land = new Image("resources/images/ToxicWasteland.png");
		fire1= new Image("resources/images/fure.png");
		fire2= new Image("resources/images/fure.png");
		hit1= new Image("resources/images/boom.png");
		hit2= new Image("resources/images/boom.png");
		hud= new Image("resources/images/hud.png");
		wnner= new Image("resources/images/wnner.png");
		win1= new Image("resources/images/1win.png");
		win2= new Image("resources/images/2win.png");
		player1 = new Velocity(play1X, play1Y, Vel1X, Vel1Y);
		player2 = new Velocity(play2X, play2Y, Vel2X, Vel2Y);
		aiPlayer = new VelocityAI(play2X, play2Y, Vel2X, Vel2Y);	
		
		try {
	        shoot = AudioLoader.getAudio("OGG", ResourceLoader.getResourceAsStream("resources/music/fire.ogg"));
        } catch (IOException e) {e.printStackTrace();}
		try {
	        shoot2 = AudioLoader.getAudio("OGG", ResourceLoader.getResourceAsStream("resources/music/fire.ogg"));
        } catch (IOException e) {e.printStackTrace();}
		try {
	        hit = AudioLoader.getAudio("OGG", ResourceLoader.getResourceAsStream("resources/music/hit.ogg"));
        } catch (IOException e) {e.printStackTrace();}
	}
	
	//controls the maps
	public void mapInit() throws SlickException{
		if(dogepossible==true) 
		    Player1Sprite= Chars.birdAnim;
		else
			Player1Sprite= Chars.dragAnim;
		if(cagepossible==true)
			Player2Sprite= Chars.flareonAnim;
		else
			Player2Sprite= Chars.zapdAnim;
		if(mapControl==0)
			land = new Image("resources/images/ToxicWasteland.png");
		if(mapControl==1)
			land = new Image("resources/images/paradise.png");	
		if(mapControl==2)
			land = new Image("resources/images/LavaPit.png");	
		if(mapControl==3)
			land = new Image("resources/images/ice.png");	
		if(mapControl==4)
			land = new Image("resources/images/bg.png");
	}
	
	public void renderMethod(GameContainer gc, Graphics g) throws SlickException{
		g.setFont(TPP.font);
		g.setColor(Color.cyan);
		land.draw(0, 0, gc.getWidth(), gc.getHeight());
		Player1Sprite.draw(play1X, play1Y);
		Player2Sprite.draw(play2X, play2Y);
		if(CanBeHit2==true)
			fire1.draw(fire1X, fire1Y, Color.blue);
		if(CanBeHit1==true)
			fire2.draw(fire2X, fire2Y, Color.yellow);
		hit1.draw(hitx1,hity1);
		hit2.draw(hitx2,hity2);
		hud.draw(0,0,gc.getWidth(), gc.getHeight());
		g.drawString("" + playerhit1, gc.getWidth()/2-(gc.getWidth()/9), (int) (gc.getHeight()-((gc.getHeight()/90)*11.5)));
		g.drawString("" + playerhit2, gc.getWidth()/2+(gc.getWidth()/15), (int) (gc.getHeight()-((gc.getHeight()/90)*11.5)));
		g.drawString("You both tied!", tiex, tiey);
		win1.draw(win1x, win1y);
		win2.draw(win2x,win2y);
		wnner.draw(winx, winy);
		Chars.restartAnimations();
	}
}
