package story;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class StoryChars {
	
	static SpriteSheet toto;
	public static Animation totoAnim;
	static Animation totoAnimFlipped;
	
	public static void createSpriteSheets(){
		try {
			toto = new SpriteSheet("resources/story/totodileAnimation.png", 52, 58);
		}catch (SlickException e){
			e.printStackTrace();
		}
	}
	
	public static void createAnimations(){
		totoAnimFlipped = new Animation(toto, 100);
		totoAnim = new Animation(true);
		for(int k=0; k<24; k++)
			totoAnim.addFrame(totoAnimFlipped.getImage(k).getFlippedCopy(true, false), 50);
	}
	
	public static void restartAnimations(){
		if(totoAnim.getFrame()>=24)
			totoAnim.restart();
	}
}