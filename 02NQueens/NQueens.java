//Windows NT 10.0.10582 "10"
public class NQueens{

	public static QueenBoard x;

	public static void main(String[] size){
		if(size.length > 0){
			x = new QueenBoard(Integer.parseInt(size[0]));
		}
		else{
			x = new QueenBoard();
		}
		System.out.println(x.toString());
		System.out.println(x.solve());
		//System.out.println(x.toString());
	}
}
