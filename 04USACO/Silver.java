import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Silver{
    
    private static boolean DEBUG;
    private int n, m, t, r1, c1, r2, c2;
    private Scanner porcupine;
    private File hedgehog;
    private char[][] field;
    private int[][] nums, oldnums;
    
    public static void main(String[]args){
        DEBUG = false;
        if(DEBUG){
            System.out.println("IT'S NO USEEEEEEE!");
        }
        Silver pothead = new Silver();
        System.out.println(pothead.moves());
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
            if(DEBUG){
                System.out.println(r1 + " " + c1 + " " + r2 + " " + c2);
            }
    	}
    	catch(FileNotFoundException e){
    		System.out.println("IT'S NO USEEEEEEE!\nBTW, your file isn't in the right location or isn't named correctly. The program kinda won't work without it :/");
    	}
    }

    public void Reference(){
        System.out.println("You're probably wondering why I named the variables the way I did.\nWell, you know Sonic the Hedgehog?\nI had the misfortune of buying one of the worst games in that series, Sonic '06.\nIn that game, you have the wonderful fortune of meeting the best character ever concieved, Silver the Hedgehog.\nTake a look at his character design. Notice anything?\nAlso, look up Sonic '06 Silver boss fight.\nYeah.\nIt wasn't fun.");
    }

    public int moves(){
        nums = new int[n][m]; 
        oldnums = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                nums[i][j] = 0;
            }
        }
        for(int moves = 1; moves <= t; moves++){
            if(moves == 1){
                nums[0][1] = nums[1][0] = 1;
            }
            else{
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < m; j++){
                        oldnums[i][j] = nums[i][j];
                    }
                }
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < m; j++){
                        nums[i][j] = 0;
                        if(field[i][j] == '*'){
                            nums[i][j] = 0;
                        }
                        else if(i == 0 && j == 0){
                            nums[i][j] = oldnums[i + 1][j] + oldnums[i][j + 1];
                        }
                        else if(i == 0 && j > 0 && j < m - 1){
                            nums[i][j] = oldnums[i][j - 1] + oldnums[i + 1][j] + oldnums[i][j + 1];
                        }
                        else if(i == 0 && j == m - 1){
                            nums[i][j] = oldnums[i][j - 1] + oldnums[i + 1][j];
                        }
                        else if(i > 0 && i < n - 1 && j == 0){
                            nums[i][j] = oldnums[i - 1][j] + oldnums[i][j + 1] + oldnums[i + 1][j];
                        }
                        else if(i == n - 1 && j == 0){
                            nums[i][j] = oldnums[i - 1][j] + oldnums[i][j + 1];
                        }
                        else if(i == n - 1 && j > 0 && j < m - 1){
                            nums[i][j] = oldnums[i][j - 1] + oldnums[i - 1][j] + oldnums[i][j + 1];
                        }
                        else if(i == n - 1 && j == m - 1){
                            nums[i][j] = oldnums[i][j - 1] + oldnums[i - 1][j];
                        }
                        else if(i > 0 && i < n - 1 && j == m - 1){
                            nums[i][j] = oldnums[i][j - 1] + oldnums[i - 1][j] + oldnums[i + 1][j];
                        }
                        else{
                            nums[i][j] = oldnums[i - 1][j] + oldnums[i][j + 1] + oldnums[i + 1][j] + oldnums[i][j - 1];
                        }
                    }
                }
            }
        }
        return nums[r2 - 1][c2 - 1];
    }
}