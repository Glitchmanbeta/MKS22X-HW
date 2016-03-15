public class Quick{

	public static boolean DEBUG = true;

	public static void main(String[] args){
		if(DEBUG){
			System.out.println("Gotta fix dem der Winders");
			int[] data = {5, 9, 4, 7, 3, 1, 1, 1, 2, 5};
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
		System.out.println(printArray(data));
			if(DEBUG){
				System.out.println(printArray(data));
			}
		}
		if(data[l] > data[left]){
			swap(data, left, l - 1);
		}
		else{
			swap(data, left, l);
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