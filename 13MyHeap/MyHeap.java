//Lucky Number 13
import java.util.NoSuchElementException;
@SuppressWarnings("unchecked")

public class MyHeap<T extends Comparable<T>>{

    private int size;
    private T[] data;

    public static void main(String[] thirteen){
    	MyHeap<Integer> test;
	    Integer[] array = {35, 222, 187, 238, 35, 191, 72, 186, 113, 105, 65, 21, 142};
	    test = new MyHeap<Integer>(array);
	    test.delete();
	    test.add(238);
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
    	size = initarray.length;
    	System.out.println(toString());
    	heapify();
    }

    private void arrayToHeap(T[] initarray){
    	for(int i = 0; i < initarray.length; i++){
    		data[i + 1] = initarray[i];
    	}
    }

    public String toString(){
    	String s = "";
    	for(int i = 1; i < size + 1; i++){
    		s += data[i] + " ";
    	}
    	return s;
    }
    
    private void pushDown(int k){
    	T temp;
    	//if data[k * 2] < data[k * 2 + 1] compareTo returns negative
    	int c = data[k * 2].compareTo(data[k * 2 + 1]);
    	if(c > 0 && data[k].compareTo(data[k * 2]) < 0){
    		temp = data[k];
    		data[k] = data[k * 2];
    		data[k * 2] = temp;
    		if(k * 2 <= size / 2){
    			pushDown(k * 2);
    		}
    	}
    	else if(c < 0 && data[k].compareTo(data[k * 2 + 1]) < 0){
    		temp = data[k];
    		data[k] = data[k * 2 + 1];
    		data[k * 2 + 1] = temp;
    		if(k * 2 + 1 <= size / 2){
    			pushDown(k * 2 + 1);
    		}
    	}
    }
    
    private void heapify(){
    	for(int i = size / 2; i > 0; i--){
    		pushDown(i);
    	}
    }

    private void doubleSize(){
    	T[] doubledata = (T[]) new Comparable[data.length * 2];
    	for(int i = 1; i < data.length; i++){
    		data[i] = doubledata[i];
    	}
    	data = doubledata;
    }

    public T delete(){
    	if(size == 0){
    		throw new NoSuchElementException();
    	}
    	T temp = data[1];
    	data[1] = data[size];
    	data[size] = null;
    	size--;
    	pushDown(1);
    	return temp;
    }

    public T peek(){
    	if(size == 0){
    		throw new NoSuchElementException();
    	}
    	return data[1];
    }

    public void add(T x){
    	if(size == data.length - 1){
    		doubleSize();
    	}
    	data[size + 1] = x;
    	pushUp(size + 1);
    	size++; 
    }

    private void pushUp(int k){
    	System.out.println("This doesn't actually push up");
    	T temp;
    	while(k > 1){
    		int c = data[k].compareTo(data[k / 2]);
    		if(c > 0){
    			temp = data[k];
    			data[k] = data[k / 2];
    			data[k / 2] = temp;
    			k = k / 2;
    		}
    	}
    }
}
