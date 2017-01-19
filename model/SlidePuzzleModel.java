package model;

import java.util.ArrayList;
import java.util.Collections;

public class SlidePuzzleModel implements Game
{
	private ArrayList<Integer> numberList = new ArrayList<Integer>();
	private int[][] board = new int[4][4]; 

	public SlidePuzzleModel()
	{
		createNumberList();
		shuffleNumberList();
		createGameBoard(numberList);
		currentBoard(); 
	}
	
	

	public void createNumberList()
	{
		for (int i = 0; i < 16; i++) {
			numberList.add(i);
		}
	}

	public void shuffleNumberList()
	{
		Collections.shuffle(numberList);
	}

	public void createGameBoard(ArrayList<Integer> list)
	{
		int index = 0;
		for (int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				board[i][j] = list.get(index);
				index++;
			}
		}

	}

	public void currentBoard()
	{
		for (int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				System.out.print(" " + board[i][j] + " ");
			}
			
			System.out.println("");
		}
		
		System.out.println("");
	}
	
	public int getPositionZero()
	{
		
		for (int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				if(board[i][j]==0){
					return  (i*10)+j ; 
				}
				
			}
		}
		return 0;	
	}
	
	
	

	public int[][] getBoard() {
		return board;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}

	public void swap(int i ,int j, int k, int l){
	
	int z=getValue(i,j);
	int h=getValue(k,l);
	
	board[i][j]=h;
	board[k][l]=z; 
		 
		
	}
	
	public int getValue(int i, int j){
		
		return board[i][j]; 
			
	}
	
	
	@Override
	public boolean move(int i, int j) {
		
		int x=getPositionZero()/10; 
		int y=getPositionZero()%10; 
		

		return false;
	}
	
	

	@Override
	public String getStatus(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}
}

