import java.util.NoSuchElementException;

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
		System.out.println("ParenDemo by Sammy Almawaldi\nWritten on 7 April 2016\nVersion 0.2.12");
	}

    public static boolean isMatching(String s){
		MyStack<Character> stack = new MyStack<Character>();
		try{
			for(int i = 0; i < s.length(); i++){
	    		if(s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '<' || s.charAt(i) == '('){
	    			stack.push(s.charAt(i));
	    		}
	    		else if(s.charAt(i) == '}'){
	    			if(stack.peek() == '{'){
	    				stack.pop();
	    			}
	    			else{
	    				return false;
	    			}
	    		}
	    		else if(s.charAt(i) == ']'){
	    			if(stack.peek() == '['){
	    				stack.pop();
	    			}
	    			else{
	    				return false;
	    			}
	    		}
	    		else if(s.charAt(i) == '>'){
	    			if(stack.peek() == '<'){
	    				stack.pop();
	    			}
	    			else{
	    				return false;
	    			}
	    		}
	    		else if(s.charAt(i) == ')'){
	    			if(stack.peek() == '('){
	    				stack.pop();
	    			}
	    			else{
	    				return false;
	    			}
	    		}
	    	}
	    }
	    catch(NoSuchElementException e){
	    	return false;
	    }
	    if(stack.size() > 0){
	    	return false;
	    }
	    return true;
	}
}
