import java.util.ArrayList;

public class KnightBoard{

    private int size, counter, index;
    private int[][] board, moves;
    private ArrayList<int[]> tried;
    private static boolean DEBUG = true;

    public static void main(String[]args){
		if(DEBUG){
			if(args.length > 0){
	    		KnightBoard x = new KnightBoard(Integer.parseInt(args[0]));
	    		x.printSolution();
	    		x.possibleMoves(2,2);
	    	}
	    	else{
	    		KnightBoard x = new KnightBoard();
	    		x.printSolution();
	    	}
		}
    }

    public KnightBoard(){
		size = 8;
		board = new int[size][size];
		moves = new int[8][2];
		counter = 1;

    }

    public KnightBoard(int n){
		size = n;
		board = new int[size][size];
		moves = new int[8][2];
		counter = 1;
    }

    public void printSolution(){
		String s = "";
		for(int row = 0; row < board.length; row++){
	    	for(int col = 0; col < board[row].length; col++){
				s = s + board[row][col] + " ";
	    	}
	    	s = s + "\n"; 
		}
		System.out.println(s);
    }

    public boolean solve(){
    	board[0][0] = 1;
    	index = 0;
    	return solveh(0, 0);
    }
    private boolean solveh(int row, int col){
    	possibleMoves(row, col);
    	if(tried.size() == 0){
    		counter++;
    		board[moves[index][0]][moves[index][1]]
    	}
    	return false;
    }

    private int[][] possibleMoves(int row, int col){
    	int count = 0;
    	for(int wor = 0; wor < moves.length; wor++){
    		for(int loc = 0; loc < moves[wor].length; loc++){
    			moves[wor][loc] = 0;
    		}
    	}
    	if(row + 2 < board.length && col + 1 < board[row].length && board[row + 2][col + 1] == 0){
    		moves[count][0] = row + 2;
    		moves[count][1] = col + 1;
    		count++;
    	}
    	if(row + 1 < board.length && col + 2 < board[row].length && board[row + 1][col + 2] == 0){
    		moves[count][0] = row + 1;
    		moves[count][1] = col + 2;
    		count++;
    	}
    	if(row + 2 < board.length && col - 1 > 0 && board[row + 2][col - 1] == 0){
    		moves[count][0] = row + 2;
    		moves[count][1] = col - 1;
    		count++;
    	}
    	if(row + 1 < board.length && col - 2 > 0 && board[row + 1][col - 2] == 0){
    		moves[count][0] = row + 1;
    		moves[count][1] = col - 2;
    		count++;
    	}
    	if(row - 2 > 0 && col + 1 < board[row].length && board[row - 2][col + 1] == 0){
    		moves[count][0] = row - 2;
    		moves[count][1] = col + 1;
    		count++;
    	}
    	if(row - 2 > 0 && col - 1 > 0 && board[row - 2][col - 1] == 0){
    		moves[count][0] = row - 2;
    		moves[count][1] = col - 1;
    		count++;
    	}
    	if(row - 1 > 0 && col + 2 < board[row].length && board[row - 1][col + 2] == 0){
    		moves[count][0] = row - 1;
    		moves[count][1] = col + 2;
    		count++;
    	}
    	if(row - 1 > 0 && col - 2 < board[row].length && board[row - 1][col - 2] == 0){
    		moves[count][0] = row - 1;
    		moves[count][1] = col - 2;
    		count++;
    	}
    	return moves;
    }
}
