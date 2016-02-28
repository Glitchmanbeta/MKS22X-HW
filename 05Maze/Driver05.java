public class Driver05{

    public static void main(String[]args){
        Maze f;
        f = new Maze("data3.dat", false);//true animates the maze.
        
        f.solve();

        System.out.println(f);
    }
}