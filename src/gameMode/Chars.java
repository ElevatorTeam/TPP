package gameMode;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.util.ResourceLoader;

public class Chars {
	//This class creates all the animations of all the characters.
	//spritesheets
	static SpriteSheet drag;
	static SpriteSheet flareon;
	static SpriteSheet zapd;
	static SpriteSheet bird;
	static SpriteSheet lazr;
	static SpriteSheet atv;
	
	//animations
	public static Animation dragAnim;
	public static Animation zapdAnim;
	public static Animation birdAnim;
	public static Animation lazrAnim;
	public static Animation atvAnim;
	public static Animation flareonAnim;
	
	public static void createSpriteSheets(){
		try {
			drag = new SpriteSheet("resources/char/dragoniteAnimation.png", 85, 98);
			zapd = new SpriteSheet("resources/char/zapdosAnimation.png", 145, 106);
			bird = new SpriteSheet("resources/char/birdJesusAnimation.png", 124, 124);
			lazr = new SpriteSheet("resources/char/lazrgatrAnimation.png", 82, 98);
			atv = new SpriteSheet("resources/char/atvAnimation.png", 123, 85);
			flareon = new SpriteSheet("resources/char/falseProphetAnimation.png", 59, 93);
		}catch (SlickException e){
			e.printStackTrace();
		}
	}
	
	public static void createAnimations(){
			dragAnim = new Animation(drag, 25);
			zapdAnim = new Animation(zapd, 25);
			birdAnim = new Animation(bird, 25);
			lazrAnim = new Animation(lazr, 25);
			atvAnim = new Animation(atv, 25);
			flareonAnim = new Animation(flareon, 25);
	}
	
	public static void restartAnimations(){
		if(dragAnim.getFrame()>=43)
			dragAnim.restart();
		if(zapdAnim.getFrame()>=29)
			zapdAnim.restart();
		if(birdAnim.getFrame()>=52)
			birdAnim.restart();
		if(lazrAnim.getFrame()>=63)
			lazrAnim.restart();
		if(flareonAnim.getFrame()>=28)
			flareonAnim.restart();
		if(atvAnim.getFrame()>=47)
			atvAnim.restart();
	}
}