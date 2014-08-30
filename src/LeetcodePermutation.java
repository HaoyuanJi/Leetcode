import java.util.*;


public class LeetcodePermutation {
	// For Permutation Sequence
	
	public static int fact(int n)
	{
		if (n == 0) return 1;
		return n*fact(n-1);
	}
    public static String getPermutation(int n, int k) {
      if (n == 0) return null;
      ArrayList<Character> checklist = new ArrayList<Character>();
      
      for(int i = 0; i< n; i++)
      {
    	  char[] value = String.valueOf(i+1).toCharArray();
    	  checklist.add(value[0]);
      }
      
      
      char[] result = new char[n];
      char justthis;
       
       for (int i = 0; i < n;i++)
       {
    	   int num;
    	   if( k % fact(n-1-i) == 0)
    		   num = k/fact(n-1-i) - 1; 
    	   else
    	       num = k/fact(n-1-i);
    	   

    	   justthis = checklist.get(num);

    	   k = k - num * fact(n-1-i); 
           result[i] = justthis;
    	   justthis = checklist.remove(num);
       }
       
    	return String.valueOf(result);
    
    }
    
    
	// For Next Permutations
	private static int[] reverse(int[] num, int begin, int end)
	{
		System.out.println(num[4]);
		for(int m = begin; m < (end - begin)/2 + begin; m++)
		{
			swap(num,m,end + begin - m -1 );
		}
		System.out.println(num[4]);
		return num;
	}
	private static void swap(int[] num,int begin,int end)
	{
		int buffer;
		buffer = num[begin];
		num[begin] = num[end];
		num[end] = buffer;
	}	
	public static void nextPermutation(int[] num)
	{
		if(num.length <=1) return;
		int needchange = -1;
		int forchange = -1;
		for(int i = num.length -1; i>0; i--)
		{
			if(num[i] > num[i-1])
			{
				needchange = i - 1;
				break;
			}
		}
		
		
		if(needchange != -1) 
		{		

		  for(int j = num.length -1;j > needchange; j--)
		  {
			  if(num[j] > num[needchange])
			  {
				  
				  forchange = j;
				  swap(num,needchange,forchange);
				  break;
			  }
		   }
		     
		}

		
		reverse(num, needchange+1, num.length);
		return;
	}
	
	// For Leetcode Permutations
     public static List<List<Integer>> permuteIter(int[] num) {
     	if(num.length == 0) return null;
     	
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	List<Integer> oneperm = new ArrayList<Integer>();
    	
    	for(int p = 0; p< num.length; p++)
    	{
    		oneperm.add(num[p]);
    	}

    	permuteIteraux(result,oneperm,0);
    	
        return result;
    }
	private static void permuteIteraux(List<List<Integer>> result, List<Integer> oneperm, int begin)
	{
		if(begin == oneperm.size() -1) 
		{	
			result.add(new ArrayList<Integer>(oneperm));
			return;
		}
		
		for(int j = begin; j<oneperm.size(); j++)
		{
			Integer buffer;
			buffer = oneperm.get(begin);
			oneperm.set(begin, oneperm.get(j));
			oneperm.set(j, buffer);			
									
			permuteIteraux(result,oneperm,begin+1);
			
			buffer = oneperm.get(begin);
			oneperm.set(begin, oneperm.get(j));
			oneperm.set(j, buffer);	
		}

	}
	// For Leetcode Permutations II
    public static List<List<Integer>> permuteUniqueIter(int[] num) {
    	if(num.length == 0) return null;
    	
   	List<List<Integer>> result = new ArrayList<List<Integer>>();
   	List<Integer> oneperm = new ArrayList<Integer>();
   	
   	for(int p = 0; p< num.length; p++)
   	{
   		oneperm.add(num[p]);
   	}

   	permuteIteraux2(result,oneperm,0);
   	
       return result;
   }
    private static boolean needSwap(List<Integer> oneperm, int begin, int end)
    {
    	Integer compitem = oneperm.get(end);
    	for(int m = begin; m<end; m++)
    	{
    		if(oneperm.get(m).equals(compitem)) 
    			{
    			   return false;
    			}
    	}
    	return true;
    }
	private static void permuteIteraux2(List<List<Integer>> result, List<Integer> oneperm, int begin)
	{
		if(begin == oneperm.size()) 
		{	
			result.add(new ArrayList<Integer>(oneperm));
			return;
		}

		for(int j = begin; j<oneperm.size(); j++)
		{
			if(needSwap(oneperm,begin,j))
			{
			  Integer buffer;
			  buffer = oneperm.get(begin);
			  oneperm.set(begin, oneperm.get(j));
			  oneperm.set(j, buffer);			
									
			  permuteIteraux2(result,oneperm,begin+1);
			
			  buffer = oneperm.get(begin);
			  oneperm.set(begin, oneperm.get(j));
			  oneperm.set(j, buffer);	
			}
		}

	}
	
	public static void main(String args[])
	{
		int[] num = {2,2};
		
		System.out.println(getPermutation(2,2));
//		nextPermutation(num);
//		//reverse(num);
//		for(int n = 0; n < num.length; n++)
//		{
//			System.out.println(num[n]);
//		}
		
		//

//		List<List<Integer>> result = permuteUniqueIter(num);
//
//		for(List<Integer> item:result)
//		{
//			for(Integer ele:item)
//			{
//				System.out.print(ele+" ");
//			}
//			System.out.print("\n");
//		}

	}

}
