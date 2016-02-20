public class KnightBoard{

    private int size;
    private int[][] board;
    private static boolean DEBUG = true;

    public static void main(String[]args){
		//if(DEBUG){
	    	KnightBoard x = new KnightBoard(Integer.parseInt(args[0]));
	    	x.printSolution();
		//}
    }

    public KnightBoard(){
		size = 8;
		board = new int[size][size];
		for(int row = 0; row < board.length; row++){
			for(int col = 0; col < board[row].length; col++){
				board[row][col] = 0;
			}
		}
    }

    public KnightBoard(int n){
		size = n;
		board = new int[size][size];
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
}
