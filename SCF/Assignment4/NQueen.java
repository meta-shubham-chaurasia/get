package hello;
public class NQueen{ 
    void printSolution(int board[][],int dimensionOfMatrix) 
    { 
        for (int i = 0; i < dimensionOfMatrix; i++) { 
            for (int j = 0; j < dimensionOfMatrix; j++) 
                System.out.print(" " + board[i][j] 
                                 + " "); 
            System.out.println(); 
        } 
    } 
  
    boolean isSafe(int board[][], int row, int col,int dimensionOfMatrix) 
    { 
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
        for (i = row, j = col; j >= 0 && i < dimensionOfMatrix; i++, j--) 
            if (board[i][j] == 1) 
                return false; 
  
        return true; 
    } 
  
    boolean nQueen(int board[][], int startRow,int dimensionOfMatrix) 
    { 
        if (startRow >= dimensionOfMatrix) {
            return true; 
        }
        for (int i = 0; i < dimensionOfMatrix; i++) { 
            if (isSafe(board, i, startRow,dimensionOfMatrix)) { 
                board[i][startRow] = 1; 
  
                if (nQueen(board, startRow + 1,dimensionOfMatrix) == true){ 
                    return true; 
                }
                board[i][startRow] = 0;
            } 
        } 
        return false; 
    } 
    
  
    public static void main(String args[]) 
    { 
    	NQueen Queen = new NQueen(); 
    	int board[][] = { { 0, 0, 0, 0 }, 
                { 0, 0, 0, 0 }, 
                { 0, 0, 0, 0 }, 
                { 0, 0, 0, 0 } }; 
    	int dimensionOfMatrix=4;
	if (Queen.nQueen(board, 0,dimensionOfMatrix) == false) { 
	  System.out.print("Solution does not exist"); 
	} 
	else{
		Queen.printSolution(board,dimensionOfMatrix); 
	}
    } 
}
