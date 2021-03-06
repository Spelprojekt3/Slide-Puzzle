package model;

import java.util.ArrayList;
import java.util.Collections;

public class SlidePuzzleModel
{
	private ArrayList<Integer> numberList = new ArrayList<Integer>();
	private int[][] board = new int[4][4]; 

	public SlidePuzzleModel()
	{
		createNumberList();
		shuffleNumberList();
		createGameBoard(numberList);
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
	}
}
