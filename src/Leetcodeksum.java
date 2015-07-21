
import java.util.*;
public class Leetcodeksum {
	
	// This is for 4 sum
	// numbers = {1,0,-1,0,-2,2}
	// numbers = {-2,-1,0,0,1,2}
	 public static List<List<Integer>> fourSum(int[] num, int target) {
		 List<List<Integer>> results = new ArrayList<List<Integer>>();
		 Arrays.sort(num);
		 
		 for(int i = 0;i< num.length -3; i++)
		 {
			 List<Integer> one_result = new ArrayList<Integer>();
			 if(i == 0 || (i !=0 && num[i] != num[i-1]))
			 {
			     one_result.add(num[i]);
			 
			     int target2 = target - num[i];
			 
			     for(int j = i+1; j < num.length -2; j++)
			     {
			    	 if(j == 0 || (j != 0 && num[j] != num[j-1]))
			    	 {
				          one_result.add(num[j]);
				          int target3 = target2 - num[j];
				 
				          Map<Integer,Integer> check = new HashMap<Integer,Integer>();
				          for(int m = j+1; m < num.length; m++)
				          {
					          if(check.containsKey(num[m]))
					          {
					        	  if(check.get(num[m]) == 0)
					        	  {
					        		  one_result.add(target3 - num[m]);
					        		  one_result.add(num[m]);
					        		  results.add(new ArrayList<Integer>(one_result));
					        		  one_result.remove(one_result.size() - 1);
					        		  one_result.remove(one_result.size() - 1);
					        		  check.put(num[m],1);
					        	  }
					          }
					          else
					          {
					        	  check.put(target3 - num[m], 0);
					          }
				           }
			    	 }
				 
				 
				 
			      }
			  }
					 
		 }
		 
		 return results;
	        
	    }
	// This is for 3 sum cloest
	
    public static int threeSumClosest(int[] num, int target) {
    	//int sum = 0;
    	int min = Integer.MAX_VALUE;
    	int sum_min = Integer.MAX_VALUE;

    	Arrays.sort(num);
    	
    	for(int m = 0; m < num.length; m++)
    	{
    		
    		if(m == 0 || (m != 0 && num[m] != num[m-1]))
    		{ 		   
    	    	int i = m + 1;
    	    	int j = num.length - 1;
    	    	
    	    	while(i < j)
    	    	{
    	    		int sum = num[m] + num[i] + num[j];
    	    		int diff = Math.abs(target - sum);
    	    		if(diff < min)
    	    		{
    	    			min = diff;
    	    			sum_min = sum;
    	    		}
    	    		if(sum == target)
    	    		{
    	    			return sum;
    	    		}
    	    		else if(sum < target)
    	    			i++;
    	    		else
    	    			j--;
    	    	}
    		}
    		
    	}
        return sum_min;
    }
    

	// This is for 3 sum
    public static List<List<Integer>> threeSum(int[] num) {
    	
    	List<List<Integer>> results = new ArrayList<List<Integer>>();
    	
    	Arrays.sort(num);
    	
    	for(int i = 0; i < num.length; i++)
    	{
    		
    		if(i == 0 || (i != 0 && num[i] != num[i-1]))
    		{
    		   List<Integer> one_result = new ArrayList<Integer>();
    		   one_result.add(num[i]);
    		   
    		   twoSumaux(num, -num[i], results, one_result,i+1);
    		}
    		
    	}
    	
    	return results;
        
    }
    
    public static void twoSumaux(int[] numbers, int target, List<List<Integer>> results, List<Integer> one_result, int start)
    {
    	Map<Integer, Integer> check = new HashMap<Integer, Integer>();
    	
    	for(int i = start; i < numbers.length; i++)
    	{
    		if(check.containsKey(numbers[i]))
    		{
              if(check.get(numbers[i]) == 0)
              {
    			one_result.add(target-numbers[i]);
    			one_result.add(numbers[i]);
    			check.put(numbers[i], 1);
    			results.add(new ArrayList<Integer>(one_result));
    			one_result.remove(one_result.size() - 1);
    			one_result.remove(one_result.size() - 1);
              }
    		}
    		else
    		{
    			check.put(target - numbers[i], 0);
    		}
    	}
    		
    }
    
	
	// This is for 2 sum

    public static int[] twoSum(int[] numbers, int target) {
    	
    	int[] result = new int[2];
    	Map<Integer,Integer> check = new HashMap<Integer,Integer>();
    	
    	for(int i = 0; i < numbers.length; i++)
    	{
    		if(check.containsKey(numbers[i]))
    		{
    			result[1] = i+1;
    			result[0] = check.get(numbers[i]) + 1;
    			System.out.print(result[0]+" "+result[1]+"\n");
    			
    		}
    		
    		else
    		{
    			check.put(target - numbers[i], i);
    		}
    	}
    	
    	
    	
        return result;
    }
	
	public static void main(String args[])
	{
		int[] numbers = {1,0,-1,0,-2,2};
		
//		int sum = fourSum(numbers,0);
//		System.out.println(sum);
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		result = fourSum(numbers,0);
		for(List<Integer> list: result)
		{
			for(Integer item:list)
				System.out.print(item+" ");
			System.out.print("\n");
		}
	}
}
