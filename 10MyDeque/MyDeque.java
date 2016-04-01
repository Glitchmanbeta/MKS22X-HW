//0.0.0059
public class MyDeque<T>{ //MyDeck

    private Object[] Deque;
    private int size, start, end;

    public static void main(String[] args){
	//System.out.println("And the bum rush begins..."); //Compile Check
	MyDeque test = new MyDeque();
	System.out.println(test.toString());
    }
    
    public MyDeque(){
	Deque = new Object[10];
	size = 0;
    }

    /*private Object[] grow(Object[] data){
	T[] bigger = new T[data.length * 2];
	for(int i =
	}*/

    public String toString(){
	String s = "[";
	for(int i = 0; i < Deque.length; i++){
	    if(i != Deque.length - 1){
		s = s + Deque[i] + " ";
	    }
	    else{
		s = s + Deque[i] + "]";
	    }
	}
	return s;
    }
}
