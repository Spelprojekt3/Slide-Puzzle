package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SlidePuzzleModel implements Game
{
	private ArrayList<Integer> numberList = new ArrayList<Integer>();
	private int[][] board = new int[4][4];
	private int[][] sortedBoard = new int[4][4];

	public SlidePuzzleModel()
	{
		createNumberList();
		shuffleNumberList();
		createGameBoard(numberList);
		currentBoard();
		createdSortedBoard();
	}

	public void createNumberList()
	{
		for (int i = 0; i < 16; i++) {
			numberList.add(i);
		}
	}

	public void createdSortedBoard()
	{
		int k = 1;
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				sortedBoard[i][j] = k;
				k++;
			}
			
		}
		sortedBoard[3][3] = 0;
	}

	public boolean isPuzzleSolved()
	{
		if(Arrays.deepEquals(sortedBoard, board))
			return true;
		else
			return false;
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

	public boolean doWinnerCheck()
	{
		if(board[0][0] == sortedBoard[0][0] && board[3][3] == sortedBoard[3][3])
		{
			System.out.println("Checking if puzzle is solved");
			return true;
		}
		else
			return false;
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

		if(i == (x-1) && j == y)
			return true;
		if(i == (x+1) && j == y)
			return true;
		if(i == x && j == (y+1))
			return true;
		if(i == x && j == (y-1))
			return true;
		else
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

