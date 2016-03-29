import java.util.Arrays;

public class Quick{

	public static void main(String[] args){
		int[] d = new int [4000000];
		int[] c = new int [d.length];
		for(int i = 0; i < d.length; i++){
			d[i]= (int)(Math.random()*Integer.MAX_VALUE);
			c[i]= d[i];
		}
		System.out.println(printArray(c));
		/*quickSort(d); //or even your old quicksort!!!
		Arrays.sort(c);
		System.out.println("Done: Sorted="+Arrays.equals(d,c));*/
	}

	public static String name(){
		return "6,Almawaldi,Sammy";
	}

	private static int partitionOld(int[] data, int left, int right){
		int index = (int)(Math.random() * right);
		while(index < left){
			index = (int)(Math.random() * right);
		}
		int l = left + 1;
		int r = right;
		swap(data, index, left);
		while(l != r && r > l){
			if(data[r] <= data[left]){
				swap(data, l, r);
				l++;
			}
			else{
				r--;
			}
		}
		if(data[l] > data[left]){
			swap(data, left, l - 1);
			return l - 1;
		}
		if(l == data.length - 1){
			swap(data, left, l);
			return l;
		}
		else{
			swap(data, left, l);
			return l;
		}
	}
	
	private static void swap(int[] data, int a, int b){
		int temp = data[a];
		data[a] = data[b];
		data[b] = temp;
	}
	
	private static String printArray(int[] data){
		String s = "[";
		for(int i = 0; i < data.length; i++){
			s = s + data[i] + " ";
		}
		s = s + "]";
		return s;
	}
	
	public static int quickselect(int[] data, int k){
		return quickselect(data, k, 0, data.length - 1);
	}

	private static int quickselect(int[] data, int k, int left, int right){
		if(left < right){
			int guess = partitionOld(data, left, right);
			if(guess == k){
				return data[guess];
			}
			else if(k < guess){
				return quickselect(data, k, left, guess - 1);
			}
			else{
				return quickselect(data, k, guess + 1, right);
			}
		}
		else{
			return data[right];
		}
	}
    
    public static void quickSortOld(int[] data){
		quickSortOld(data, 0, data.length - 1);
    }

    private static void quickSortOld(int[] data, int left, int right){
		if(left < right){
	    	int pivot = partitionOld(data, left, right);
	    	quickSortOld(data, left, pivot - 1);
	    	quickSortOld(data, pivot + 1, right);
		}
    }

    //New quickSort
    private static int[] partition(int[] data, int left, int right){
	int index = (int)((Math.random() + left) * (right - left + 1));
		int l = left + 1;
		int r = right;
		swap(data, index, left);
		while(l != r && r > l){
			if(data[r] <= data[left]){
				swap(data, l, r);
				l++;
			}
			else{
				r--;
			}
		}
		if(data[l] > data[left]){
			swap(data, left, l - 1);
			return pivotCheck(data, left, l - 1);
		}
		if(l == data.length - 1){
			swap(data, left, l);
			return pivotCheck(data, left, l);
		}
		else{
			swap(data, left, l);
			return pivotCheck(data, left, l);
		}
	}

	public static void quickSort(int[] data){
		quickSort(data, 0, data.length - 1);
    }

    private static void quickSort(int[] data, int left, int right){
		if(left < right){
	    	int[] pivot = partition(data, left, right);
	    	quickSort(data, left, pivot[0] - 1);
	    	quickSort(data, pivot[1] + 1, right);
		}
    }

    private static int[] pivotCheck(int[] data, int left, int l){
    	int diff = 1;
    	int i = left;
    	while(i < l - diff){
    		if(data[i] == data[l]){
    			swap(data, i, l - diff);
    			diff++;
    		}
    		else{
    			i++;
    		}
    	}
    	if(diff == 1){
    		int[] r = {l, l};
    		return r;
    	}
    	else{
    		int[] r = {l - diff, l};
    		return r;
    	}
    }
}
