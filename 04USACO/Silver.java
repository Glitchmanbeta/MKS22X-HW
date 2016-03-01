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
    		porcupine.nextLine();
    		for(int row = 0; row < n; row++){
    			for(int col = 0; col < m; col++){
    				if(porcupine.hasNext()){
    					String s = porcupine.next();
    					System.out.println(s);
    					//field[row][col] = s.charAt(0);
    				}
    			}
    			porcupine.nextLine();
    		}
    		//System.out.println(porcupine.toString());
    	}
    	catch(FileNotFoundException e){
    		System.out.println("IT'S NOT USEEEEEEE!\nBTW, your file isn't in the right location. The program kinda won't work without it :/");
    	}
    }
}