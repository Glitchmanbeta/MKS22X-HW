public class Quick{

	public static boolean DEBUG = true;

	public static void main(String[] args){
		if(DEBUG){
			System.out.println("Gotta fix dem der Winders");
			int[] data = {6, 5, 3, 1, 8, 7, 2, 4};
			System.out.println(partition(data, 0, data.length - 1));
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
		int store = left + 1;
		swap(data, index, left);
		System.out.println(printArray(data));
		for(int i = left + 1; i < right; i++){
			if(data[i] <= data[left]){
				swap(data, data[store], data[i]);
				store++;
			}
			if(DEBUG){
				System.out.println(printArray(data));
			}
		}
		swap(data, left, store);
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