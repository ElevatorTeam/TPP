package gameMode;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Chars {
	//This class creates all the animations of all the characters.
	//spritesheets
	static SpriteSheet drag;
	static SpriteSheet flareon;
	static SpriteSheet zapd;
	static SpriteSheet bird;
	
	//animations
	public static Animation dragAnim;
	public static Animation zapdAnim;
	public static Animation birdAnim;
	public static Animation flareonAnim;
	
	public static void createSpriteSheets(){
		try {
			drag = new SpriteSheet("resources/char/dragoniteAnimation.png", 85, 98);
			zapd = new SpriteSheet("resources/char/zapdosAnimation.png", 145, 106);
			bird = new SpriteSheet("resources/char/birdJesusAnimation.png", 124, 124);
			flareon = new SpriteSheet("resources/char/falseProphetAnimation.png", 59, 93);
		}catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public static void createAnimations(){
			dragAnim = new Animation(drag, 25);
			zapdAnim = new Animation(zapd, 25);
			birdAnim = new Animation(bird, 30);
			flareonAnim = new Animation(flareon, 30);
	}
	
	public static void restartAnimations(){
		if(dragAnim.getFrame()==43)
	    	dragAnim.restart();
		if(zapdAnim.getFrame()==29)
	    	zapdAnim.restart();
		if(birdAnim.getFrame()==52)
		   birdAnim.restart();
		if(flareonAnim.getFrame()==28)
		   flareonAnim.restart();
	}
}