import java.util.Scanner;
import java.io.File;

public class Bronze{
    private boolean DEBUG = true;

    public static void main(String[]args){
	    if(DEBUG){
	     System.out.println("Happening");
	    }
    }

    public Bronze(){
	    Scanner sc = new Scanner(new File("makelake.in"));
	    
    }
}

/* file f = new file(in.txt);
Scanner lines = new Scanner(f);
Scanner in = new Scanner(lines.nextLine());
OUTPUT volume, Per, Last, First;
*/