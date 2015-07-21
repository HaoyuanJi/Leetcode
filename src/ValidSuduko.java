
import java.util.*;

public class ValidSuduko {
	
   	public static boolean isValidSodoku(char[][] board){
        int row = board.length;
    	int colunm = board[0].length;
	    //check row
	    Set<Character> tmp = new HashSet<Character>();
		for(int i = 0; i < row; i++){
			for(int j = 0; j < colunm; j++){
				
				if(board[i][j] !='.'){
				
					if(!tmp.contains(board[i][j])){
						tmp.add(board[i][j]);
					}else{
						return false;
					}
				}

			}
			tmp.clear();
		}
		
		// check column
		for(int i = 0; i < colunm; i++){
			for(int j = 0; j < row; j++){
				if(board[j][i] != '.'){
					if(!tmp.contains(board[j][i])){
						tmp.add(board[j][i]);
					}else{
						return false;				
					}
				}
			}
			tmp.clear();
		}
		
		int count = board[0].length/3;
		//check square includes 9 elements.
		for(int k = 0; k <count; k++){
		  for(int m = 0; m < count; m++)
		  {
			for(int i = k*count; i < 3 + k*count; i++){
				for(int j = m*count; j < 3 + m*count; j++){
					if(board[i][j] != '.'){
						if(!tmp.contains(board[i][j])){
							tmp.add(board[i][j]);
						}else{
							return false;
						}
				}
			}
		   }
			tmp.clear();
		}
	}
	return true;
   	}
   	public static void main(String args[]){
		char[][] board ={
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','.'},
				{'4','.','.','8','.','3','.',',','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'},
	
		};
		
		String[] tmp = {"..4...63.",".........","5......9.","...56....","4.3.....1","...7.....","...5.....",".........","........."};
		
		char[][] board2 = new char[9][9];
		
		for(int i = 0; i < tmp.length;i++){
			board2[i] = tmp[i].toCharArray();
		}
		
		//ValidSudoku test = new IsValidSudoku();
		System.out.println(isValidSodoku(board2));
	}
}
