// Tic Toc Toe Game in java  Source file "create by ANK";
import java.util.*;
class TicTacToe{
		public static final String ANSI_GREEN = "\u001B[32m";
		public static final String Red = "\u001B[31m";
		public static final String Nrml= "\u001B[0m";
	char [] [] board; 
	public TicTacToe(){
		 board = new char [3][3];
		 initBoard();
	}
	void initBoard(){
			for(int i = 0 ; i<board.length;i++){
			for(int j=0;j< board[i].length;j++){
				board[i][j]= ' ';
			}
		}
	}
	void dispBoard(){
		System.out.println(" -------------- ");
		for(int i = 0 ; i<board.length;i++){
			System.out.print(" | ");
			for(int j=0;j< board[i].length;j++){
				System.out.print(board[i][j] + " |  " );
			}
			System.out.println();
			System.out.println(" --------------");
		}
	}
	void placeMark(int row , int col , char mark)
	{
		if(row>=0 && row<= 2 && col >=0 && col <= 2)
		{
			board[row][col]= mark;
		}else {
			System.out.println(Red+"Invalid position , Enter between 0 and 2. "+Nrml);
		}
	}
	Boolean checkColWin()
	{
		for(int j=0 ; j<=2; j++){
			if(board[0][j]!=' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j]  )
			{
				return true;
			}
		}
		return false ;
	}
	Boolean checkRowWin()
	{
		for(int i=0;i<=2;i++)
		{
			if(board[i][0] !=' ' && board[i][0]== board[i][1] && board[i][1] == board[i][2])
			{
				return true;
			}
		}
		return false ;
	}
	Boolean checkDiagWin(){
		if(board[0][0]!=' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2] 
			|| board[0][2] !=' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0] )
			{
				return true;
			}else{
			return false ;
			}
	}
 
 }
public class TicToc{
		public static final String ANSI_GREEN = "\u001B[32m";
		public static final String Red = "\u001B[31m";
		public static final String Nrml= "\u001B[0m";
			
		
	public static void main (String [] args){
		TicTacToe t = 	new TicTacToe(); 
		t.dispBoard();
		Scanner S = new Scanner(System.in);
		System.out.println(Red+"Enter the value of Rows and colums between 0 and 2 "+Nrml);
			for(int num= 0 ;num<9;num++){
				for(int i=0;i<2; i++){
						int tRow , tCol;
						
						if(i==0){
									System.out.println(ANSI_GREEN+"Player I :"+Nrml);
						}else {
									System.out.println(ANSI_GREEN+"Player II :"+Nrml);
						}
						System.out.print("Enter value for Row : ");
						tCol=S.nextInt();
						System.out.print("Enter value for Colum : ");
						tRow = S.nextInt();
						if(tCol > 2 || tRow >2 ){
							--i;
						}
						if(i == 0 ){
									t.placeMark(tCol,tRow,'X');
									t.dispBoard();
						}else {
									t.placeMark(tCol,tRow,'O');
									t.dispBoard();
						}
							if( t.checkColWin() || t.checkRowWin() || t.checkDiagWin() ){
						if(num%2==1){
							System.out.println(ANSI_GREEN +"Player II won!, Player I LOOSER "+Nrml);
							break;
						}else {
							System.out.println(ANSI_GREEN +"Player I won!, Player II LOOSER "+Nrml);
							break;
						}
					}
					}
						if( t.checkColWin() || t.checkRowWin() || t.checkDiagWin() ){
							break;
						}		
			}
	}
}