public class Quick{

	public static boolean DEBUG = false;

	public static void main(String[] args){
		if(DEBUG){
			System.out.println("Gotta fix dem der Winders");
			int[] data = {5, 9, 4, 7, 3, 1, 1, 1, 2, 5};
			//int[] data = {6, 5, 3, 1, 8, 7, 2, 4};
			System.out.println(printArray(data));
			quickSort(data);
			System.out.println(printArray(data));
		}
	}

	public static String name(){
		return "6,Almawaldi,Sammy";
	}

	private static int partition(int[] data, int left, int right){
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
			s = s + data[i] + ", ";
		}
		s = s + "]";
		return s;
	}
	
	public static int quickselect(int[] data, int k){
		return quickselect(data, k, 0, data.length - 1);
	}

	private static int quickselect(int[] data, int k, int left, int right){
		if(left < right){
			int guess = partition(data, left, right);
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
    
    public static void quickSort(int[] data){
	quickSort(data, 0, data.length - 1);
    }

    private static void quicksort(int[] data, int left, int right){
	if(left < right){
	    int pivot = partition(data, left, right);
	    quickSort(data, left, pivot - 1);
	    quickSort(data, pivot + 1, right);
	}
    }
}
