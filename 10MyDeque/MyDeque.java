//0.0.0053
public class MyDeque<T>{ //MyDeck

    private T[] Deque;
    private int size, start, end;

    public static void main(String[] args){
	//System.out.println("And the bum rush begins..."); //Compile Check
    }
    
    public Deque(){
	Deque = new Deque[10];
	size = 0;
    }
    /*private T[] grow(T[] data){
	T[] bigger = new T[data.length * 2];
	for(int i =
	}*/

    public String toString(){
	String s = "[";
	for(int i = 0; i < Deque.length; i++){
	    if(i != size - 1){
		s = s + Deque[i] + " ";
	    }
	    else{
		s = s + Deque[i] + "]";
	    }
	}
	return s;
    }
}
