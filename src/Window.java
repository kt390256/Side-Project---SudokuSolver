import java.awt.Canvas;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Window {
	
	private int puzzle[][] = new int[9][9];
	
	//screen title, and dimension
	private String title;
	private int width, height;
	
	//Jframe stuffs
	private JFrame frame;
	private Canvas canvas;
	private JButton save, solve;
	
	//class stuffs
	private utility u;
	private Solver solver;
	
	public Window(String title, int width, int height)
	{
		//initializing properties for the displaying window
		this.title = title;
		this.width = width;
		this.height =height;
		
		createWindow();
	}
	
	
	private void createWindow() {
		
		
		////////////Main Frame////////////////
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		//////////////////////////////////////
		
		
		///adding the puzzle to the frame
		new GameBoard(this);
		
		///utility buttons
		save = new JButton();
		save.setLocation(new Point(550, 100));
		save.setSize(new Dimension(80,30));
		save.setToolTipText("Click here to save your puzzle to the system!");
		save.setText("Save");
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				u = new utility(puzzle);
				u.savePuzzleFromInput();
				u.printPuzzle();
			}
		});
		frame.add(save);
		
		solve = new JButton("Solve");
		solve.setLocation(new Point(550, 200));
		solve.setSize(new Dimension(80, 30));
		solve.setToolTipText("Click here to solve");
		solve.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				solver = new Solver(puzzle);
				if(solver.solve())
				{
					u.printPuzzle();
				}
				else
					System.out.println("Such puzzle doesn't have a solution!");
				
				u.fromConsoleToGUI();

			}
			
		});
		frame.add(solve);
		////////////////////////////////////////////////////////////////////////
		
		////////////Canvas///////////////////////
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		frame.add(canvas);
		/////////////////////////////////////////
		
		
		
		////////Menu bar////////////////
		frame.setJMenuBar(createMenuBar());
		/////////////////////////////////
		
		//frame.pack();
		frame.setVisible(true);//setVisible is always the last function
		
		
	}
	
	
	private JMenuBar createMenuBar() {
	
	//menu bar
	JMenuBar menuBar = new JMenuBar();
	
	//menu items
	JMenu fileMenu = new JMenu("File");
	JMenu windowMenu = new JMenu("System");
	
	//sub menu item
	JMenuItem exit = new JMenuItem("Exit");
	
	
	//add main menu items
	menuBar.add(fileMenu);
	menuBar.add(windowMenu);
	
	//add sub menu stuffs to main menu item

	windowMenu.add(exit);
	
	//sub-menu functionality - perform action when this is click on the sub-menu
	

		
	
	exit.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	});
	
	return menuBar;
	
	}

	////////////////////////////////getters and setters////////////////////////////////////////////
	public JFrame getFrame() {
		return frame;
	}


	public Canvas getCanvas() {
		return canvas;
	}



	
	
	
	
	
	

}
