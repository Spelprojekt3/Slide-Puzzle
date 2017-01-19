package controller;
import javax.swing.UIManager;

import model.SlidePuzzleModel;
import view.View;

public class Controller
{
	SlidePuzzleModel model; 
	View view; 

	public Controller(){
		
	View view = new View();   
	SlidePuzzleModel model = new SlidePuzzleModel(); 
		this.view=view; 
		this.model=model; 
		addNumbers();
		view.setButtonInvisible();
		
    }
	
public void addNumbers(){
		
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
};
