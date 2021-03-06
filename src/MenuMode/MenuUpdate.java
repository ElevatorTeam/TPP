package menuMode;

import gameMode.Chars;
import gameMode.Map;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.*;

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
			if(Keyboard.isKeyDown(Keyboard.KEY_Q)){
				theme.stop();
				sbg.enterState(TPP.story,new FadeOutTransition(),new FadeInTransition());
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

		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
			if(player1ChoiceX==1){
				Map.gameManager.Player1Sprite=Chars.lazrAnim;
				Map.gameManager.Player1Flipped=Chars.lazrAnimFlipped;
			}
			else if(player1ChoiceX==2){
				Map.gameManager.Player1Sprite=Chars.dragAnim;
				Map.gameManager.Player1Flipped=Chars.dragAnimFlipped;
			}
			else if(player1ChoiceX==3){
				Map.gameManager.Player1Sprite=Chars.zapdAnim;
				Map.gameManager.Player1Flipped=Chars.zapdAnimFlipped;
			}
			else if(player1ChoiceX==4){
				Map.gameManager.Player1Sprite=Chars.flareonAnim;
				Map.gameManager.Player1Flipped=Chars.flareonAnimFlipped;
			}
			else if(player1ChoiceX==5){
				Map.gameManager.Player1Sprite=Chars.birdAnim;
				Map.gameManager.Player1Flipped=Chars.birdAnimFlipped;
			}
			else if(player1ChoiceX==6){
				Map.gameManager.Player1Sprite=Chars.atvAnim;
				Map.gameManager.Player1Flipped=Chars.atvAnimFlipped;
			}
			
			//player2 Player picked.
			if(player2ChoiceX==1){
				Map.gameManager.Player2Sprite=Chars.lazrAnim;
				Map.gameManager.Player2Flipped=Chars.lazrAnimFlipped;
			}
			else if(player2ChoiceX==2){
				Map.gameManager.Player2Sprite=Chars.dragAnim;
				Map.gameManager.Player2Flipped=Chars.dragAnimFlipped;
			}
			else if(player2ChoiceX==3){
				Map.gameManager.Player2Sprite=Chars.zapdAnim;
				Map.gameManager.Player2Flipped=Chars.zapdAnimFlipped;
			}
			else if(player2ChoiceX==4){
				Map.gameManager.Player2Sprite=Chars.flareonAnim;
				Map.gameManager.Player2Flipped=Chars.flareonAnimFlipped;
			}
			else if(player2ChoiceX==5){
				Map.gameManager.Player2Sprite=Chars.birdAnim;
				Map.gameManager.Player2Flipped=Chars.birdAnimFlipped;
			}
			else if(player2ChoiceX==6){
				Map.gameManager.Player2Sprite=Chars.atvAnim;
				Map.gameManager.Player2Flipped=Chars.atvAnimFlipped;
			}
			if(player1ChoiceX==player2ChoiceX && player1ChoiceY==player2ChoiceY){
				Map.gameManager.player2IsGreyFromClone=true;
			}
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