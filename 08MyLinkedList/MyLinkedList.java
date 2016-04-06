import java.util.*;

public class MyLinkedList<T> implements Iterable<T>{
        
    private LNode head, tail;
    private int size;

    public MyLinkedList(){
        size = 0;
    }

    public MyLinkedList(T x){
        head = new LNode(x);
        size = 1;
    }
        
    public boolean add(T value){
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
            s += "]" /*+ "Head:" + head.getValue() + " " + "Tail:" + tail.getValue()*/;
            return s;
        }
        
    public int size(){
    	return size;
    }

    public T get(int index){
        LNode temp = null;
    	if(index >= size || index < 0){
    	    throw new IndexOutOfBoundsException();
    	}
    	else{
    	    temp = head;
    	    for(int i = 0; i <= index; i++){
                if(i == index){
                    return temp.getValue();
                }
                else{
                    temp = temp.getNext();
                }
            }
        }
        return temp.getValue();
    }
        
    public T set(int index, T newValue){
        T x = null;
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

    public int indexOf(T value){
        LNode temp = head;
        for(int i = 0; i < size; i++){
            if(temp.getValue().equals(value)){
                return i;
            }
            else{
                temp = temp.getNext();
            }
        }
        return -1;
    }

    public T remove(int index){
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
        
    public boolean add(int index, T value){
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
        private T value;
        private LNode next;

        public LNode(T x){
            value = x;
        }

        public T getValue(){
            return value;
        }

        public LNode getNext(){
            return next;
        }

    	public void setValue(T x){
    	    value = x;
    	}

    	public void setNext(LNode x){
    	    next = x;
    	}
    }

    public Iterator<T> iterator(){
        return new iterator();
    }

    private class iterator implements Iterator<T>{
        private LNode current = head;

        public boolean hasNext(){
            return current != null;
        }

        public T next(){
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            else{
                T value = current.getValue();
                current = current.getNext();
                return value;
            }
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }
    }
}
