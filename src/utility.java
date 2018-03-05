public class utility{
	
	
	private int[][] puzzle;
	
	public utility(int[][] puzzle)
	{
		this.puzzle=puzzle;
	}
	
	
	public void savePuzzleFromInput() 
	{
		for(int row = 0; row <9; row++)
		{
			for(int col =0; col <9; col++)
			{
				//converting JTextField's string number into int and make them match with puzzle[row][col]
				int  temp;
				
				//to check if a string is empty use .isEmpty()
				if(GameBoard.board[row][col].getText().isEmpty())
				{
					temp = 0;
				}
				else {
					temp = Integer.parseInt(GameBoard.board[row][col].getText());//copying JTextField[][](what's displaying on the screen) into a local array for further actions
				}
				puzzle[row][col]= temp;
			}
		}
	}

	
	public void printPuzzle() {
		
		for(int row =0; row<9;row++)
		{
			for(int col =0; col <9; col++)
			{
				System.out.print(puzzle[row][col]+ " ");
			}
			System.out.println();
		}

	}
	
	
	
	public void fromConsoleToGUI()
	{
		for(int row =0; row<9;row++)
		{
			for(int col =0; col <9; col++)
			{
				GameBoard.board[row][col].setText(Integer.toString(puzzle[row][col]));
			}
		}
	}
	
	

	public int[][] getPuzzle() {
		return puzzle;
	}
	
	
	
	

}
