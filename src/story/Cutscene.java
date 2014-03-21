package story;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import menuMode.*;
import gameMode.*;

public class Cutscene extends BasicGameState{

	private int state;
	public static ArrayList<String> Dialog = new ArrayList<String>();
	int index=-1;
	int frameCount=0;
	String currentLine;
	String tempLine;
	int nextLetter;
	Image wood;
	Image mount;
	Image sky;
	Image grass;
	
	public Cutscene(int state){
		 this.state = state;
	}
	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		currentLine="";
		tempLine="";
		wood = new Image("resources/story/Trees.png");
		mount = new Image("resources/story/Mountains.png");
		sky  = new Image("resources/story/sky.png");
		grass  = new Image("resources/story/Grass.png");
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException{
		sky.draw(0,0, gc.getWidth(), gc.getHeight());
		mount.draw(0,0, gc.getWidth(), gc.getHeight());
		wood.draw(0,5, gc.getWidth(), gc.getHeight(), Color.white);
		StoryChars.totoAnim.drawFlash(500,460, StoryChars.totoAnim.getWidth(), StoryChars.totoAnim.getHeight(), Color.black);
		grass.draw(0,0, gc.getWidth(), gc.getHeight(), Color.gray);
		g.setFont(TPP.font);
		if(index<Dialog.size())
			g.drawString(currentLine,gc.getWidth()/24*7,gc.getHeight()/4*3+5);
		else{
			index=-1;
			nextLetter=0;
			currentLine="";
			tempLine="";
			frameCount=0;
			sbg.enterState(TPP.startMenu);
		}
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException{
		if(frameCount%300==0){
			index++;
			currentLine="";
			nextLetter=0;
			if(index<Dialog.size())
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