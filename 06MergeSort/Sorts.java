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
        mergesort(data, 0, data.length - 1);
    }
    
    private static int[] mergesort(int[] data, int left, int right){
        return data;
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