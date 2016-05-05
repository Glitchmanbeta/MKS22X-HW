public class BSTree<T extends Comparable<T>>{

    Node root;

    public static void main(String[] bs){
    	System.out.println("This tree is BS!");
    	BSTree<Integer> sb = new BSTree<Integer>(4);
    	System.out.println(sb.toString());
    	sb.add(2);
    	sb.add(3);
    	sb.add(6);
    	sb.add(1);
    	sb.add(5);
    	sb.add(7);
    	sb.add(8);
    	sb.add(9);
    	System.out.println(sb.toString());
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
	    	if(value.compareTo(this.value) < 0){
	    		setLeft(new Node(value));
			}
			else{
	    		setRight(new Node(value));
	    	}
		}
	
		public String toString(Node localroot){
			String s = "";
			if(localroot == null){
				return "_";
			}
			else{
				s = localroot.value.toString();
				if(left == null){
					s += "_";
				}
				else{
					s += "" + toString(localroot.left);
				}
				if(right == null){
					s += "_";
				}
				else{
					s += "" + toString(localroot.right);
				}
				return s;
			}
		}

		public boolean contains(T value){
			return false;
		}
    }

    public BSTree(T x){
    	root = new Node(x);
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
		else if(value.compareTo(localroot.getValue()) < 0){
	    	if(localroot.getLeft() != null){
	    		add(value, localroot.getLeft());
	    	}
	    	else{
	    		localroot.add(value);
	    	}
	    }
	    else{
	    	if(localroot.getRight() != null){
	    		add(value, localroot.getRight());
	    	}
	    	else{
	    		localroot.add(value);
	    	}
	    }
	}

	public String toString(){
		return root.toString(root);
	}
}
