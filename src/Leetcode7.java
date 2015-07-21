import java.util.ArrayList;
import java.util.Stack;


public class Leetcode7 {

	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	  
	  // Preorder traversal is the simplest one.
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
		         //右子结点先进栈，左子结点再进栈，所以先访问的是左子结点 
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

	  
	  /* 非递归实现后序遍历 
	     * 除了最左的一个左子结点，把所有的左子结点相继入栈（是一个循环过程） 
	     * 这时p指向最左的那个左子结点， 
	     * 重复：若p没有右子结点（或者p的右子结点已经输出），则输出p，同时出栈，将值赋给p 
	     * 若p有右子结点，则将p入栈，同时p指向其右子结点 
	     * 重复以上步骤，直到p为空 
	     */  
	  public ArrayList<Integer> stackpostorderTraversal(TreeNode root) {
		  ArrayList<Integer> result = new ArrayList<Integer>();
		  Stack<TreeNode> working = new Stack<TreeNode>();
		  TreeNode lastvisited = root;
		  TreeNode current = root;
		  
		  while (current != null)
		  {
              while (current.left != null)
              {
            	  working.push(current);
            	  current = current.left;           	  
              }
			  
              while (current.right == null || current.right == lastvisited)
              {
            	  result.add(current.val);
            	  lastvisited = current;
            	  if (working.empty()) return result;
            	  current = working.pop();  	  
              }
              working.push(current);
              current = current.right;
			  
		  }

		  		  
		  return result;
	        
	    }
	
	  /* 非递归实现中序遍历 
	     * 沿左子结点一路向下 同时将右子结点以及本结点入栈
	     * 当栈不空且无右子树情况下：出栈，访问该节点
	     * 访问当前节点；如果栈不空，出栈，继续；否则结束返回
	     */  
	  
	  public ArrayList<Integer> stackinorderTraversal(TreeNode root)
	  {
		  ArrayList<Integer> result = new ArrayList<Integer>();
		  Stack<TreeNode> working = new Stack<TreeNode>();
		  TreeNode current = root;

          while (current != null)
          {
        	  while (current != null)
        	  {
        		  if (current.right !=null)
                     working.push(current.right);
        		  working.push(current);
        		  current = current.left;
        	  }
        	  current = working.pop();
        	  while (!working.empty() && current.right == null)
  			  {
        		  result.add(current.val);
        		  current = working.pop();
       		  }
        	  result.add(current.val);
        	  if (!working.empty()) current = working.pop();
        	  else current = null;
        	  
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
		  		  
          result = new Leetcode7().stackpostorderTraversal(root);
          
          for (Integer show:result)
          {
        	  System.out.println(show);
          }
		  
	  }
}
