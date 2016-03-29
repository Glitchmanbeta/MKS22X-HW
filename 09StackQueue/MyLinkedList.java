/* I swear I will replace this with my own LinkedList, I just didn't do it, and I know you're tired of hearing "sorry this is late" from people, so I won't say it, but just know that sometimes I find it hard to find the time to do certain homework. Nothing against you or this class, I truly do enjoy it, but it's the easiest to skimp out on some work in Computer Science. At the very least, unlike during my intro years, I think I'm making an effort to make up the homework. Small steps I suppose, but generally speaking, I'm going to try my best to meet deadlines, because I hate this as much as you do. It's annoying when students don't turn in work, and it leaves a bad impression of me. But sometimes, you need to do what you need to do in order to stay, above all, healthy. Because CS class might be important, but I'd rather be alive and well than either dead or sick. At least in the latter scenario I finished my CS homework :)*/


import java.util.*;
public class MyLinkedList<T> implements Iterable<T>{
    private class LNode{
	private T value;
	private LNode next;
	public LNode(T v){
	    value = v;
	}
	public T getValue(){
	    return value;
	}
	public LNode getNext(){
	    return next;
	}
	public T setValue(T v){
	    T old = value;
	    value = v;
	    return old;
	}
	public void setNext(LNode n){
	    next = n;
	}
	public String toString(){
	    return value.toString();
	}
    }

    LNode head;
    LNode tail;
    int size;
    
    public Iterator<T> iterator(){
	//This uses an anonymous class! You don't need to know this.
	return new Iterator<T>()
	    {
		private LNode current = head;

		public boolean hasNext(){
		    return current != null;
		}
		public T next(){
		    if(!hasNext()){
			throw new NoSuchElementException();
		    }
		    T value = current.getValue();
		    current = current.getNext();
		    return value;
		}
		public void remove(){
		    throw new UnsupportedOperationException();
		}
	    };
    } 
    public String toString(){
	String ans = "[";
	LNode p = head;
	while(p!=null){
	    ans += p.getValue();
	    if(p.getNext()!=null){
		ans += ", ";
	    }
	    p = p.getNext();
	}
	return ans+"]";
    }
    public String toString(boolean b){
	return toString()+" head: "+head +", tail: "+tail;
    }
    private LNode getNth(int index){
	//check bounds before calling this method!
	LNode temp = head;
	while(index > 0){
	    temp = temp.getNext();
	    index --;
	}
	return temp;
    }
    public boolean add(T value){
	if(head == null){
	    head = new LNode(value);
	    tail = head;
	}else{
	    tail.setNext(new LNode(value));
	    tail = tail.getNext();
	}
	size++;
	return true;
    }
    public T remove(int index){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size());
	}
	LNode temp;
	if(index == 0){
	    temp = head;
	    head = head.getNext();
	    size--;
	    if(head == null){
		tail = null;
	    }
	    return temp.getValue();
	}else{
	    LNode p = getNth(index-1);
	    temp = p.getNext();
	    if(tail == temp){
		tail = p;
	    }
	    p.setNext(p.getNext().getNext());
	    size --;
	    return temp.getValue();
	}
    }
    public boolean add(int index, T value){
	if(index < 0 || index > size()){
	    throw new IndexOutOfBoundsException("Index "+index+", Size: "+size());
	}
	LNode temp = new LNode(value); 
	if(index == 0){
	    temp.setNext(head);
	    head = temp;
	    if(size==0){
		tail = head;
	    }
	}else{ 
	    LNode p = getNth(index-1);
	    temp.setNext(p.getNext());
	    p.setNext(temp);
	    if(tail.getNext() != null){
		tail=tail.getNext();
	    }
	}
	size++;
	return true;
    }
    
    public int size(){
	return size;
    }
    
    public T get(int index){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException("Index "+index+", Size: "+size());
	}
	return getNth(index).getValue();
    }

    public T set(int index, T newValue){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException("Index "+index+", Size: "+size());
	}
	return getNth(index).setValue(newValue);
    }

    public int indexOf(T target){
	LNode temp = head;
	int index = 0;
	while(temp != null){
	    if(temp.getValue().equals(target)){
		return index;
	    }
	    index++;
	    temp = temp.getNext();
	}
	return -1;
    }
}
