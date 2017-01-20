package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;

import model.SlidePuzzleModel;
import view.View;

public class Controller
{
	GameButtonListener gamebuttonlistner; 
	static SlidePuzzleModel model; 
	static View view; 

public Controller(){
		
	View view = new View();   
	SlidePuzzleModel model = new SlidePuzzleModel(); 
		
	    this.view=view; 
		this.model=model; 
		addNumbers();
		view.setButtonInvisible();
		
		GameButtonListener gamebuttonlistener = new GameButtonListener(view,model);
		this.gamebuttonlistner = gamebuttonlistener; 
		
		for (int j = 0; j< view.getGameButtons().length; j++) {
			
		
		 for (int i = 0; i < view.getGameButtons().length; i++) {
	         view.getGameButtons()[i][j].addActionListener(gamebuttonlistner);
	     }
		}
		
    }
	
	
	
public static void addNumbers(){
		
		for(int i=0; i<model.getBoard().length;i++)
		{
			for(int j=0; j<model.getBoard().length;j++){
			view.getGameButtons()[i][j].setText(Integer.toString(model.getBoard()[i][j]));
			
		}
	}
}	
	
	public static void main(String[] args)
	{
	try {
        // select Look and Feel
        UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
        // start application
    } catch (Exception ex) {
        ex.printStackTrace();
    }
	        Controller controller = new Controller();
	    }

public static class GameButtonListener implements ActionListener {

	    View view;
	    SlidePuzzleModel model; 
	
public GameButtonListener(View view , SlidePuzzleModel model) {
        
		this.view = view;
		this.model= model; 
		
	      
	    }

	    public void actionPerformed(ActionEvent e) {
	   	
	    	
	  for (int j = 0; j< view.getGameButtons().length; j++) {
	        	
	         for(int i=0; i< view.getGameButtons().length;i++){
	        		
	        	 if (e.getSource() == view.getGameButtons()[i][j]){
	        		
	        		 int x=model.getPositionZero()/10;
	        		 int y=model.getPositionZero()%10; 
	        		 	if(model.move(i, j) == true)
	        		 		{
				        		 model.swap(x, y, i, j);
				        		 model.currentBoard();
				        		 addNumbers();
				        		 view.setButtonInvisible();
				        		 	if(model.doWinnerCheck() == true)
				        		 		model.isPuzzleSolved();
	        		 		}
	        		 
	        	 }
	 	
	              	
	                }
	        	}
        }
    }
}