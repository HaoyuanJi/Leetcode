
public class LeetcodeList {
	
	public static class ListNode {
		     int val;
		     ListNode next;
		     ListNode(int x) {
		         val = x;
		         next = null;
		     }
		 }
	
	// For remove duplicate from sorted list
   public static ListNode deleteDuplicates(ListNode head) {
       ListNode pointer = head;
       
       if(pointer == null || pointer.next == null)
    	   return head;
       ListNode pointer_n = pointer.next;
       
       while(pointer_n!=null)
       {
    	   if(pointer_n.val == pointer.val)
    	   {
    		  
    		   pointer.next = pointer_n.next;
    		   pointer_n = pointer_n.next;
    	   }
    	   else
    	   {
    		   pointer_n = pointer_n.next;
    		   pointer = pointer.next;
    	   }
    	     	   
       }
	   
	   
	   return head;
    }
	
	//For partition list
	 public static ListNode partition(ListNode head, int x) {
		    ListNode pointer = head;
		    ListNode previous = head;
		    ListNode label = null;
		    while(pointer != null)
		    {
		    	if(pointer.val >= x)
		    	{
		    		label = pointer;
		    		break;
		    	}
		    	
		    		previous = pointer;
                    pointer = pointer.next;
		    }
		    
	    	ListNode previous2 = previous;
		    if(label != null)
		    {

		    	while(pointer != null)
		    	{
		    		if(pointer.val < x)
		    		{
		    			if(label == head)
		    			{
		    				previous = pointer;
		    				ListNode buffer = pointer.next;
		    				pointer.next = head;
		    				head = pointer;
		    				pointer = buffer;
		    				previous2.next = buffer;
		    				//previous = pointer;
		    				
		    			}
		    			else
		    			{
		    			    previous.next = pointer;
		    			    previous = pointer;
		    			    ListNode buffer = pointer.next;
		    			    pointer.next = label;
		    			    previous2.next = buffer;
		    		     	pointer = buffer;
		    			}
		    			
		    		}
		    		else
		    		{
		    			previous2 = pointer;
		    			pointer = pointer.next;
		    		}
		    		
		    	}
		    }

		   //System.out.println(previous.val);
	        return head;
	    }
	
	// For swap pairs
    public static ListNode swapPairs(ListNode head) {
    	if(head == null || head.next == null) return head;
    	
    	ListNode pointer = head;
    	ListNode previous = head;
    	ListNode n_pointer = head.next;
    	
    	while(pointer != null && n_pointer != null)
    	{
 		     pointer.next = n_pointer.next;
 		     n_pointer.next = pointer;
    	     if(previous == head)
    		 {

    		    head = n_pointer;   		   
    		 }
    		 else
    		 {
    			previous.next = n_pointer;
    		 }
    	     previous = pointer;
    	     pointer = pointer.next;
    		
    		if(pointer == null) break;
    		else
    		    n_pointer = pointer.next;    		
    	}
    	
    	
    	
    	
     return head;   
    }
    
    
    // For add two number;
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null)
        	return null;
        
        ListNode pointer_l1 = l1;
        ListNode pointer_l2 = l2;
        ListNode result = null;
        ListNode result_pointer = null;
        int residue = 0;
        
        while(pointer_l1!=null && pointer_l2 != null)
        {
        	int calculate = pointer_l1.val + pointer_l2.val + residue;
        	pointer_l1 = pointer_l1.next;
        	pointer_l2 = pointer_l2.next;
        	if(calculate >=10)
        	{
        		residue = 1;
        		calculate = calculate - 10;
        	}
        	else
        		residue = 0;
        	if(result == null)
        	{
        		result = new ListNode(calculate);
        		result_pointer = result;
        	}
        	else
        	{
        		result_pointer.next = new ListNode(calculate);
        		result_pointer = result_pointer.next;
        	}
        		        	
        }
        
        while(pointer_l1 != null)
        {
        	int calculate = pointer_l1.val + residue;
        	pointer_l1 = pointer_l1.next;
        	if(calculate >=10)
        	{
        		residue = 1;
        		calculate = calculate - 10;
        	}
        	else
        		residue = 0;
        	
           	if(result == null)
        	{
        		result = new ListNode(calculate);
        		result_pointer = result;
        	}
        	else
        	{
        		result_pointer.next = new ListNode(calculate);
        		result_pointer = result_pointer.next;
        	}
 
        }
        
        while(pointer_l2 != null)
        {
        	int calculate = pointer_l2.val + residue;
        	pointer_l2 = pointer_l2.next;
        	if(calculate >=10)
        	{
        		residue = 1;
        		calculate = calculate - 10;
        	}
        	else
        		residue = 0;
        	
           	if(result == null)
        	{
        		result = new ListNode(calculate);
        		result_pointer = result;
        	}
        	else
        	{
        		result_pointer.next = new ListNode(calculate);
        		result_pointer = result_pointer.next;
        	}
 
        }
        
        if(residue != 0)
        {
        	result_pointer.next = new ListNode(residue);
    		result_pointer = result_pointer.next;
        }
        return result;
    }
	
	
	public static void main(String args[])
	{
		ListNode l11 = new ListNode(3);
		ListNode l12 = new ListNode(3);
		ListNode l13 = new ListNode(3);
		ListNode l14 = new ListNode(3);
		ListNode l15 = new ListNode(3);
		
		ListNode l21 = new ListNode(0);
		ListNode l22 = new ListNode(2);
		ListNode l23 = new ListNode(7);
		ListNode l24 = new ListNode(1);
		
		l11.next = l12;
		l12.next = l13;
		l13.next = l14;
		l14.next = l15;
		
//		l21.next = l22;
//		l22.next = l23;
//		l23.next = l24;
//		
		ListNode result = deleteDuplicates(l11);
		ListNode result_p = result;
		
		while(result_p != null)
		{
			System.out.println(result_p.val);
			result_p = result_p.next;
		}
	}

}
