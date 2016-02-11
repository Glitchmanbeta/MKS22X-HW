//Windows NT 10.0.10582 "10"
public class QueenBoard{

	private int size;
	private int[][] board;

	public QueenBoard(){
		size = 8;
		board = new int[size][size];
		for(int row = 0; row < board.length; row++){
			for(int col = 0; col < board[row].length; col++){
				board[row][col] = 0;
			}
		}
	}

	public QueenBoard(int n){
		size = n;
		board = new int[size][size];
	}

	public int getSize(){
		return size;
	}

	public String toString(){
		String s = "";
		for(int row = 0; row < board.length; row++){
			for(int col = 0; col < board[row].length; col++){
			    if(board[row][col] == 1){
				s = s + "Q ";
				}if(board[row][col] < 0){
					s = s + "x ";
			    }if(board[row][col] == 0){
					s = s + "_ ";
			    }
			}
			s = s + "\n" + "\n";
		}
		return s;
	}

	public boolean addQueen(int row, int col){
	    if(board[row][col] != 0){
		return false;
	    }else{
		board[row][col] += 1;
		for(int x = 0; x < row; x++){
		    board[x][col] -= 1;
		    
		}
		for(int y = 0; y < board[row].length; y++){
			if(y != col){
				board[row][y] -=1;
			}
		}
		for(int i = row + 1; i < board.length; i++){
			board[i][i] -= 1;
		}
		for(int j = row - 1; j >= 0; j--){
		    board[j][j] -= 1;
		}
		int wor = row - 1;
		int loc = col + 1;
		while(wor > 0 && col < board[wor].length){
			board[wor][loc] -= 1;
			wor--;
			loc++;
		}
		wor = row + 1;
		loc = col - 1;
		while(wor < board.length && col > 0){
			board[wor][loc] -= 1;
			wor++;
			loc--;
		}
		return true;
	    }
	}
	private boolean removeQueen(int row, int col){
	    if(board[row][col] != 1){
		return false;
	    }else{
		board[row][col] -= 1;
		for(int x = 0; x < row; x++){
		     board[x][col] += 1;
		}
		for(int y = 0; y < board[row].length; y++){
			if(y != col){
				board[row][y] +=1;
			}
		}
		for(int i = row + 1; i < board.length; i++){
			board[i][i] += 1;
		}
		for(int j = row - 1; j >= 0; j--){
		    board[j][j] += 1;
		}
		int wor = row - 1;
		int loc = col + 1;
		while(wor > 0 && col < board[wor].length){
			board[wor][loc] += 1;
			wor--;
			loc++;
		}
		wor = row + 1;
		loc = col - 1;
		while(wor < board.length && col > 0){
			board[wor][loc] += 1;
			wor++;
			loc--;
		}
		return true;
	    }
	}
}
