import java.util.HashMap;


public class Leetcode6 {
	private static class Entry
	{
		int key;
		int value;
		Entry next;
		Entry prev;
		Entry(int key, int value)
		{
			this.key = key;
			this.value = value;
			this.next = null;
			this.prev = null;
		}
		
	}
	
	private final int capacity;
	private Entry first;
	private Entry end;
	private int size;
	private HashMap<Integer,Entry> find_map;
	
    public Leetcode6(int capacity) {
    	 this.capacity = capacity; 
    	 first = null;
    	 end = null;
    	 size = 0;
    	 find_map = new HashMap<Integer,Entry>();
    }
    
    public int get(int key) {
    	
    	if (find_map.get(key) == null)
    		return -1;
    	else
    	{
    		Entry current = find_map.get(key);
    		if (current != first)
    			{
    			   if(current == end)
    			   {
    				   end = end.prev;
    				  
    			   }
    			   current.prev.next = current.next;
    			   if(current.next != null)
    			       current.next.prev = current.prev;
    			   current.next = first;
    			   first.prev = current;
    			   first = current;
    			   
    			}
    		return find_map.get(key).value;
    	}        
    }
    
    public void set(int key, int value) {
    	int find_result = get(key);
    	if (find_result == -1)
    	{
    		if (size < capacity)
    		{    			
    		   if (first == null)
    		   {
    			  Entry newentry = new Entry(key,value);
    			  find_map.put(key, newentry); 
    			  first = newentry;
    			  end = newentry;
    		   }
    		   else
    		   {
    			  Entry newentry = new Entry(key,value);
    			  find_map.put(key, newentry); 
    			  first.prev = newentry;
    			  newentry.next = first;
    			  first = newentry;
    		   } 
    		   size ++;
    		}
    		else
    		{
    			Entry newentry = new Entry(key,value);			
    			if (end != null)
    			{  
    			   find_map.remove(end.key);
    			   find_map.put(key,newentry);
    			   if (end.prev == null)
    			   {
    				  first = newentry;
    				  end = newentry;
    			   }
    			   else
    			   {
    			      end.prev.next = null;
    			      end = end.prev;
    			      first.prev = newentry;
    			      newentry.next = first;
    			      first = newentry;

    			   }
    			}
    		}
    	}
    	else 
    	{
    		find_map.get(key).value = value;
    		first.value = value;
    	}
        
    }
    
	public static void main (String args[])
	{
		
		Leetcode6 test = new Leetcode6(3);
		test.set(1,1);
		test.set(2,2);
		test.set(3,3);
		test.set(4,4);
		test.get(4);
		test.get(3);
		test.get(2);

		
		Entry ind = test.first;
		while (ind != null)
		{
		   System.out.println(ind.key);
		   ind = ind.next;
		}
	}

}
