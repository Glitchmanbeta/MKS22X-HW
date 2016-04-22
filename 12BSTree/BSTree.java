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
	    int x = value.compareTo(this.value);
	    switch(x){
	    case x < 0: setLeft(new Node(value));
		break;
	    case x >= 0: setRight(new Node(value));
		break;
	    }
	}
	
	public String toString(){
	    String s = "";
	    return s;
	}
    }

    public int height(){
	return root.height();
    }

    public void add(T value){
	add(value, root);
    }

    public void add(T value, Node localroot){
	if(localroot.getLeft() == null  && localroot.getRight() == null){
	    localroot.add(value);
	}
	int x = value.compareTo(localroot.getValue());
	switch(x){
	case x < 0:
	    if(localroot.getLeft() != null){
		add(value, localroot.getLeft);
		break;
	    }
	    else{
		localroot.add(value);
		break;
	    }
	case x >= 0:
	    if(localroot.getRight() != null){
		add(value, localRoot.getright);
		break;
	    }
	    else{
		localroot.add(value);
		break;
	    }
	}
    }
}
