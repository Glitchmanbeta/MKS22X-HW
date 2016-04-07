import java.util.NoSuchElementException;

public class MyStack<T>{
	
	private MyLinkedList<T> stack;

	public static void main(String[] args){
		about();
		System.out.println("Testing...");
		try{
			MyStack<Integer> test = new MyStack<Integer>();
			about();
			test.push(1);
			test.push(2);
			test.push(3);
			test.push(4);
			test.pop();
			System.out.println(test.peek());
			test.push(5);
			test.push(6);
			test.push(7);
			test.pop();
			System.out.println(test.peek());
			for(int i = 0; i < 5; i++){
				test.pop();
			}
			System.out.println(test.isEmpty());
			System.out.println(test.toString());
		}
		catch(NoSuchElementException e){
			System.out.println("You done goofed.");
		}
	}

	public static void about(){
		System.out.println("MyStack by Sammy Almawaldi\nWritten on 7 April 2016\nVersion 1.0.0");
	}

	public MyStack(){
		stack = new MyLinkedList<T>();
	}

	public void push(T item){
		stack.add(item);
	}

	public T pop(){
		T retun;
		if(stack.size() == 0){
			throw new NoSuchElementException();
		}
		else{
			retun = stack.get(stack.size() -1);
			stack.remove(stack.size() - 1);
		}
		return retun;
	}

	public String toString(){
		return stack.toString();
	}

	public T peek(){
		if(stack.size() == 0){
			throw new NoSuchElementException();
		}
		else{
			return stack.get(stack.size() - 1);
		}
	}

	public int size(){
		return stack.size();
	}

	public boolean isEmpty(){
		return stack.size() == 0;
	}
}
