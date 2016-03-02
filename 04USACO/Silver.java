import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Silver{
    
    private static boolean DEBUG;
    private int n, m, t, r1, c1, r2, c2;
    private Scanner porcupine;
    private File hedgehog;
    private char[][] field;
    
    public static void main(String[]args){
        DEBUG = true;
        if(DEBUG){
            System.out.println("IT'S NO USEEEEEEE!");
        }
        Silver pothead = new Silver();
    }

    public Silver(){
    	try{
    		hedgehog = new File("ctravel.in");
    		porcupine = new Scanner(hedgehog);
    		n = porcupine.nextInt();
    		m = porcupine.nextInt();
    		t = porcupine.nextInt();
            field = new char[n][m];
    		porcupine.nextLine();
    		for(int row = 0; row < n; row++){
                String s = porcupine.nextLine();
    			for(int col = 0; col < m; col++){
    				field[row][col] = s.charAt(col);
    			}
    	    }
            if(DEBUG){
                String s = "";
                for(int row = 0; row < field.length; row++){
                    for(int col = 0; col < field[row].length; col++){
                        s = s + field[row][col] + " ";
                    }
                    s = s + "\n";
                }
                System.out.println(s);
            }
            r1 = porcupine.nextInt();
            c1 = porcupine.nextInt();
            r2 = porcupine.nextInt();
            c2 = porcupine.nextInt();
            System.out.println(r1 + " " + c1 + " " + r2 + " " + c2);
    	}
    	catch(FileNotFoundException e){
    		System.out.println("IT'S NO USEEEEEEE!\nBTW, your file isn't in the right location or isn't named correctly. The program kinda won't work without it :/");
    	}
    }
}