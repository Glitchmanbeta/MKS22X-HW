//Windows NT 10.0.10582 "10"
public class Board{

	private int size;
	private int[][] board;

	public Board(){
		size = 8;
		board = new int[size][size];
		for(int row = 0; row < board.length; row++){
			for(int col = 0; col < board[row].length; col++){
				board[row][col] = 0;
			}
		}
	}

	public Board(int n){
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
				s = s + board[row][col] + " ";
			}
			s = s + "\n" + "\n";
		}
		return s;
	}
}