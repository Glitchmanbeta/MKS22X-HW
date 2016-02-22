import java.util.ArrayList;

public class KnightBoard{

    private int size, counter;
    private int[] c, d;
    private int[][] board;
    private static boolean DEBUG = true;
    private int[][] moves = new int[8][2];

    public static void main(String[]args){
		if(DEBUG){
			if(args.length > 0){
	    		KnightBoard x = new KnightBoard(Integer.parseInt(args[0]));
	    		//x.printSolution();
	    		x.solve();
	    		x.printSolution();
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
	    		if(board[row][col] < 10){
				s = s + " " + board[row][col] + " ";
				}
				else{
					s = s + board[row][col] + " ";
				}
	    	}
	    	s = s + "\n"; 
		}
		System.out.println(s);
    }

    public boolean solve(){
    	board[0][0] = counter;
    	return solveh(0, 0);
    }
    private boolean solveh(int row, int col){
    	possibleMoves(row, col);
        /*if(DEBUG){
            System.out.println(counter);
        }*/
    	if(counter == Math.pow(size, 2)){
    		return true;
    	}
    	if(moveSize() == 0){
            c = coordinateOf(counter - 1);
            d = coordinateOf(counter);
            board[d[0]][d[1]] = 0;
            if(backtrack(c[0], c[1])){
                return solveh(d[0], d[1]);
            }
        }
    	else{
    		counter++;
    		board[moves[0][0]][moves[0][1]] = counter;
    		return solveh(moves[0][0], moves[0][1]);
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
        if(row + 2 < board.length && col - 1 >= 0 && board[row + 2][col - 1] == 0){
    		moves[count][0] = row + 2;
    		moves[count][1] = col - 1;
    		count++;
    	}
    	if(row + 1 < board.length && col - 2 >= 0 && board[row + 1][col - 2] == 0){
    		moves[count][0] = row + 1;
    		moves[count][1] = col - 2;
    		count++;
    	}
    	if(row - 2 >= 0 && col + 1 < board[row].length && board[row - 2][col + 1] == 0){
    		moves[count][0] = row - 2;
    		moves[count][1] = col + 1;
    		count++;
    	}
    	if(row - 2 >= 0 && col - 1 >= 0 && board[row - 2][col - 1] == 0){
    		moves[count][0] = row - 2;
    		moves[count][1] = col - 1;
    		count++;
    	}
    	if(row - 1 >= 0 && col + 2 < board[row].length && board[row - 1][col + 2] == 0){
    		moves[count][0] = row - 1;
    		moves[count][1] = col + 2;
    		count++;
    	}
    	if(row - 1 >= 0 && col - 2 >= 0 && board[row - 1][col - 2] == 0){
    		moves[count][0] = row - 1;
    		moves[count][1] = col - 2;
    		count++;
    	}
        /*for(int i = 0; i < moves.length; i++){
            for(int j = 0; j < 2; j++){
                if(DEBUG){
                    System.out.println(moves[i][j]);
                }
            }
        }*/
    	return moves;
    }

    private int moveSize(){
        int i = 0;
    	while(i < moves.length){
    		if(moves[i][0] == 0 && moves[i][1] == 0){
    			return i;
    		}
            i++;
    	}
        return i;
    }

    private int[] coordinateOf(int n){
    	int[] x = new int[2];
    	for(int i = 0; i < board.length; i++){
    		for(int j = 0; j < board[i].length; j++){
    			if(n == board[i][j]){
    				x[0] = i;
    				x[1] = j;
    				return x;
    			}
    		}
    	}
    	return x;
    }

    private boolean backtrack(int row, int col){
        counter--;
        possibleMoves(row, col);
        for(int i = 0; i < moveSize(); i++){
            if(moves[i][0] == d[0] && moves[i][1] == d[1]){
                if(i == moveSize()){
                    d = coordinateOf(counter);
                    c = coordinateOf(counter - 1);
                    return backtrack(c[0], c[1]);
                }
                else{
                    d = moves[i + 1];
                    counter++;
                    board[d[0]][d[1]] = counter;
                    return true;
                }
            }
        }
        return false;
    }
}
