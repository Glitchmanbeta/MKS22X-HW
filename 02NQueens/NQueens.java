//Windows NT 10.0.10582 "10"
public class NQueens{

	public static Board x;

	public static void main(String[] size){
		if(size.length > 0){
			x = new Board(Integer.parseInt(size[0]));
		}
		else{
			x = new Board();
		}
		//System.out.println(x.toString());
		x.placeQueen(4,4);
		System.out.println(x.toString());
	}
}