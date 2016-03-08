public class Sorts{
    
    private static boolean DEBUG = true;
    
    public static void main(String[]args){
        if(DEBUG){
            System.out.println("Hello from the Dark Side");
            System.out.println(name());
        }
    }
    
    public static String name(){
        return "6,Almawaldi,Sammy";
    }
    
    public static void mergesort(int[] data){
        mergesort(data, 0, data.length - 1);
    }
    
    private int[] mergesort(int[] data, int left, int right){
        return data;
    }
    
    private int[] merge(l1, r1, l2, r2){
        
    }
}