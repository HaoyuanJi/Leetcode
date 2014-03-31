import java.util.ArrayList;
import java.util.Stack;


public class Leetcode7 {

	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	  
	  public ArrayList<Integer> stackpreorderTraversal(TreeNode root) {
		    ArrayList<Integer> result = new ArrayList<Integer>();
		    Stack<TreeNode> working = new Stack<TreeNode>();
		    
		    if(root != null)
		    {
		      working.push(root);		
		      
		      while(!working.empty())
		      {		
		    	 TreeNode current = working.pop();
		    	 result.add(current.val);
		    	 //System.out.println(current.val);
		    	 
	    	     if (current.right != null)
	    	     {
	    	    	 working.push(current.right);
	    	     }
	    	     
	    	     if(current.left != null)
	    	     {
	    	    	 working.push(current.left);
	    	     }
		      }
		    }
		    
		   		  
	        return result;
	    }
	 
	  public static void main(String args[])
	  {
		  TreeNode root = new Leetcode7().new TreeNode(1);
		  TreeNode node1 = new Leetcode7().new TreeNode(2);
		  root.left = node1;
		  TreeNode node3 = new Leetcode7().new TreeNode(6);
		  root.right = node3;
		  TreeNode node2 = new Leetcode7().new TreeNode(3);
		  node1.right = node2;
		  
		  
		  ArrayList<Integer> result = new ArrayList<Integer>();
		  		  
          result = new Leetcode7().stackpreorderTraversal(root);
          
          for (Integer show:result)
          {
        	  System.out.println(show);
          }
		  
	  }
}
