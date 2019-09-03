import java.util.*;

public class NQueens {
	
	public static int N = 4; 
	public static int[][] board;
	
	public NQueens(int N) {
		super(); 
		this.N = N; 
		board = new int[N][N]; 
	}
	
	public boolean placeNQueens() throws Exception{
		if(N <= 0) {
			throw new IllegalArgumentException("Error"); 
		}
		return placeNQueen(0);
	}
	

	public static boolean placeNQueen(int col) {
		if(col >= N)
			return true; 
		for(int i = 0; i < N; i++) {
			if(isSafe(board, i, col)) {
				board[i][col] = 1; 
				if(placeNQueen(col+1))
					return true; 
				//backtracking part
				board[i][col] = 0; 
			}
		}
		return false;
	}

	public static void printToConsole(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if(board[i][j] == 1) {
					System.out.print("Q\t");
				}else {
					System.out.print("-\t");
				}
			}
			System.out.println();
		}
	}

	public static boolean isSafe(int board[][], int row, int col ) {
		  int i, j; 
		  
	        /* Check this row on left side */
	        for (i = 0; i < col; i++) 
	            if (board[row][i] == 1) 
	                return false; 
	  
	        /* Check upper diagonal on left side */
	        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) 
	            if (board[i][j] == 1) 
	                return false; 
	  
	        /* Check lower diagonal on left side */
	        for (i = row, j = col; j >= 0 && i < N; i++, j--) 
	            if (board[i][j] == 1) 
	                return false; 
	  
	        return true;

	}

	

}