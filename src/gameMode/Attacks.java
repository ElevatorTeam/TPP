package gameMode;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Attacks {
	// This class creates all the animations of all the attacks.
	// spritesheets
	static SpriteSheet strike;

	// animations
	public static Animation strikeAnim;

	public static void createSpriteSheets() {
		try {
			strike = new SpriteSheet("resources/atk/strike.png", 100,
					39);
			
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public static void createAnimations() {
		strikeAnim = new Animation(strike, 100);
	}

	public static void restartAnimations() {
		if (strikeAnim.getFrame() >= 8){
			strikeAnim.restart();
		}
	}
}
