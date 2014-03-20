package story;

import java.util.ArrayList;

public class StoryCreator {
	//I had an idea for what is below, but right now I don't need it (nor can I remember what it is for).
	//ArrayList<ArrayList<String>> ArrayOfDialogs = new ArrayList<ArrayList<String>>();
	static ArrayList<String> DialogScene1= new ArrayList<String>();
	static ArrayList<String> DialogScene2= new ArrayList<String>();

	public static void initializeStory(){
		
	}
	
	public static void setDialog(int arrayChoice){
		if(arrayChoice==1)
			setDialog1();
		if(arrayChoice==2)
			setDialog2();
	}
	
	public static void setDialog1(){
		DialogScene1.add("I never wanted to grow up.");
		DialogScene1.add("Why would I need to?");
		DialogScene1.add("You took care of us.");
		DialogScene1.add("You would always be there for us.");
		DialogScene1.add("Your last words to me were, \"Be Strong.\"");
		DialogScene1.add("");
		DialogScene1.add("I never wanted to grow up.");
		Cutscene.Dialog=DialogScene1;
	}
	
	public static void setDialog2(){
		DialogScene1.add("The Second Set Up Made It!");
	}
}
