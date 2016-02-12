public class KnightBoard{
    private int size;
    private int[][] board;
    private static boolean DEBUG = true;

    public static void main(String[]args){
	if(DEBUG){
	    KnightBoard x = new KnightBoard(Integer.parseInt(args[0]));
	    x.printSolution();
	}
    }

    public KnightBoard(){
	size = 8;
	board = new int[size][size];
    }

    public KnightBoard(int size){
	size = this.size;
	board = new int[size][size];
    }


    public void printSolution(){
	String s = "";
	for(int row = 0; row < board.length; row++){
	    for(int col = 0; col < board[row].length; col++){
		if(board[row][col] != 0){
		    s = s + board[row][col] + " ";
		}
		else{
		    s = s + "_ ";
		}
	    }
	    s = s + "\n" + "\n"; 
	}
	System.out.println(s);
    }
}
