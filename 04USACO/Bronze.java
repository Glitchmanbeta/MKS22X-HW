import java.util.Scanner;
import java.io.File;

public class Bronze{

	private Scanner sc, an;
	private int row, col, ele, commands;
	private File f;
	private static boolean DEBUG;
	private int[][] lake;

    public static void main(String[]args){
    	DEBUG = true;
	    Bronze x = new Bronze();
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
}

/* file f = new file(in.txt);
Scanner lines = new Scanner(f);
Scanner in = new Scanner(lines.nextLine());
OUTPUT volume, Per, Last, First;
*/