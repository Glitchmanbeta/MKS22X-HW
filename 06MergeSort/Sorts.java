import java.util.Arraylist
public class Sorts{
    
    private static boolean DEBUG = true;
    
    public static void main(String[]args){
        if(DEBUG){
            System.out.println("Hello from the Dark Side");
            System.out.println(name());
            int[] test1 = {19, 44, 49, 52, 90};
            int[] test2 = {7, 9, 20, 50, 51};
            merge(test1, test2);
        }
    }
    
    public static String name(){
        return "6,Almawaldi,Sammy";
    }
    
    public static void mergesort(int[] data){
        if(data.length == 1){
            return data;
        }
        else{
            Arraylist ary1 = new Arraylist();
            Arraylist ary2 = new Arraylist();
            for(int r = 0; r < data.length; r++){
                if(r < data.length / 2){
                    ary1.add(data[r]);
                }
                else{
                    ary2.add(data[r]);
                }
            }
            merge(mergesort())
        }
    }
    
    private static int[] merge(int[] ary1, int[] ary2){
        int l = 0;
        int r = 0;
        int i = 0;
        int[] merged = new int[ary1.length + ary2.length];
        while(l < ary1.length && r < ary2.length){
            if(ary1[l] <= ary2[r]){
                merged[i] = ary1[l];
                l++;
                i++;
            }
            if(ary2[r] < ary1[l]){
                merged[i] = ary2[r];
                r++;
                i++;
            }
        }
        while(l < ary1.length){
            merged[i] = ary1[l];
            l++;
            i++;
        }
        while(r < ary2.length){
            merged[i] = ary2[r];
            r++;
            i++;
        }
        if(DEBUG){
            for(int x = 0; x < merged.length; x++){
                System.out.println(merged[x]);
            }
        }
        return merged;
    }
}