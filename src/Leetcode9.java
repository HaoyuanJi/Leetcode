import java.util.Stack;


public class Leetcode9 {
	class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }
	
    public void reorderList(ListNode head) {
    	if (head == null || head.next == null) return;
        Stack<ListNode> aux = new Stack<ListNode>();
        ListNode working = head;
        int count = 0;
        while (working != null)
        {
        	count ++;
        	aux.push(working);
        	working = working.next;
        }
	    int half = count/2 ;
	    
	    working = head;
	    ListNode prev = head;
	    for (int i = 1; i <= half; i++)
	    { 
	    	if (working != head)
	    		prev = prev.next;
	    	working = working.next;	
	    	ListNode insertion = aux.pop();
	    	insertion.next = working;
	    	prev.next = insertion;
	    	prev = prev.next;
	    	
	    }
	    working.next = null;
//	    ListNode snd = working.next;
//	    working.next = null;
//	    
//	    while (snd != null)
//	    {
//	    	
//	    }
    }
	
	public static void main(String args[])
	{
		ListNode n1 = new Leetcode9().new ListNode(1);
		ListNode n2 = new Leetcode9().new ListNode(2);
//		ListNode n3 = new Leetcode9().new ListNode(3);
//		ListNode n4 = new Leetcode9().new ListNode(4);
//		ListNode n5 = new Leetcode9().new ListNode(5);
//		ListNode n6 = new Leetcode9().new ListNode(6);
 
		n1.next = n2;
//		n2.next = n3;
//		n3.next = n4;
//		n4.next = n5;
//		n5.next = n6;

		
		new Leetcode9().reorderList(n1);
//		ListNode head = new Leetcode4().mergeList(n1, n5);
		//System.out.println(test.val);
	    ListNode ind = n1;
	    while(ind != null)
		{
	    	System.out.println(ind.val);
			ind = ind.next;			
		}
		
		
	}

}
