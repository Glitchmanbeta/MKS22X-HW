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
	Scanner s = new Scanner(new File("makelake.txt"));
    }
}
