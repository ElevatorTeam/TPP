package gameMode;

import java.awt.Font;
import java.io.IOException;
import java.io.InputStream;
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

import MenuMode.*;

public class Map extends BasicGameState {
	private int state;
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
	public static boolean dogepossible;
	public static boolean cagepossible;
    private Audio music;
	static boolean musicCheck=true;
    private Audio wow;
    static Audio shoot;
	static boolean shootCheck=true;
    static Audio shoot2;
	static boolean shootCheck2=true;
    static Audio hit;
	static boolean hitCheck=true;
	int hitx1=2000;
	int hitx2=2000;
	int hity1=2000;
	int hity2=2000;
	int tiex =2000;
	int tiey =2000;
	public static int mapControl;
	public static boolean IsThisAI = false;
	
	public Map(int state) {
		 this.state = state;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
	}
	
	public static void gameInitMethod() 
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
	public static void mapinit() throws SlickException{
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
	
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException{
		g.setFont(TPP.font);
		g.setColor(Color.cyan);
		land.draw(0, 0, gc.getWidth(), gc.getHeight());
		Player1Sprite.draw(play1X, play1Y);
		Player2Sprite.draw(play2X, play2Y);
		if(CanBeHit2==true)
			fire1.draw(fire1X, fire1Y, Color.blue);
		if(CanBeHit1==true)
			fire2.draw(fire2X, fire2Y, Color.red);
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

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		if(musicCheck){
			Mouse.setGrabbed(true);
			try {
				
				if(mapControl==0)
					music = AudioLoader.getAudio("OGG", ResourceLoader.getResourceAsStream("resources/music/magic.ogg"));
				else if(mapControl==1)
					music = AudioLoader.getAudio("OGG", ResourceLoader.getResourceAsStream("resources/music/icu.ogg"));
				else if(mapControl==2)
					music = AudioLoader.getAudio("OGG",ResourceLoader.getResourceAsStream("resources/music/castle.ogg"));
				else if(mapControl==3)
					music = AudioLoader.getAudio("OGG", ResourceLoader.getResourceAsStream("resources/music/attraction.ogg"));
				else if(mapControl==4)
					music = AudioLoader.getAudio("OGG", ResourceLoader.getResourceAsStream("resources/music/hendl.ogg"));
				else
					music = AudioLoader.getAudio("OGG", ResourceLoader.getResourceAsStream("resources/music/castle.ogg"));
				if(dogepossible)
					music = AudioLoader.getAudio("OGG", ResourceLoader.getResourceAsStream("resources/music/wowsong.ogg"));
		        } catch (IOException e) {
		        e.printStackTrace();
		    }
			music.playAsSoundEffect(1.0f, 1.0f, false);
			musicCheck=false;
		}
		
		Input input = gc.getInput();
		projCircle1= new Circle(fire1X+25, fire1Y+25, 40);
		projCircle2= new Circle(fire2X+25, fire2Y+25, 40);
		
		//
		//PLAYER 1
		player1.CalcPosPlay1(gc);
		play1X=player1.posX();
		play1Y=player1.posY();
		if(input.isKeyDown(Input.KEY_T)){
			shootCheck=true;
			bool1=true; 
			fire1X=play1X+Player1Sprite.getWidth()/2;
			fire1Y=play1Y+Player2Sprite.getHeight()/8;
			projCircle1= new Circle(fire1X, fire1Y, 40);
			proj1 = new Velocity(fire1X, fire1Y, 20, -2);
		}
		
		if(bool1==true && !(input.isKeyDown(Input.KEY_T))){
			if(shootCheck==true){
					shoot.playAsSoundEffect(1.0f, 1.0f, false);
				shootCheck=false;
			}
		proj1.CalcProj();
		projCircle1= new Circle(fire1X+25, fire1Y+25, 40);
		fire1X=proj1.posX();
		fire1Y=proj1.posY();
		}
		//END OF PLAYER 1
		//
		
		//
		//PLAYER 2
		if(IsThisAI){
			aiPlayer.AiInput();
			aiPlayer.CalcPosAI(gc);
			play2X=aiPlayer.posX();
			play2Y=aiPlayer.posY();
			//checks whether to shoot
			aiPlayer.LocationChecker(play1Y,play2Y);
			if(aiPlayer.shootTime){
				bool2=true;
				fire2X=play2X+Player2Sprite.getWidth()/2;
				fire2Y=play2Y+Player2Sprite.getHeight()/8;
				projCircle2= new Circle(fire2X, fire2Y, 40);
				proj2 = new Velocity(fire2X, fire2Y, -20, -2);
				shootCheck2=true;
			}
			
			if(bool2==true && !(aiPlayer.shootTime)){
				if(shootCheck2==true){	
					shoot2.playAsSoundEffect(1.0f, 1.0f, false);
					shootCheck2=false;
				}
				proj2.CalcProj();
				projCircle2= new Circle(fire2X+25, fire2Y+25, 40);
				fire2X=proj2.posX();
				fire2Y=proj2.posY();
			}
		}
		
		//if player 2 is human
		else{
			player2.CalcPosPlay2(gc);
			play2X=player2.posX();
			play2Y=player2.posY();
			if(input.isKeyDown(Input.KEY_NUMPAD0)){
				shootCheck2=true;
				bool2=true;
				fire2X=play2X+Player2Sprite.getWidth()/2;
				fire2Y=play2Y+Player2Sprite.getHeight()/8;
				projCircle2= new Circle(fire2X, fire2Y, 40);
				proj2 = new Velocity(fire2X, fire2Y, -20, -2);
			}

			if(bool2==true && !(input.isKeyDown(Input.KEY_NUMPAD0))){
				if(shootCheck2==true){
					shoot2.playAsSoundEffect(1.0f, 1.0f, false);
					shootCheck2=false;
				}
				proj2.CalcProj();
				projCircle2= new Circle(fire2X+25, fire2Y+25, 40);
				fire2X=proj2.posX();
				fire2Y=proj2.posY();
			}
			//END OF PLAYER 2
			//
		}
		//END OF PLAYER 2
		//
		
		//player 1 collision detector
			if(IsThisAI){
				if(projCircle1.contains(play2X+Player2Sprite.getWidth()/2, play2Y+Player2Sprite.getHeight()/2) && CanBeHit2==true){
					playerhit1++;
					aiPlayer.VelY=-40;
					CanBeHit2=false;
					hit.playAsSoundEffect(1.0f, 1.0f, false);
					hitx1=fire1X;
					hity1=fire1Y;
				}
				if(!(projCircle1.contains(play2X+Player2Sprite.getWidth()/2, play2Y+Player2Sprite.getHeight()/2) && CanBeHit2==false)){
					hitx1=2000;
					hity1=2000;
					CanBeHit2=true;
				}
			}
			else{
				if(projCircle1.contains(play2X+Player2Sprite.getWidth()/2, play2Y+Player2Sprite.getHeight()/2) && CanBeHit2==true){
					playerhit1++;
					player2.VelY=-40;
					CanBeHit2=false;
					hit.playAsSoundEffect(1.0f, 1.0f, false);
					hitx1=fire1X;
					hity1=fire1Y;
				}
				
				if(!(projCircle1.contains(play2X+Player2Sprite.getWidth()/2, play2Y+Player2Sprite.getHeight()/2) && CanBeHit2==false)){
					hitx1=2000;
					hity1=2000;
					CanBeHit2=true;
				}
			}
				
				//player 2 collision detector
				if(projCircle2.contains(play1X+Player1Sprite.getWidth()/2, play1Y+Player1Sprite.getHeight()/2) && CanBeHit1==true){
					playerhit2++;
					player1.VelY=-40;
					CanBeHit1=false;
					hit.playAsSoundEffect(1.0f, 1.0f, false);
					hitx2=fire2X;
					hity2=fire2Y;
				}
				
				if(!(projCircle2.contains(play1X+Player1Sprite.getWidth()/2, play1Y+Player1Sprite.getHeight()/2) && CanBeHit1==false)){
					hitx2=2000;
					hity2=2000;
					CanBeHit1=true;
				}
				
				//check for win
						if((playerhit1)>9 && winx>=1000){
							if(playerhit2>9 && winx>=1000){
								win2x=gc.getWidth()/32*13;
								win2y=gc.getHeight()/9*7;
								tiex=gc.getWidth()/32*13;;
								tiey=gc.getHeight()/9;
							}
							winx=gc.getWidth()/32*13;
							winy=gc.getHeight()/4;
							win1x=gc.getWidth()/32*13;
							win1y=gc.getHeight()/18*13;
							if(dogepossible){
								try {
							        wow = AudioLoader.getAudio("OGG", ResourceLoader.getResourceAsStream("resources/music/wow.ogg"));
							        } catch (IOException e) {
							        e.printStackTrace();
							    }
								wow.playAsSoundEffect(1.0f, 1.0f, false);
							}
						}
						if(playerhit2>9 && win1x>=1000){
							winx=gc.getWidth()/32*13;
							winy=gc.getHeight()/4;
							win2x=gc.getWidth()/64*27;
							win2y=gc.getHeight()/18*13;
						}
						
						if(playerhit2>9 || playerhit1>9){
							player1.posX=gc.getWidth()/7*2;
							player1.posY=gc.getHeight()/18*7;
							player2.posX=gc.getWidth()/16*9;
							player2.posY=gc.getHeight()/18*7;
							aiPlayer.posX=gc.getWidth()/16*9;
							aiPlayer.posY=gc.getHeight()/18*7;
							fire1X=2000;
							fire1Y=2000;
							fire2X=2000;
							fire2Y=2000;
						}
				
				if(input.isKeyDown(Input.KEY_ESCAPE)){
					music.stop();
					player1.posX=gc.getWidth()/7*2;
					player1.posY=gc.getHeight()/18*7;
					player2.posX=gc.getWidth()/16*9;
					player2.posY=gc.getHeight()/18*7;
					aiPlayer.posX=gc.getWidth()/16*9;
					aiPlayer.posY=gc.getHeight()/18*7;
					musicCheck=true;
					playerhit1=0;
					playerhit2=0;
					hitx1=2000;
					hitx2=2000;
					hity1=2000;
					hity2=2000;
					tiex =2000;
					tiey =2000;
					winx=2000;
					winy=2000;
					win1x=2000;
					win1y=2000;
					win2x=2000;
					win2y=2000;
					play1X=450;
					play1Y=400;
					Vel1X=0;
					Vel1Y=0;
					play2X=900;
					play2Y=400;
					Vel2X=0;
					Vel2Y=0;
					fire1X = 2000;
					fire1Y = 2000;
					fire2X = 2000;
					fire2Y = 2000;
					bool1=false;
					bool2=false;
					MenuRender.theme.playAsSoundEffect(1.0f, 1.0f, false);
					Mouse.setGrabbed(false);
					sbg.enterState(TPP.startMenu);
				}
	}

	@Override
	public int getID() {
		return this.state;
	}
}
