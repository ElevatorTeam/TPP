package menuMode;

import gameMode.Chars;
import gameMode.Map;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class MenuUpdate extends MenuClick {
	
    static int player1ChoiceX=1;
    static int player1ChoiceY=1;
    static int player2ChoiceX=1;
    static int player2ChoiceY=1;
    public static boolean movingArrow1=false;
    static int frameCount=0;

	public void menuUpdate(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		if(playTheme ==true){
			theme.playAsSoundEffect(1.0f, 1.0f, false);
			playTheme=false;
			Mouse.setGrabbed(false);
			}
			else{}
		
			if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
				Screen=0;
			}
	}
	
	public void characterSelectUpdate(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		if(Keyboard.isKeyDown(Keyboard.KEY_D) && frameCount%10==0){
			if(player1ChoiceX<6)
				player1ChoiceX++;
			movingArrow1=false;
		}
		else
			movingArrow1=true;
		if(Keyboard.isKeyDown(Keyboard.KEY_A)  && frameCount%10==0){
			if(movingArrow1==true){
				if(player1ChoiceX>1)
					player1ChoiceX--;
				movingArrow1=false;
			}
		}
		else
			movingArrow1=true;
		
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD6) && frameCount%10==0){
			if(player2ChoiceX<6)
				player2ChoiceX++;
			movingArrow1=false;
		}
		else
			movingArrow1=true;
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD4)  && frameCount%10==0){
			if(movingArrow1==true){
				if(player2ChoiceX>1)
					player2ChoiceX--;
				movingArrow1=false;
			}
		}
		else
			movingArrow1=true;
		
		
		
		if(Keyboard.isKeyDown(Keyboard.KEY_T)){
			if(player1ChoiceX==1)
				Map.gameManager.Player1Sprite=Chars.lazrAnim;
			else if(player1ChoiceX==2)
				Map.gameManager.Player1Sprite=Chars.dragAnim;
			else if(player1ChoiceX==3)
				Map.gameManager.Player1Sprite=Chars.zapdAnim;
			else if(player1ChoiceX==4)
				Map.gameManager.Player1Sprite=Chars.flareonAnim;
			else if(player1ChoiceX==5)
				Map.gameManager.Player1Sprite=Chars.birdAnim;
			else if(player1ChoiceX==6)
				Map.gameManager.Player1Sprite=Chars.atvAnim;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD0)){
			if(player2ChoiceX==1)
				Map.gameManager.Player2Sprite=Chars.lazrAnim;
			else if(player2ChoiceX==2)
				Map.gameManager.Player2Sprite=Chars.dragAnim;
			else if(player2ChoiceX==3)
				Map.gameManager.Player2Sprite=Chars.zapdAnim;
			else if(player2ChoiceX==4)
				Map.gameManager.Player2Sprite=Chars.flareonAnim;
			else if(player2ChoiceX==5)
				Map.gameManager.Player2Sprite=Chars.birdAnim;
			else if(player2ChoiceX==6)
				Map.gameManager.Player2Sprite=Chars.atvAnim;
		}
		
		
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
			if(Map.gameManager.Player1Sprite==null)
				Map.gameManager.Player1Sprite=Chars.lazrAnim;
			if(Map.gameManager.Player2Sprite==null)
				Map.gameManager.Player1Sprite=Chars.zapdAnim;
			Screen = 2;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
			Screen = 0;
		}
		
	}
	
	public void levelUpdate(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		Mouse.setGrabbed(false);
	        
	        //sets if player 1 is Doge
			if(Keyboard.isKeyDown(Keyboard.KEY_P)){
				Map.gameManager.dogepossible=true;
				Map.gameManager.dogepossible=true;
				if(wowtime==true){
				wowEffect.playAsSoundEffect(1.0f, 1.0f, false);
				wowtime=false;
				}
			}
			
			//sets if player 2 is Cage
			if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD9)){
				Map.gameManager.cagepossible=true;
				Map.gameManager.cagepossible=true;
			}
			
			if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
				Screen = 0;
			}
	}
	
}
