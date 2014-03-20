package story;

import java.util.ArrayList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import menuMode.*;
import gameMode.*;

public class Cutscene extends BasicGameState{

	private int state;
	static ArrayList<String> Dialog = new ArrayList<String>();
	int index=-1;
	int frameCount=0;
	String currentLine;
	String tempLine;
	int nextLetter;
	
	public Cutscene(int state){
		 this.state = state;
	}
	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		currentLine="";
		tempLine="";
	}
	
	public static void setDialog(){
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException{
		g.setFont(TPP.font);
		if(index<Dialog.size()-1)
			g.drawString(currentLine,gc.getWidth()/3,gc.getHeight()/4*3+5);
		else sbg.enterState(TPP.startMenu);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException{
		if(frameCount%300==0){
			index++;
			currentLine="";
			nextLetter=0;
			tempLine=Dialog.get(index);
		}
		if(frameCount%3==0){
			if(currentLine.length()<tempLine.length())
				currentLine+=tempLine.charAt(nextLetter);
			nextLetter++;
		}
		frameCount++;
	}
	
	@Override
	public int getID(){
		return this.state;
	}
	
}