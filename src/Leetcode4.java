
public class Leetcode4 {
	class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }
	
	public ListNode splitList(ListNode head)
	{
		int k = 0;
    	ListNode ind = head;
		while(ind != null)
		{
			k++;
			ind = ind.next;			
		}
	    ListNode sp = head;
	    int half = k/2;
	    for (int i = 0; i< half - 1; i++)
	    {
	    	sp = sp.next;
	    }
    	
	    return sp;	
	}
	
	public ListNode mergeList (ListNode fst, ListNode snd)
	{
		
		if (snd.val < fst.val)
		{
			ListNode temp = snd;
			snd = fst;
			fst = temp;
		}
		ListNode head = fst;
		ListNode prev = fst;
		
		while (snd != null && fst != null)
		{
			if (fst.val <= snd.val)
			{
				prev = fst; 
				fst = fst.next;
			}
			else 
			{
				ListNode newsnd = snd.next;
				snd.next = fst;
				if (prev != fst)
				{	
					prev.next = snd;
					prev = snd;
				}
				snd = newsnd;
			}
			
		}
		if (snd != null)
		{
			prev.next = snd;			
		}
		return head;
	};
    public ListNode sortList(ListNode head) {
    	
    	if (head == null || head.next == null) return head;
    	
	    ListNode sp = splitList(head);
	    ListNode endFirst = sp;
	    sp = sp.next;
	    endFirst.next = null;   
	    ListNode fst = head;
	    

	    
	    
	    
	    fst = sortList(fst);
	    sp = sortList(sp);
	    

	    
	    head = mergeList(fst,sp);

    	
    	return head;
        
    }
	
	public static void main(String[] args) {
		ListNode n1 = new Leetcode4().new ListNode(3);
		ListNode n2 = new Leetcode4().new ListNode(6);
		ListNode n3 = new Leetcode4().new ListNode(8);
		ListNode n4 = new Leetcode4().new ListNode(7);
 
		ListNode n5 = new Leetcode4().new ListNode(3);
		ListNode n6 = new Leetcode4().new ListNode(8);
		ListNode n7 = new Leetcode4().new ListNode(5);
		ListNode n8 = new Leetcode4().new ListNode(4);
		
 
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		
		//n1 = null;
		ListNode test = new Leetcode4().sortList(n1);
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
