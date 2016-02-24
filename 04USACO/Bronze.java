import java.util.Scanner;
import java.io.File;

public class Bronze{

	private static Scanner sc, an;
	private int row, col, ele; 
	private static int commands, r, c, d;
	private File f;
	private static boolean DEBUG;
	private int[][] lake;

    public static void main(String[]args){
    	DEBUG = false;
	    Bronze x = new Bronze();
	    for(int i = 0; i < commands; i++){
	    	an = new Scanner(sc.nextLine());
	    	r = an.nextInt() - 1;
	    	c = an.nextInt() - 1;
	    	d = an.nextInt();
	    	if(DEBUG){
	    		System.out.println(r + ", " + c + ", " + d);
	    	}
	    	x.stomp(r, c, d);
	    	if(DEBUG){
	    		System.out.println(x.print());
	    	}
	    }
	    x.elevation();
	    if(DEBUG){
	    	System.out.println(x.print());
	    }
	    System.out.println(x.volume() + ", 6, ALMAWALDI, SAMMY");
    }

    public Bronze(){
    	try{
    		f = new File("makelake.in");
	    	sc = new Scanner(f);
	    	an = new Scanner(sc.nextLine());
	    	row = an.nextInt();
	    	col = an.nextInt();
	    	ele = an.nextInt();
	    	commands = an.nextInt();
	    	if(DEBUG){
	    		System.out.println(row + ", " + col + ", " + ele + ", " + commands);
	    	}
	    	lake = new int[row][col];
	    	for(int i = 0; i < row; i++){
	    		an = new Scanner(sc.nextLine());
	    		for(int j = 0; j < col; j++){
	    			lake[i][j] = an.nextInt();
	    			if(DEBUG){
	    				System.out.println(lake[i][j] + " ");
	    			}
	    		}
	    	}
	    }
	    catch(Exception e){
	    	System.out.println("File Not Found.");
	    }
    }

    public boolean stomp(int r, int c, int d){
    	if(r > row - 2 || c > col - 2){
    		return false;
    	}else{
    		int x = 0;
    		int y = 0;
    		int largest = Integer.MIN_VALUE;
    		for(int i = r; i < r + 3; i++){
    			for(int j = c; j < c + 3; j++){
    				if(lake[i][j] > largest){
    					largest = lake[i][j];
    					x = i;
    					y = j;
    				}
    			}
    		}
    		largest -= d;
    		lake[x][y] = largest;
    		for(int i = r; i < r + 3; i++){
    			for(int j = c; j < c + 3; j++){
    				if(lake[i][j] > largest){
    					lake[i][j] = largest;
    				}
    			}
    		}
    		return true;
    	}
    }

    private String print(){
    	String s = "";
	    for(int k = 0; k < lake.length; k++){
	    	for(int j = 0; j < lake[k].length; j++){
	    		s = s + lake[k][j] + " ";
	    	}
	    	s = s + "\n";
	    }
	    return s;
    }

    public boolean elevation(){
    	for(int i = 0; i < row; i++){
    		for(int j = 0; j < col; j++){
    			lake[i][j]  = ele - lake[i][j];
    		}
    	}
    	return true;
    }

    public int volume(){
    	int depth = 0;
    	for(int i = 0; i < row; i++){
    		for(int j = 0; j < col; j++){
    			if(lake[i][j] > 0){
    				depth += lake[i][j];
    			}
    		}
    	}
    	return depth * 72 * 72; 
    }
}