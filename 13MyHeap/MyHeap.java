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
	    test.pushDown(1);
	    System.out.println(test.toString());
	}
	else{
	    System.out.println("Please specify if you want to test the 'empty' constructor or the 'array' constructor");
	}
    }

    public MyHeap(){
	data = (T[]) new Comparable[0];
	size = 0;
    }

    public MyHeap(T[] initarray){
	data = (T[]) new Comparable[initarray.length + 1];
	arrayToHeap(initarray);
	size = initarray.length;
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
	//if data[k] < data[k * 2] compareTo returns negative
	int x = data[k].compareTo(data[k * 2]);
	if(x < 0){
	    temp = data[k * 2];
	    data[k] = data[k * 2];
	    data[k * 2] = temp;
	}
	x = data[k].compareTO(data[k * 2]
    }
    
    private void pushUp(int k){
	System.out.println("This doesn't actually push up");
    }
}
