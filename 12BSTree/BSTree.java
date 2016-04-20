public class BSTree<T extends Comparable<T>>{

    Node root;

    public static void main(String[] bs){
	System.out.println("This tree is BS! (Short for Bob Saget)");
    }

    public class Node{
	T value;
	Node left, right;

	public T getValue(){
	    return value;
	}

	public void setValue(T data){
	    value = data;
	}

	public Node getLeft(){
	    return left;
	}

	public Node setLeft(Node x){
	    left = x;
	}

    }
}
