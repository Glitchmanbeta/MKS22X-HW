import java.util.*;
import java.io.*;

public class Maze{

    private char[][]maze;
    private int startx,starty;
    private boolean animate;
    private Scanner sc;
    private File f;

    /*Constructor loads a maze text file.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (only 1 per file)
      'S' - the location of the start(only 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!

      3. When the file is not found, print an error and exit the program.
    */
    public Maze(String filename, boolean ani){
        //COMPLETE CONSTRUCTOR
        try{
            f = new File(filename);
            sc = new Scanner(f);
            String s = "";
            int count = 0;
            s = sc.nextLine();
            int col = s.length();

            while(sc.hasNextLine()){
                s = sc.nextLine();
                count++;
            }

            maze = new char[count + 1][col];
            sc = new Scanner(f);
            count = 0;
            int row = 0;
            startx = -1;
            while(sc.hasNextLine()){
                s = sc.nextLine();
                for(int i = 0; i < s.length(); i++){
                    if(s.charAt(i) == 'S'){
                        startx = row;
                        starty = i;
                        maze[startx][starty] = 'S';
                    }
                    maze[row][i] = s.charAt(i);
                }
                row++;
            }
        }

        catch(FileNotFoundException e){
            System.out.println("File Not Found.");
        }
        
    }


    /*Main Solve Function

      Things to note:
       When no S is contained in maze, print an error and return false.
    */
    public boolean solve(){
        if(startx < 0){
            System.out.println("No starting point 'S' found in maze.");
            return false;
        }else{
            maze[startx][starty] = ' ';
            return solve(startx,starty);
        }
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.
      The S is replaced with '@' but the 'E' is not.

      Postcondition:
        Returns true when the maze is solved,
        Returns false when the maze has no solution.

        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'

    */
    private boolean solve(int x, int y){
        //COMPLETE SOLVE
        if(maze[x][y] == '#' || maze[x][y] == '.' || maze[x][y] == '@'){
            return false;
        }
        if(maze[x][y] == 'E'){
            return true;
        }
        maze[x][y] = '@';
        if(solve(x - 1, y) || solve(x, y + 1) || solve(x + 1, y) || solve(x, y - 1)){
            return true;
        }
        else{
            maze[x][y] = '.';
        }
        return false; //so it compiles
    }
    
    public String toString(){
        String s = "";
        for(int i = 0; i < maze.length; i++){
            for(int j = 0; j < maze[i].length; j++){
                s = s + maze[i][j];
            }
            s = s + "\n";
        }
        return s;
    }
  
}