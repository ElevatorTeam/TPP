package story;

public class StoryCreator {

	public static void setCutscene(int arrayChoice){
		if(arrayChoice<=1 || arrayChoice>=3)
			StoryData.setDialog0();
		if(arrayChoice==2)
			StoryData.setDialog2();
	}
}
