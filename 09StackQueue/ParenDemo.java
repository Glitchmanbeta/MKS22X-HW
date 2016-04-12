public class ParenDemo{
	
	public static void main(String[] args){
		String input = "()()(([[]]))";
		if(args.length > 0){
			input = args[0];
			System.out.println( isMatching(input)); 
		}else{
			System.out.println("Usage:"); 
			System.out.println("java ParenDemo \"text\""); 
		}
	}

	public static void about(){
		System.out.println("ParenDemo by Sammy Almawaldi\nWritten on 7 April 2016\nVersion 0.1.0");
	}

    public static boolean isMatching(String s){
	MyStack<Character> stack = new MyStack<Character>();
	for(int i = 0; i < s.length(); i++){
	    if(s.charAt(i) == '{' || 
	       s.charAt(i) == '[' || 
	       s.charAt(i) == '<' || 
	       s.charAt(i) == '(' ||
	       s.charAt(i) == '}' ||
	       s.charAt(i) == ']' ||
	       s.charAt(i) == '>' ||
	       s.charAt(i) == ')'){
		stack.push(s.charAt(i));
	    }
	}
	while(stack.size() > 0){
	    if(stack.size() % 2 == 1){
		return false;
	    }else{
		if(stack.pop() == '}'){
		    if(stack.peek() == '{'){
			stack.pop();
		    }else{
			return false;
		    }
		}
		else if(stack.pop() == ']'){
		    if(stack.peek() == '['){
			stack.pop();
		    }else{
			return false;
		    }
		}
		else if(stack.pop() == '>'){
		    if(stack.peek() == '<'){
			stack.pop();
		    }
		    else{
			return false;
		    }
		}
		else if(stack.pop() == ')'){
		    if(stack.peek() == '('){
			stack.pop();
		    }
		    else{
			return false;
		    }
		}
	    }
	}
	return true;
    }
}
