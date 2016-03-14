public class Quick{

	public static boolean DEBUG = true;

	public static void main(String[] args){
		if(DEBUG){
			System.out.println("Gotta fix dem der Winders");
			int[] data = {9, 5, 1, 10, 2, 5, 3, 4, 3, 6};
			System.out.println(partition(data, 0, data.length - 1));
		}
	}

	public static String name(){
		return "6,Almawaldi,Sammy";
	}

	private static int partition(int[] data, int left, int right){
		/*int index = (int)(Math.random() * right);
		while(index < left){
			index = (int)(Math.random() * right);
		}*/
		int index = 5;
		int l = left;
		int r = right;
		while(l != r){
			if(data[r] <= data[index]){
				swap(data, r,  l);
				l++;
			}
			else{
				r--;
			}
			if(DEBUG){
				System.out.println(printArray(data));
			}
		}
		System.out.println(printArray(data));
		return index;
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
}