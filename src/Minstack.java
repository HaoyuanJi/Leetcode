
import java.util.*;
public class Minstack {
    private Stack<Integer> store = new Stack<Integer>();
    private Stack<Integer> min = new Stack<Integer>();
    
    public void push(int x) {
        store.add(x);
        if(min.empty() || min.peek() >= x)
           min.add(x);
        
    }

    public void pop() {
        if(store.empty()) return;
   
    	
        if(!min.empty() && store.peek().equals(min.peek()))
        {
            min.pop();
        }
        store.pop();
    }

    public int top() {
    
        return store.peek();
    }

    public int getMin() {
        return min.peek();
    }
    
    public static void main(String[] args)
    {
    	Minstack ms = new Minstack();
    	
    	ms.push(512);
    	ms.push(-1024);
    	ms.push(-1024);
    	ms.push(512);
    	ms.pop();
    	System.out.println(ms.getMin());
    	ms.pop();
    	System.out.println(ms.getMin());
    	ms.pop();
    	System.out.println(ms.getMin());
    	ms.pop();
    	
    }
}
