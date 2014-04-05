import java.util.Stack;



public class Leetcode2 {
	 
	public int evalRPN(String[] tokens) {
		   Stack<String> store = new Stack<String>();
		   int left,right;
		   int result = Integer.parseInt(tokens[0]);
		   for (int i = 0; i < tokens.length; i++)
		   {
			   String working = tokens[i];
			   if (working.equals("+"))
			   {
				  right = Integer.parseInt(store.pop());
				  left = Integer.parseInt(store.pop());
				  result = left + right; 
				  store.push(String.valueOf(result));
				   
			   }
			   else if (working.equals("-"))
			   {
				   right = Integer.parseInt(store.pop());
				   left = Integer.parseInt(store.pop());
				  result = left - right; 
				  store.push(String.valueOf(result));
				   
			   }
			   else if (working.equals("*"))
			   {
				  right = Integer.parseInt(store.pop());
				  left = Integer.parseInt(store.pop());
				  result = left * right; 
				  store.push(String.valueOf(result));
				   
			   }
			   else if (working.equals("/"))
			   {
				  right = Integer.parseInt(store.pop());
				  left = Integer.parseInt(store.pop());
				  result = left / right;
				  store.push(String.valueOf(result));
				  
				   
			   }
			   else store.push(working);
			  			   
		   }
				
	        return result;
	    }
	 
	 
	 public static void main(String args[])
	 {
		 String[] tokens = {"4", "13", "5", "/", "+"};
		 
		 int result = new Leetcode2().evalRPN(tokens);
		 
		 System.out.println(result);
	 }
}
