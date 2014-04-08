
public class Leetcode5 {
	class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	

public ListNode insertionSortList(ListNode head) {
	 if (head == null || head.next == null) return head;
   
     ListNode unorder = head.next;
     head.next = null;
     
     while (unorder != null)
     {
    	 ListNode current = unorder;
    	 unorder = unorder.next;
    	 current.next = null;
    	 
    	 ListNode working = head;
    	 ListNode prev = head;
    	 while (working != null)
    	 {
    		 if (working.val <= current.val)
    		 {
    			 if (working != head)
    			 {
    				 prev = prev.next;
    			 }
    			 working = working.next;
    		 }
    		 else
    		 {
    			 if (working == head)
    			 {
    				 current.next = working;
    				 head = current;
    				 working = null;
    				 current = null;
    			 }
    			 else
    			 {   				 
    			     prev.next = current;
    			     current.next = working;
    			     prev = prev.next;
    			     working = null;
    			     current = null;
    			 }
    			 
    		 }   		    		 
    	 }
    	 if (current != null)
    	 {
    		 prev.next = current;
    	 }
    	 
    	 
    	 
     }

	  return head;
    }


	public static void main(String[] args) {
		ListNode n1 = new Leetcode5().new ListNode(2);
		ListNode n2 = new Leetcode5().new ListNode(1);
//		ListNode n3 = new Leetcode5().new ListNode(8);
//		ListNode n4 = new Leetcode5().new ListNode(7);
// 
//		ListNode n5 = new Leetcode5().new ListNode(3);
//		ListNode n6 = new Leetcode5().new ListNode(8);
//		ListNode n7 = new Leetcode5().new ListNode(5);
//		ListNode n8 = new Leetcode5().new ListNode(4);
//		
 
		n1.next = n2;
//		n2.next = n3;
//		n3.next = n4;
//		n4.next = n5;
//		n5.next = n6;
//		n6.next = n7;
//		n7.next = n8;
//		
		//n1 = null;
		ListNode test = new Leetcode5().insertionSortList(n1);
//		ListNode head = new Leetcode4().mergeList(n1, n5);
		//System.out.println(test.val);
	    ListNode ind = test;
	    while(ind != null)
		{
	    	System.out.println(ind.val);
			ind = ind.next;			
		}
	}

}
