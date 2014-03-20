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
	static SpriteSheet dragFlipped;
	static SpriteSheet flareonFlipped;
	static SpriteSheet zapdFlipped;
	static SpriteSheet birdFlipped;
	static SpriteSheet lazrFlipped;
	static SpriteSheet atvFlipped;
	
	//animations
	public static Animation dragAnim;
	public static Animation dragAnimFlipped;
	public static Animation zapdAnim;
	public static Animation zapdAnimFlipped;
	public static Animation birdAnim;
	public static Animation birdAnimFlipped;
	public static Animation lazrAnim;
	public static Animation lazrAnimFlipped;
	public static Animation atvAnim;
	public static Animation atvAnimFlipped;
	public static Animation flareonAnim;
	public static Animation flareonAnimFlipped;
	
	public static void createSpriteSheets(){
		try {
			drag = new SpriteSheet("resources/char/dragoniteAnimation.png", 85, 98);
			zapd = new SpriteSheet("resources/char/zapdosAnimation.png", 145, 106);
			bird = new SpriteSheet("resources/char/birdJesusAnimation.png", 124, 124);
			lazr = new SpriteSheet("resources/char/lazrgatrAnimation.png", 82, 98);
			atv = new SpriteSheet("resources/char/atvAnimation.png", 123, 85);
			flareon = new SpriteSheet("resources/char/falseProphetAnimation.png", 59, 93);
			dragFlipped = new SpriteSheet("resources/char/dragoniteFlippedAnimation.png", 85, 98);
			zapdFlipped = new SpriteSheet("resources/char/zapdosAnimation.png", 145, 106);
			birdFlipped = new SpriteSheet("resources/char/birdJesusAnimation.png", 124, 124);
			lazrFlipped = new SpriteSheet("resources/char/lazrgatrAnimation.png", 82, 98);
			atvFlipped = new SpriteSheet("resources/char/atvAnimation.png", 123, 85);
			flareonFlipped = new SpriteSheet("resources/char/falseProphetAnimation.png", 59, 93);
		}catch (SlickException e){
			e.printStackTrace();
		}
	}
	
	public static void createAnimations(){
			dragAnimFlipped = new Animation(dragFlipped, 25);
			dragAnim = new Animation(drag, 25);
			
			zapdAnimFlipped = new Animation(zapd, 25);
			zapdAnim = new Animation(true);
			for(int k=0; k<30; k++)
				zapdAnim.addFrame(zapdAnimFlipped.getImage(k).getFlippedCopy(true, false), 25);
			
			birdAnimFlipped = new Animation(bird, 25);
			birdAnim = new Animation(true);
			for(int k=0; k<=52; k++)
				birdAnim.addFrame(birdAnimFlipped.getImage(k).getFlippedCopy(true, false), 25);
			
			lazrAnimFlipped = new Animation(lazr, 25);
			lazrAnim = new Animation(true);
			for(int k=0; k<=63; k++)
				lazrAnim.addFrame(lazrAnimFlipped.getImage(k).getFlippedCopy(true, false), 25);
			
			flareonAnimFlipped = new Animation(flareon, 25);
			flareonAnim = new Animation(true);
			for(int k=0; k<28; k++)
				flareonAnim.addFrame(flareonAnimFlipped.getImage(k).getFlippedCopy(true, false), 25);
			
			atvAnimFlipped = new Animation(atv, 25);
			atvAnim = new Animation(true);
			for(int k=0; k<=47; k++)
				atvAnim.addFrame(atvAnimFlipped.getImage(k).getFlippedCopy(true, false), 25);
	}
	
	public static boolean checkDirection(int x1,int x2){
		if(x1<x2){
			return true;
		}
		return false;
	}
	
	public static void restartAnimations(){
		if(dragAnim.getFrame()>=43)
			dragAnim.restart();
		if(dragAnimFlipped.getFrame()>=43)
			dragAnimFlipped.restart();
		if(zapdAnim.getFrame()>=29)
			zapdAnim.restart();
		if(zapdAnimFlipped.getFrame()>=29)
			zapdAnimFlipped.restart();
		if(birdAnim.getFrame()>=52)
			birdAnim.restart();
		if(birdAnimFlipped.getFrame()>=52)
			birdAnimFlipped.restart();
		if(lazrAnim.getFrame()>=63)
			lazrAnim.restart();
		if(lazrAnimFlipped.getFrame()>=63)
			lazrAnimFlipped.restart();
		if(flareonAnim.getFrame()>=28)
			flareonAnim.restart();
		if(flareonAnimFlipped.getFrame()>=28)
			flareonAnimFlipped.restart();
		if(atvAnim.getFrame()>=47)
			atvAnim.restart();
		if(atvAnimFlipped.getFrame()>=47)
			atvAnimFlipped.restart();
	}
}