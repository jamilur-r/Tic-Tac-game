	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	import javax.swing.border.LineBorder;
	
	
	public class TicTacFrame extends JFrame {
	
		// Whoes turn
		
		private char turn = 'x';
		// Create cell grid
		
		private Cell [][] cells = new Cell[3][3];
		//Create status label
		
		JLabel jlblStatus = new JLabel("x's turn to play");
		
		public TicTacFrame(){
			
			//Create Panel
			
			JPanel panel = new JPanel(new GridLayout(3,3,0,0));
			
			for(int i=0; i<3;i++){
				for(int j=0; j<3; j++){
					panel.add(cells[i][j]= new Cell());
					
					panel.setBorder(new LineBorder(Color.black, 1));
					jlblStatus.setBorder(new LineBorder(Color.yellow, 2));
					
					add(panel, BorderLayout.CENTER);
					add(jlblStatus, BorderLayout.SOUTH);					
					
				}
		
				}
			}
		
		public boolean isFull(){
			for(int i=0; i<3; i++)
				for(int j=0; j<3; j++)
					if(cells[i][j].getToken() == ' ')
						return false;
					
					return true;
					
		}
		
		public boolean isWon(char token){
			for(int i=0; i<3; i++){
				if((cells[i][0].getToken() == token)
					&&(cells[i][1].getToken() == token)
					&&(cells[i][2].getToken() == token))
				{
					
					return true;
				}
			}
			for(int j=0; j<3; j++){
				if((cells[0][j].getToken() == token)
						&&(cells[1][j].getToken() == token)
						&&(cells[2][j].getToken() == token))
					{
						
						return true;
					}
			}
			
			if((cells[0][0].getToken() == token)
					&&(cells[1][1].getToken() == token)
					&&(cells[2][2].getToken() == token))
				{
					
					return true;
				}
			if((cells[0][2].getToken() == token)
					&&(cells[1][1].getToken() == token)
					&&(cells[2][0].getToken() == token))
				{
					
					return true;
				}
			
			else {
				
				return false;
			}
			
		}
		
		
		public class Cell extends JPanel{
			
			private char token = ' ';
			
			public Cell(){
				
				setBorder(new LineBorder(Color.black, 1));
				addMouseListener(new myMouseListener());
				
			}
			
			public char getToken(){
				
				return token;	
			}
			
			public void setToken(char c){
				token = c;
				repaint();
			}
			
			@Override
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				
				if(token =='x'){
					
					g.drawLine(10, 10, getWidth() -10, getHeight() -10);
					g.drawLine(getWidth() -10, 10, 10, getHeight() -10);
					
				}
				
				else if(token == 'o'){
					
					g.drawOval(10, 10, getWidth() -20, getHeight() -20);
				}
			}
			
			private class myMouseListener extends MouseAdapter{
				@Override
				public void mouseClicked(MouseEvent e)
				{
					if(token == ' ' && turn != ' '){
						setToken(turn);
						
						}
					if(isWon(turn)){
						jlblStatus.setText(turn + "Won ! Game over");
						turn =' ';
					}
					else if(isFull()){
						jlblStatus.setText("Game Tie! Game Over");
						turn = ' ';
					} 
					
					else{
						turn =(turn == 'x') ? 'o' : 'x';
						jlblStatus.setText(turn + "'s turn");
					}
					
				}
				
			}

		}
		
		
	}

	















	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	