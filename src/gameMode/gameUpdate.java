package gameMode;

import java.io.IOException;

import menuMode.MenuRender;
import menuMode.TPP;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.ResourceLoader;


public class gameUpdate extends gameRender{

	
	public void updateMethod(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		setMusic();
		
		
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
			fire1X=play1X+Player1Sprite.getWidth()/3;
			fire1Y=play1Y+Player2Sprite.getHeight()/8;
			projCircle1= new Circle(fire1X, fire1Y, 40);
			proj1 = new Velocity(fire1X, fire1Y, 20*directionOfPlayer1Attack, -2);
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
				fire2X=play2X+Player2Sprite.getWidth()/3;
				fire2Y=play2Y+Player2Sprite.getHeight()/8;
				projCircle2= new Circle(fire2X, fire2Y, 40);
				proj2 = new Velocity(fire2X, fire2Y, 20*directionOfPlayer2Attack, -2);
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
				fire2X=play2X+Player2Sprite.getWidth()/3;
				fire2Y=play2Y+Player2Sprite.getHeight()/8;
				projCircle2= new Circle(fire2X, fire2Y, 40);
				proj2 = new Velocity(fire2X, fire2Y, 20*directionOfPlayer2Attack, -2);
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
				if(play1X<play2X)
					directionOfPlayer1Attack=1;
				else
					directionOfPlayer1Attack=-1;
				if(play2X<play1X)
					directionOfPlayer2Attack=1;
				else
					directionOfPlayer2Attack=-1;
				
	}

	private void setMusic() {
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
	}
}