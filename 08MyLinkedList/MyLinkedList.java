import java.util.*;

public class MyLinkedList{
        
    private LNode head, tail;
    private int size;

    public static void main(String[] args){
        MyLinkedList test = new MyLinkedList();
        System.out.println(test.toString());
        test.add(1);
        System.out.println(test.toString());
        test.add(1, 2);
        System.out.println(test.toString());
        test.add(0, 3);
        System.out.println(test.toString());
        test.remove(0);
        System.out.println(test.toString());
        System.out.println(test.size());
        test.remove(1);
        System.out.println(test.toString());
    }

    public MyLinkedList(){
        size = 0;
    }

    public MyLinkedList(int x){
        head = new LNode(x);
        size = 1;
    }
        
    public boolean add(int value){
        if(head == null){
            head = new LNode(value);
            tail = head;
    	}
    	else{
    	    LNode addition = new LNode(value);
            tail.setNext(addition);
            tail = tail.getNext();
    	}
    	size++;
        return true;
    }
        
    public String toString(){
        String s = "[";
        LNode temp = head;
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
    	    LNode temp = head;
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
            LNode temp = head;
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

    public int indexOf(int value){
        LNode temp = head;
        for(int i = 0; i < size; i++){
            if(temp.getValue() == value){
                return i;
            }
            else{
                temp = temp.getNext();
            }
        }
        return -1;
    }

    public int remove(int index){
        LNode removed = null;
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
    	else if(index == 0){
    	    removed = head;
    	    head = head.getNext();
    	    removed.setNext(null);
    	}
        else if(index == size - 1){
            removed = tail;
            LNode temp = head;
            for(int i = 0; i < size - 2; i++){
                temp = temp.getNext();
            }
            tail = temp;
            tail.setNext(null);
        }
        else{
            LNode temp = head;
            for(int i = 0; i <= index; i++){
                if(i == index - 1){
                    removed = temp.getNext();
                    temp.setNext(temp.getNext().getNext());
                }
                else{
                    temp = temp.getNext();
                }
            }
        }
        size -= 1;
        return removed.getValue();
    }
        
    public boolean add(int index, int value){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        if(head == null){
            head = new LNode(value);
        }
        else if(index == size()){
            return add(value);
        }
        else if(index == 0){
            LNode addition = new LNode(value);
            addition.setNext(head);
            head = addition;
        }
        LNode temp = head;
        LNode addition = new LNode(value);
        for(int i = 0; i <= index; i++){
            if(i == index - 1){
                LNode next = temp.getNext();
                temp.setNext(addition);
                addition.setNext(next);
            }
            else{
                temp = temp.getNext();
            }
        }
        size++;
        return true;
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
