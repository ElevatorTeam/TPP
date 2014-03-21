package story;

import java.util.ArrayList;

public class StoryData {
	//I had an idea for what is below, but right now I don't need it (nor can I remember what it is for).
	//ArrayList<ArrayList<String>> ArrayOfDialogs = new ArrayList<ArrayList<String>>();
	static ArrayList<String> DialogScene0= new ArrayList<String>();
	static ArrayList<String> DialogScene1= new ArrayList<String>();
	static ArrayList<String> DialogScene2= new ArrayList<String>();
	
	public static void setDialog0(){
		DialogScene0.add("Whoa! The game picked a cutscene that doesn't exist!");
		Cutscene.Dialog=DialogScene0;
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
		DialogScene2.add("The Second Set Up Made It!");
		Cutscene.Dialog=DialogScene2;
	}
}
