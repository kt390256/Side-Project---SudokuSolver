import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class GameBoard extends JFrame{

	private Window w;
	
	public static int BoardSize = 9;
	private Font fnt1 = new Font("SansSerif", Font.BOLD, 20);
	
	//Arrays
	public static JTextField[][] board = new JTextField[BoardSize][BoardSize];
	public static int[][] puzzle ={
			
			   {5, 3, 4, 6, 0, 0, 9, 0, 0}, 
		       {6, 7, 2, 1, 9, 5, 3, 4, 0},
		       {1, 9, 0, 3, 4, 2, 5, 0, 7},
		       {0, 5, 9, 7, 6, 1, 4, 2, 3},
		       {4, 0, 6, 0, 5, 0, 7, 0, 0},
		       {7, 0, 0, 0, 2, 4, 8, 5, 6},
		       {9, 6, 1, 0, 3, 0, 2, 0, 0},
		       {2, 0, 7, 4, 0, 9, 0, 3, 5},
		       {3, 4, 0, 2, 0, 0, 0, 7, 0}
		       
		};
	
	private AbstractDocument filter;
	
	public GameBoard(Window w) {
	
	this.w = w;

	createJTextFieldBoard();
	}
	
	
	private void createJTextFieldBoard() {
	
		for(int row = 0; row < 9; row++)
		{
			for(int col = 0; col < 9; col++)
			{
				//add a JTextField
				board[row][col]=new JTextField();
				w.getFrame().add(board[row][col]);
				
				///////Single input filtering//////////////////////////////////////////////////////////////
				filter = (AbstractDocument) board[row][col].getDocument();//create a filter fot this element
				filter.setDocumentFilter(new DocumentFilter() {
					
					int max = 1;
					
					@Override
					public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException{
						int documentLength = fb.getDocument().getLength();
						if(documentLength - length + text.length() <= max)
							super.replace(fb, offset, length, text, attrs);
					}
					
				});
				////////////////////////////////////////////////////////////////////////////////////////////
				
				board[row][col].setSize(new Dimension(50, 50));
				
				
				
				
				////////////////////////////////////SETTING LOCATIONS AND SEPERATING ALL BOXES///////////////////////////////////////
				
				/*IMPORTANT
				 * 
				 *board[row][col].setLocation(row, col)				 
				 * 
				 * this is the typical way to set a box location, however, if you do it this way
				 * all rows boxes will become col boxes, and vice visa for all col boxes
				 * 
				 * board[1][2].setLocation(50*1, 50*2) will set the box coordinate to be (50,100) but board[1][2]'s coordinate is (100, 50)
				 * 
				 */
				
				if(row>2 && row <6)//At the 3rd row and 3rd+ row but less than 6th row(affecting 3rd, 4th, 5th row), y position of those boxes are 20 px further away from the regular ones
				{
					board[row][col].setLocation(50*col+10, 50*row+18);
					////////for second horizontal section
					if(col ==3)
					{
						board[row][col].setLocation(51*col+15, 50*row+18);	
					}
					else if(col == 4 ){
						board[row][col].setLocation(51*col+14, 50*row+18);	
					}
					else if(col == 5 ){
						board[row][col].setLocation(51*col+13, 50*row+18);	
					}
					/////for third horizontal section
					else if(col == 6 ){
						board[row][col].setLocation(51*col+20, 50*row+18);	
					}
					else if(col == 7){
						board[row][col].setLocation(51*col+19, 50*row+18);	
					}
					else if(col == 8){
						board[row][col].setLocation(51*col+18, 50*row+18);	
					///////////////////////////////////////
					}
				}
				else if(row>5)//Affecting 6th row and beyond
				{
					board[row][col].setLocation(50*col+10, 50*row+25);	
					////////for second horizontal section
					if(col ==3)
					{
						board[row][col].setLocation(51*col+15, 50*row+25);	
					}
					else if(col == 4 ){
						board[row][col].setLocation(51*col+14, 50*row+25);	
					}
					else if(col == 5 ){
						board[row][col].setLocation(51*col+13, 50*row+25);	
					}
					/////for third horizontal section
					else if(col == 6 ){
						board[row][col].setLocation(51*col+20, 50*row+25);	
					}
					else if(col == 7){
						board[row][col].setLocation(51*col+19, 50*row+25);	
					}
					else if(col == 8){
						board[row][col].setLocation(51*col+18, 50*row+25);	
					///////////////////////////////////////
					}
				}
				else {
					board[row][col].setLocation(50*col+10, 10+50*row);
					
					
					if(col ==3)
					{
						board[row][col].setLocation(51*col+15, 10+50*row);	
					}
					else if(col == 4 ){
						board[row][col].setLocation(51*col+14, 10+50*row);	
					}
					else if(col == 5 ){
						board[row][col].setLocation(51*col+13, 10+50*row);	
					}
					/////for third horizontal section
					else if(col == 6 ){
						board[row][col].setLocation(51*col+20, 10+50*row);	
					}
					else if(col == 7){
						board[row][col].setLocation(51*col+19, 10+50*row);	
					}
					else if(col == 8){
						board[row][col].setLocation(51*col+18, 10+50*row);	
						}
				}
				
				board[row][col].setText(Integer.toString(puzzle[row][col]));
				board[row][col].setHorizontalAlignment(JTextField.CENTER);
				board[row][col].setFont(fnt1);
				
				//board[row][col].setEditable(false);
			}
		}
		
	
	}//end of this function


	public int[][] getPuzzle() {
		return puzzle;
	}



	
	
	
}
