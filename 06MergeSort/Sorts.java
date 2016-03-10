public class Sorts{
    
    private static boolean DEBUG = false;
    private static int[] result;
    
    public static void main(String[]args){
        if(DEBUG){
            System.out.println("Hello from the Dark Side");
            System.out.println(name());
            int[] test1 = {19, 44, 49, 52, 90};
            int[] test2 = {7, 9, 20, 50, 51};
            //merge(test1, test2);
            int[] test3 = {33, 20, 56, 6, 75, 90, 9, 77};
            mergesort(test3);
            for(int x = 0; x < result.length; x++){
                System.out.println(result[x]);
            }
        }
    }
    
    public static String name(){
        return "6,Almawaldi,Sammy";
    }

    public static void mergesort(int[] data){
        result = mergeh(data);
    }
    
    public static int[] mergeh(int[] data){
        if(data.length == 1){
            return data;
        }
        else{
            int[] ary1 = new int[data.length / 2];
            int[] ary2 = new int[data.length - ary1.length];
            for(int r = 0; r < ary1.length; r++){
                ary1[r] = data[r];
            }
            for(int r = ary1.length; r < data.length; r++){
                ary2[r - ary1.length] = data[r];
            }
            data = merge(mergeh(ary1), mergeh(ary2));
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
            else if(ary2[r] < ary1[l]){
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
        return merged;
    }
}