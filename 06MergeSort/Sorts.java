public class Sorts{
    
    private static boolean DEBUG = true;
    
    public static void main(String[]args){
        if(DEBUG){
            System.out.println("Hello from the Dark Side");
            System.out.println(name());
            int[] test1 = {19, 44, 49, 52, 90};
            int[] test2 = {7, 9, 20, 50, 51};
            //merge(test1, test2);
            int[] test3 = {33, 20, 56, 6, 75, 90, 9, 77};
            mergesort(test3);
        }
    }
    
    public static String name(){
        return "6,Almawaldi,Sammy";
    }

    public static void mergesort(int[] data){
        mergeh(data);
    }
    
    public static int[] mergeh(int[] data){
        if(data.length == 1){
            return data;
        }
        else{
            int[] ary1 = new int[data.length / 2];
            int[] ary2 = new int[data.length - ary1.length];
            for(int r = 0; r < data.length; r++){
                if(r < ary1.length){
                    ary1[r] = data[r];
                }
                else{
                    System.out.println(r);
                    ary2[r] = data[r];
                }
            }
            merge(mergeh(ary1), mergeh(ary2));
        }
        if(DEBUG){
            for(int r = 0; r < data.length; r++){
                System.out.println(data[r]);
            }
        }
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