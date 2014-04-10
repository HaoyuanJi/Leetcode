

public class Leetcodea10 {
	class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	
	
//	快慢指针法
    public boolean hasCycle(ListNode head) {
    	
    	if (head == null || head.next== null) return false;
    	ListNode fast = head.next.next;
    	ListNode slow = head.next;
    	
    	while (slow != null)
    	{
    		if (fast == null || fast.next == null)
    			return false;
    		else if (fast == slow)
    			return true;
    		else
    		{
    			slow = slow.next;
    			fast = fast.next.next;
    		}
  		
    	}
           	
    	return false;
    }
    
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        
        while (slow != null)
        {
        	if (fast == null || fast.next == null) return null;
        	else if (fast == slow)
        	{
        		ListNode collision = slow;
        		ListNode collision2 = head;
        		while (collision != collision2)
        		{
        			collision = collision.next;
        			collision2 = collision2.next;
        		}
        		return collision;
        	}
        	else
        	{
        		slow = slow.next;
        		fast = fast.next.next;
        	}
        }
    	
    	return null;
    }
    
    public int sizeCycle(ListNode head)
    { 
    	ListNode cyclehead = detectCycle(head);
    	if (cyclehead == null) 
    		return 0;
    	else if (cyclehead.next == cyclehead)
    		return 1;
    	else
    	{
    		ListNode movingcheck = cyclehead;
    		int sizecycle = 1;
    		while (movingcheck.next != cyclehead)
    		{
    			movingcheck = movingcheck.next;
    			sizecycle ++;
   
    		}
    		return sizecycle;  		
    	}

    }
    
    
	public static void main(String args[])
	{
		ListNode n1 = new Leetcodea10().new ListNode(1);
		ListNode n2 = new Leetcodea10().new ListNode(2);
		ListNode n3 = new Leetcodea10().new ListNode(3);
		ListNode n4 = new Leetcodea10().new ListNode(4);
		ListNode n5 = new Leetcodea10().new ListNode(5);
//		ListNode n6 = new Leetcodea10().new ListNode(6);
 
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n2;

		
//		boolean result = new Leetcodea10().hasCycle(n1);
//		ListNode test = new Leetcodea10().detectCycle(n1);
		int sizecycle = new Leetcodea10().sizeCycle(n1);
//	    ListNode ind = n1;
//	    while(ind != null)
//		{
//	    	System.out.println(ind.val);
//			ind = ind.next;			
//		}
		
	    System.out.println(sizecycle);
	}
}
