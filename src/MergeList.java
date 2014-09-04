import java.util.*;



public class MergeList {
	
	// For merge sorted array
	public static void insert(int A[], int B[], int m, int i, int j)
	{
		for( int p = m; p > i ;p--)
			A[p] = A[p-1];
	     A[i] = B[j];
	}
     public static void merge(int A[], int m, int B[], int n) {
     	if(n == 0) return; 
    	if(m == 0) 
    	{
    	     for(int i = 0; i< n; i++)
    	    	 A[i] = B[i];
    	     return;
    	}
            	
        int i = 0;
        int j = 0;
        
        while(i < m && j < n)
        {
        	if(A[i] > B[j])
        	{
        		insert(A,B,m,i,j);
        		j++;
        		m++;
        	}
        	else i++;      			
        }
        if(i == m)
        {
        	while(j < n)
        	{
        		A[i] = B[j];
        		i++;
        		j++;
        	}
        }
        if(j == n) return;
    }
	
	 public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }
	
	 // For merge two sorted List
	public static ListNode merge(ListNode left, ListNode right)
	{
		if(left == null) return right;
		if(right == null) return left;
		ListNode finalresult;
		ListNode finalresult_point;
		
		if(left.val > right.val)
		{
			finalresult = right;
			right = right.next;
		}
		else
		{
			finalresult = left;
			left = left.next;
		}
		
		finalresult_point = finalresult;
		while(left!= null && right != null)
		{
			if(left.val > right.val)
			{
				finalresult_point.next = right;	
				right = right.next;
			}
			else
			{
				finalresult_point.next = left;
				left = left.next;
			}
			finalresult_point = finalresult_point.next;
		}
		
		if(left == null) finalresult_point.next = right;
		else finalresult_point.next = left;
		
		return finalresult;
	}
	
	// For merge k sorted list. Time complexity = log(k)*n
	public static ListNode mergeKLists(List<ListNode> lists) {
	        
		    if(lists.size() == 0) return null;
		    if(lists.size() == 1) return lists.get(0);
		    if(lists.size() == 2) 
		    	return merge(lists.get(0),lists.get(1));
		   
		    int middle = lists.size()/2;
		    List<ListNode> left = lists.subList(0, middle);
		    List<ListNode> right = lists.subList(middle,lists.size());
		    ListNode leftresult = mergeKLists(left);
		    ListNode rightresult = mergeKLists(right);
		    ListNode finalresult = merge(leftresult,rightresult);
		    return finalresult;
	    }
	
	public static void main(String args[])
	{
		ListNode one_1 = new ListNode(1);
		ListNode one_2 = new ListNode(3);
		ListNode one_3 = new ListNode(4);
		ListNode one_4 = new ListNode(6);
		ListNode two_1 = new ListNode(2);
		ListNode two_2 = new ListNode(5);
		ListNode two_3 = new ListNode(7);
		ListNode three_1 = new ListNode(4);
		ListNode three_2 = new ListNode(8);
		ListNode three_3 = new ListNode(10);
		ListNode three_4 = new ListNode(11);
		ListNode three_5 = new ListNode(15);
		ListNode four_1 = new ListNode(2);
		
		one_1.next = one_2;
		one_2.next = one_3;
		one_3.next = one_4;
		
		two_1.next = two_2;
		two_2.next = two_3;
		
		three_1.next = three_2;
		three_2.next = three_3;
		three_3.next = three_4;
		three_4.next = three_5;
		
		List<ListNode> lists = new ArrayList<ListNode>();
		lists.add(one_1);
		lists.add(two_1);
		lists.add(three_1);
		lists.add(four_1);
		
//		ListNode result = mergeKLists(lists);
//		//ListNode result = lists.get(3);
//		//ListNode result = merge(three_1,null);
//		
//		ListNode indi = result;
//		
//		//System.out.println(lists.size());
//		while(indi != null)
//		{
//			System.out.println(indi.val);
//			indi = indi.next;
//		}
		
		
		int[] A = new int[10];
		A[0] = 1;
		A[1] = 5;
		A[2] = 6;
		A[3] = 8;
		A[4] = 11;
		
		int[] B = new int[3];
		B[0] = 2;
		B[1] = 7;
		
		merge(A,0,B,2);
		
		for(int i = 0; i< 7; i++)
			System.out.println(A[i]);
	}
}
