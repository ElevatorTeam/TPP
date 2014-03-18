package MenuMode;

import gameMode.Map;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


public class MenuUpdate extends MenuClick {

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
	
	public void levelUpdate(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		Mouse.setGrabbed(false);
	        
	        //sets if player 1 is Doge
			if(Keyboard.isKeyDown(Keyboard.KEY_D)){
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
				if(cagetime==true){
				cageEffect.playAsSoundEffect(1.0f, 1.0f, false);
				cagetime=false;
				}
				else{}
			}
			
			//Escape does nothing right now, just here if I decide it has a use.
			if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
				Screen = 0;
			}
	}
	
}
