package MenuMode;

import gameMode.Map;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


public class MenuClick extends MenuCommands {
	
	int width;
	int height;
	StateBasedGame sbg;

	public void initClick(StateBasedGame statebased, int w, int h) {
		width=w;
		height=h;
		sbg = statebased;
	}
	
	public void MainClick(int button, int x, int y){
		if((x>(width/8*5) && y>height/4*3))
	     {
	         if(button==0){
	        	 System.exit(0);
	         }
	     }
	     
	     //
	     //starting the game
	     //This first section is for AI singleplayer.
	     if((x<(width/2)  && y>height/2))
	     {
	    	 if(button==0){
	        	IsThereAI = true;
	        	Screen=1;
	         }
	     }
	     else if((x>(width/2)  && y>height/2))
	     {
	    	 if(button==0){
		        	IsThereAI = false;
		        	Screen=1;
	         }
	     }
	    
	}
	
	public void LevelClick(int button, int x, int y) throws SlickException{
		if(IsThereAI){
	    	 if((x<((width/5))))
	    	 {
	    		 if(button==0){
	    			 System.out.println("click");
	    			 Map.gameManager.mapControl=0;
	    			 Map.gameManager.mapInit();
	    			 theme.stop();
	    			 Map.gameManager.IsThisAI=true;
	    			 sbg.enterState(TPP.map);
	    		 }
	    	 }

	    	 if((x>((width/5)*1) && x<((width/5)*2)))
	    	 {
	    		 if(button==0){
	    			 Map.gameManager.mapControl=1;
	    			 Map.gameManager.mapInit();
	    			 theme.stop();
	    			 Map.gameManager.IsThisAI=true;
	    			 sbg.enterState(TPP.map);
	    		 }
	    	 }

	    	 if((x>((width/5)*2) && x<((width/5)*3)))
	    	 {
	    		 if(button==0){ 
	    			 Map.gameManager.mapControl=2;
	    			 Map.gameManager.mapInit();
	    			 theme.stop();
	    			 Map.gameManager.IsThisAI=true;
	    			 sbg.enterState(TPP.map);
	    		 }
	    	 }

	    	 if((x>((width/5)*3) && x<((width/5)*4)))
	    	 {
	    		 if(button==0){
	    			 Map.gameManager.mapControl=3;
	    			 Map.gameManager.mapInit();
	    			 theme.stop();
	    			 Map.gameManager.IsThisAI=true;
	    			 sbg.enterState(TPP.map);
	    		 }
	    	 }

	    	 if((x>((width/5)*4)))
	    	 {
	    		 if(button==0){
	    			 Map.gameManager.mapControl=4;
	    			 Map.gameManager.mapInit();
	    			 theme.stop();
	    			 Map.gameManager.IsThisAI=true;
	    			 sbg.enterState(TPP.map);
	    		 }
	    	 }
	     }
	     
	     //
	     //Set up for the Multiplayer maps
	     else{
	    	 if((x<((width/5)*1)))
	    	 {
	    		 if(button==0){
	    			 Map.gameManager.mapControl=0;
	    			 Map.gameManager.mapInit();
	    			 theme.stop();
	    			 Map.gameManager.IsThisAI=false;
	    			 sbg.enterState(TPP.map);
	    		 }
	    	 }
	    	 if((x>((width/5)*1) && x<((width/5)*2)))
	    	 {
	    		 if(button==0){
	    			 Map.gameManager.mapControl=1;
	    			 Map.gameManager.mapInit();
	    			 theme.stop();
	    			 Map.gameManager.IsThisAI=false;
	    			 sbg.enterState(TPP.map);
	    		 }
	    	 }
	    	 if((x>((width/5)*2) && x<((width/5)*3)))
	    	 {
	    		 if(button==0){
	    			 Map.gameManager.mapControl=2;
	    			 Map.gameManager.mapInit();
	    			 theme.stop();
	    			 Map.gameManager.IsThisAI=false;
	    			 sbg.enterState(TPP.map);
	    		 }
	    	 }
	    	 if((x>((width/5)*3) && x<((width/5)*4)))
	    	 {
	    		 if(button==0){
	    			 Map.gameManager.mapControl=3;
	    			 Map.gameManager.mapInit();
	    			 theme.stop();
	    			 Map.gameManager.IsThisAI=false;
	    			 sbg.enterState(TPP.map);
	    		 }
	    	 }
	    	 if((x>((width/5)*4))){
	    		 if(button==0){
	    			 Map.gameManager.mapControl=4;
	    			 Map.gameManager.mapInit();
	    			 theme.stop();
	    			 Map.gameManager.IsThisAI=false;
	    			 sbg.enterState(TPP.map);
	    		 }
	    	 }
	     } 
		
	}
	
	
}