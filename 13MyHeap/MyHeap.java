//Lucky Number 13
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{

    private int size;
    private T[] data;

    public static void main(String[] thirteen){
	MyHeap<Integer> test;
	if(thirteen[0].equals("empty")){
	    test = new MyHeap<Integer>();
	    System.out.println(test.toString());
	}
	if(thirteen[0].equals("array")){
	    Integer[] array = {8, 3, 4, 7, 9, 6, 12, 15, 19, 30, 16, 20, 0, 5, 3};
	    test = new MyHeap<Integer>(array);
	    System.out.println(test.toString());
	}
	else{
	    System.out.println("Please specify if you want to test the 'empty' constructor or the 'array' constructor");
	}
    }

    public MyHeap(){
	data = (T[]) new Object[0];
    }

    public MyHeap(T[] initarray){
	data = (T[]) new Object[initarray.length + 1];
	makeHeapArray(initarray);
    }

    private void makeHeapArray(T[] initarray){
	for(int i = 0; i < initarray.length; i++){
	    data[i + 1] = initarray[i];
	}
    }

    public String toString(){
	String s = "";
	for(int i = 0; i < data.length; i++){
	    s += data[i];
	}
	return s;
    }
}
