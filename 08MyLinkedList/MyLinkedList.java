/*Working methods:
    add(to the end)
    toString
    get
    */
import java.util.*;

public class MyLinkedList{
    
    private LNode start, end;
    private int size;

    public static void main(String[] args){
        MyLinkedList test = new MyLinkedList(0);
        System.out.println(test.toString());
        test.add(1);
        System.out.println(test.toString());
        test.set(1, -1);
        System.out.println(test.toString());
    }

    public MyLinkedList(int x){
        start = new LNode(x);
        size = 1;
    }
    
    public boolean add(int value){
        if(start == null){
	    start = new LNode(value);
	}
	else{
	    LNode temp = start;
	    while(temp.getNext() != null){
		temp = temp.getNext();
	    }
	    temp.setNext(new LNode(value));
	}
	size++;
        return true;
    }
    
    public String toString(){
        String s = "[";
        LNode temp = start;
        while(temp != null){
	    s = s + temp.getValue();
	    if(temp.getNext() != null){
		s = s + ", ";
	    }
	    temp = temp.getNext();
	}
        s += "]";
        return s;
    }
    
    public int size(){
	return size;
    }

    public int get(int index){
	if(index >= size || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	else{
	    LNode temp = start;
	    for(int i = 0; i <= index; i++){
		if(i == index){
		    return temp.getValue();
		}
		else{
		    temp = temp.getNext();
		}
	    }
	}
        return index;
    }
    
    public int set(int index, int newValue){
        int x = 0;
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        else{
            LNode temp = start;
            for(int i = 0; i <= index; i++){
                if(i == index){
                    x = temp.getValue();
                    temp.setValue(newValue);
                }
                else{
                    temp = temp.getNext();
                }
            }
        }
        return x;
    }
    
    private class LNode{
        private int value;
        private LNode next;

        public LNode(int x){
            value = x;
        }

        public int getValue(){
            return value;
        }

        public LNode getNext(){
            return next;
        }

	public void setValue(int x){
	    value = x;
	}
	public void setNext(LNode x){
	    next = x;
	}
    }
}
