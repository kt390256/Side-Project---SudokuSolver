
public class Solver {
	
	int puzzle[][];
	
	
	public Solver(int puzzle[][])
	{
		this.puzzle = puzzle;
		
		
	}
	
	////////////////checking for row//////////////////////////
	boolean CheckForRow(int row, int num)
	{
		for(int curCol = 0; curCol < 9; curCol++)
		{
			if(puzzle[row][curCol]==num)//check this row
				return true;//number found
		}
		return false;//number not found
	}
	///////////////////////////////////////////////////////////
	
	//////////////checking for col//////////////////////////////
	public boolean CheckForCol(int col, int num)
	{
		for(int curRow = 0; curRow < 9; curRow++)
		{
			if(puzzle[curRow][col]==num)
			return true;
		}
		return false;
	}
	////////////////////////////////////////////////////////////
	
	////////////////////////////checking for box/////////////////
	boolean CheckForBox( int boxRow, int boxCol, int num)
	{
		
		for(int curRow = 0; curRow <3; curRow++)
		{
			for(int curCol = 0; curCol < 3; curCol++)
			{
				if(puzzle[curRow+boxRow][curCol+boxCol]==num)
					return true;
			}
		}
		return false;
	}
	///////////////////////////////////////////////////////////////
	
	
	
	////if all 3 functions return true, that means it is safe to try this number
	boolean tryNum(int row, int col, int num) {
		
		return !CheckForRow(row, num) && 
				!CheckForCol(col, num) && 
				!CheckForBox(row - row%3, col - col%3,num);
	}
	
	
	
	///////////////////////////////////////////////BACKTRACKING ALGORITHM//////////////////////////////////////
	
	boolean solve()
	{
		int row = 0;
		int col = 0;
		boolean EmptyCell = false;
		
		//1.Check for empty cell
		for(int curRow = 0; curRow < 9; curRow++)
		{
			for(int curCol = 0; curCol < 9; curCol++)
			{
				if(puzzle[curRow][curCol]==0)
				{
					//recording the locaiton of empty cell
					row = curRow;
					col = curCol;
					EmptyCell = true;
				}
			}
		}
		
		if(EmptyCell==false)
			return true;
		
		//2.Core : TESTING NUMBERS	
		for(int num = 1; num <=9; num++)
		{
			if(tryNum(row, col, num))
			{
				System.out.println("Testing number now");
				puzzle[row][col]=num;
				
				if(solve())
				{//go into a new solve() function, and check for another empty cell
					return true;
				}
				
				puzzle[row][col]=0;
			}
		}
		
		return false;
	}
	
	public void print()
	{
		
		for(int row = 0; row<9;row++)
		{
			for(int col  = 0; col <9; col++)
			{
				System.out.print(puzzle[row][col]+ " ");
			}
			System.out.println();
		}
	}
	
}
