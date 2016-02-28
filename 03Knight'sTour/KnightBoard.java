public class KnightBoard{

    private int counter, r, c;
    private int[][] board;
    private static boolean DEBUG = true;

    public static void main(String[]args){
		if(DEBUG){
            if(args.length == 2){
                KnightBoard x = new KnightBoard(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
                x.solve();
                x.printSolution();
            }
			if(args.length == 1){
	    		KnightBoard x = new KnightBoard(Integer.parseInt(args[0]));
	    		x.solve();
	    		x.printSolution();
	    	}
	    	if(args.length == 0){
	    		KnightBoard x = new KnightBoard();
                x.solve();
	    		x.printSolution();
	    	}
		}
    }

    public KnightBoard(){
		r = 8;
        c = 8;
		board = new int[r][c];
		counter = 0;
    }

    public KnightBoard(int n){
		r = n;
        c = n;
		board = new int[r][c];
		counter = 0;
    }

    public KnightBoard(int r, int c){
        this.r = r;
        this.c = c;
        board = new int[r][c];
        counter = 0;
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
    	return solveh(0, 0);
    }
    private boolean solveh(int row, int col){
        if(! onBoard(row, col)){
            return false;
        }
        if((r * c) == counter){
            return true;
        }
        if(board[row][col] != 0){
            return false;
        }
        else{
            counter++;
            board[row][col] = counter;
            if(solveh(row - 2, col - 1) || 
                solveh(row - 2, col + 1) || 
                solveh(row + 2, col - 1) || 
                solveh(row + 2, col + 1) || 
                solveh(row + 1, col + 2) || 
                solveh(row - 1, col + 2) || 
                solveh(row + 1, col + 2) || 
                solveh(row - 1, col - 2)){
                return true;
            }
            else{
                board[row][col] = 0;
                counter--;
                return false;
            }
        }
    }

    private boolean onBoard(int row, int col){
        if(row >= 0 && row < board.length && col >= 0 && col < board[row].length){
            return true;
        }else{
            return false;
        }
    }
}
