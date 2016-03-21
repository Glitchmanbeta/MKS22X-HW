//Credit to Mr.K for the add and toString methods
public class MyLinkedList{
    
    private LNode start;
    private int size;

    public static void main(String[] args){
        System.out.println("Guess I got a bad habit");
        MyLinkedList test = new MyLinkedList(0);
        System.out.println(test.toString());
        System.out.println(test.add(1));
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
	LNode temp = start;
	
        return index;
    }
    
    public int set(int index, int newValue){
        return index;
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
