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

	public String printSolution(){
		String s = "";
		for(int row = 0; row < board.length; row++){
			for(int col = 0; col < board[row].length; col++){
			    if(board[row][col] == 1){
				s = s + "Q ";
				/*}if(board[row][col] < 0){
					s = s + "x ";*/
			    }else{
					s = s + "_ ";
			    }
			}
			s = s + "\n" + "\n";
		}
		return s;
	}

	private boolean addQueen(int row, int col){
	if(board[row][col] != 0){
	    return false;
	}
	board[row][col] = 1;
	int offset = 1;
	while(col+offset < board[row].length){
	    board[row][col+offset]--;
	    if(row - offset >= 0){
		board[row-offset][col+offset]--;
	    }
	    if(row + offset < board.length){
		board[row+offset][col+offset]--;
	    }
	    offset++;
	}
	return true;
    }

    private boolean removeQueen(int row, int col){
	if(board[row][col] != 1){
	    return false;
	}
	board[row][col] = 0;
	int offset = 1;
	while(col+offset < board[row].length){
	    board[row][col+offset]++;
	    if(row - offset >= 0){
		board[row-offset][col+offset]++;
	    }
	    if(row + offset < board.length){
		board[row+offset][col+offset]++;
	    }
	    offset++;
	}
	return true;
    }
        
    public boolean solve(){
		return solev(0, 0);
    }
    
    private boolean solev(int row, int col){
    	if(col < size && row < size){
    		if(addQueen(row, col)){
    			return solev(0, col + 1);
    		}
    		else{
    			return solev(row + 1, col);
    		}

    	}
    	if(row == board.length){
    		if(backtrack(row - 1, col - 1)){
    			return solev(0, col - 1);
    		}
    	}
    	return false;
    }

    private boolean backtrack(int row, int col){
    	if(row < 0 || col < 0){
    		return false;
    	}
    	if(! removeQueen(row, col)){
    		return backtrack(row - 1, col);
    	}else{
    		board[row][col] -= 1;
    		return true;
    	}
    }
}
