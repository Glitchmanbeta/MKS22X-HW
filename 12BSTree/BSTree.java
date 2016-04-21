public class BSTree<T extends Comparable<T>>{

    Node root;

    public static void main(String[] bs){
	System.out.println("This tree is BS!");
    }

    public class Node{
	T value;
	Node left, right;

	public Node(T x){
	    value = x;
	}
	public T getValue(){
	    return value;
	}

	public void setValue(T data){
	    value = data;
	}

	public Node getLeft(){
	    return left;
	}

	public void setLeft(Node x){
	    left = x;
	}

	public Node getRight(){
	    return right;
	}

	public void setRight(Node x){
	    right = x;
	}

	public int height(){
	    if(left != null && right != null){
		return left.height() + right.height() + 1;
	    }
	    else if(left != null && right == null){
		return left.height() + 1;
	    }
	    else if(left == null && right != null){
		return right.height() + 1;
	    }
	    else{
		return 1;
	    }
	}
	
	public void add(T value){
	    
	}
    }
}
