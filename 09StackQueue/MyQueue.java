import java.util.NoSuchElementException;

public class MyQueue<T>{

	private MyLinkedList<T> queue;

	public static void main(String[] args){
		MyQueue<Integer> test = new MyQueue<Integer>();
		test.enqueue(1);
		test.enqueue(2);
		test.enqueue(3);
		test.enqueue(4);
		test.dequeue();
		test.enqueue(5);
		test.enqueue(6);
		test.enqueue(7);
		test.dequeue();
		test.dequeue();
		System.out.println(test.toString());
	}

	public static void about(){
		System.out.println("MyQueue by Sammy Almawaldi\nCopyright 2016\nVersion 0.6.21");
	}

	public MyQueue(){
		queue = new MyLinkedList<T>();
	}

	public void enqueue(T item){
		queue.add(item);
	}

	public T dequeue(){
		if(queue.size() == 0){
			throw new NoSuchElementException();
		}
		else{
			return queue.remove(0);
		}
	}

	public String toString(){
		return queue.toString();
	}

	public T peek(){
		return queue.get(0);
	}

	public int size(){
		return queue.size();
	}

	public boolean isEmpty(){
		return size == 0;
	}
}