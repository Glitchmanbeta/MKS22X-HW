//Lucky Number 13
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{

    private int size;
    private T[] data;

    public static void main(String[] thirteen){
    	MyHeap<Integer> test;
	    Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
	    test = new MyHeap<Integer>(array);
	    System.out.println(test.toString());
    }

    public MyHeap(){
	data = (T[]) new Comparable[0];
	size = 0;
    }

    public MyHeap(T[] initarray){
    	data = (T[]) new Comparable[initarray.length + 1];
    	arrayToHeap(initarray);
    	System.out.println(toString());
    	size = initarray.length - 1;
    	heapify();
    }

    private void arrayToHeap(T[] initarray){
    	for(int i = 0; i < initarray.length; i++){
    		data[i + 1] = initarray[i];
    	}
    }

    public String toString(){
    	String s = "";
    	for(int i = 1; i < data.length; i++){
    		s += data[i] + " ";
    	}
    	return s;
    }
    
    private void pushDown(int k){
    	System.out.println("This doesn't actually push down");
    	T temp;
    	int r = size;
    	//if data[k] < data[k * 2] compareTo returns negative
    	int x = data[k].compareTo(data[k * 2]);
    	if(x < 0){
    		System.out.println("Left Child");
    		temp = data[k];
    		data[k] = data[k * 2];
    		data[k * 2] = temp;
    		r = k * 2;
    	}
    	x = data[k].compareTo(data[k * 2 + 1]);
    	if(x < 0){
    		System.out.println("Right Child");
    		temp = data[k];
    		data[k] = data[k * 2 + 1];
    		data[k * 2 + 1] = temp;
    		r = k * 2 + 1;
    	}
    	if(r < size / 2){
    		pushDown(r);
    	}
    }
    
    private void heapify(){
    	for(int i = size / 2; i > 0; i--){
    		pushDown(i);
    	}
    }
    private void pushUp(int k){
	System.out.println("This doesn't actually push up");
    }
}
