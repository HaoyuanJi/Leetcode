import java.util.*;

public class LeercodeCombination {
	// For combination sum II
	
	   public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
	    	List<List<Integer>> result = new ArrayList<List<Integer>>();
	    	
	    	List<Integer> wholelist = new ArrayList<Integer>();
	    	List<Integer> onecomb = new ArrayList<Integer>();
	    	
	    	for (int i = 0; i < candidates.length; i++)
	    		wholelist.add(candidates[i]);

	    	quicksort(wholelist);

	    	combinationSumaux2(result,wholelist,onecomb,target,0);
	    	return result;
	    }
	    
	    public static void combinationSumaux2(List<List<Integer>> result, List<Integer> wholelist, List<Integer> onecomb, int target,int begin)
	    {
	    	
	    	if(target == 0)
	    	{
	    		List<Integer> temp = new ArrayList<Integer>(onecomb);	
	    		result.add(temp);
	    		return;
	    	}
	    	if(target < 0 || begin >= wholelist.size()) return;
	    	for(int i = begin; i<wholelist.size(); i++)
	    	{
	    		
	    		if(i>begin && wholelist.get(i-1) == wholelist.get(i)) continue;
	    		Integer working = wholelist.get(i);
	    		onecomb.add(working);
	    		
	    		combinationSumaux2(result,wholelist,onecomb,target - working,i+1);
	    		onecomb.remove(onecomb.size() -1);
	    		
	    	}
	    }

	// For combination sum
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	List<Integer> wholelist = new ArrayList<Integer>();
    	List<Integer> onecomb = new ArrayList<Integer>();
    	
    	for (int i = 0; i < candidates.length; i++)
    		wholelist.add(candidates[i]);
    	
    	combinationSumaux(result,wholelist,onecomb,target);
    	return result;
    }
    
    public static void combinationSumaux(List<List<Integer>> result, List<Integer> wholelist, List<Integer> onecomb, int target)
    {
    	if(sum(onecomb) > target) return;
    	if(target == sum(onecomb))
    	{
    		List<Integer> temp = new ArrayList<Integer>(onecomb);
    		quicksort(temp);
    		if(result.contains(temp)) return;  		
    		result.add(new ArrayList<Integer>(temp));
    		return;
    	}
    	
    	for(int i = wholelist.size() -1; i>=0; i--)
    	{
    		onecomb.add(wholelist.get(i));
    		combinationSumaux(result,wholelist,onecomb,target);
    		onecomb.remove(onecomb.size() -1);
    	}
    }
    
    public static int sum(List<Integer> list)
    {
    	int sum = 0;
    	for(Integer item:list)
    	   sum = sum + item;
    	return sum;
    }
	
	// For combinations
     public static List<List<Integer>> combine(int n, int k) {
    	 
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	List<Integer> wholelist = new ArrayList<Integer>();
    	List<Integer> onecomb = new ArrayList<Integer>();
    	
    	for(int i = 0; i< n; i++)
    		wholelist.add(i+1);
    	
    	combineaux(result,wholelist,onecomb,0,k);
        return result;
    }
     
     public static void combineaux( List<List<Integer>> result, List<Integer> wholelist, List<Integer> onecomb, int begin, int pick)
     {
    	 if(pick == 0)
    	 {
    		 result.add(new ArrayList<Integer>(onecomb));
    		 return;
    	 }
    	 
    	 if (begin == wholelist.size()) return;
    	 
    	 onecomb.add(wholelist.get(begin));
    	 combineaux(result,wholelist,onecomb,begin+1,pick -1);
    	 onecomb.remove(onecomb.size() -1);
    	 combineaux(result, wholelist,onecomb,begin+1,pick);
     }
	
//	// Quick Sort for Subset I II
	public static int getmiddle(List<Integer> onecomb, int begin, int end)
	{
		int buffer = onecomb.get(begin);
		
		while(begin < end)
		{
			while(begin < end && onecomb.get(end) >= buffer)
				end --;
			onecomb.set(begin, onecomb.get(end));
			while(begin < end && onecomb.get(begin) <= buffer)
				begin ++;
			onecomb.set(end, onecomb.get(begin));
		}
		
		onecomb.set(begin, buffer);
		return begin;
	}
	public static void _quicksort(List<Integer> onecomb, int begin, int end)
	{
	   if(begin < end)
	   {
		int middle = getmiddle(onecomb,begin,end);
		_quicksort(onecomb, begin, middle -1);
		_quicksort(onecomb, middle +1, end);
	   }
	}
	
	public static void quicksort(List<Integer> onecomb)
	{
		if(onecomb.size()>0)
			_quicksort(onecomb,0,onecomb.size()-1);
	}
	
	 public static void combine(List<List<Integer>> result, List<Integer> wholelist,List<Integer> onecomb, int start, int pick)
	 {
		 if(pick == 0)
		 {
			 List<Integer> temp = new ArrayList<Integer>(onecomb);
			 quicksort(temp);
			 if(result.contains(temp)) return; // for Subset II
			 result.add(temp);
			 return;
		 }
		 
		 if(start == wholelist.size())
		 {
			 return;
		 }
		 
		 onecomb.add(wholelist.get(start));
		 combine(result,wholelist,onecomb,start+1,pick-1);
		 onecomb.remove(onecomb.size() -1);
		 combine(result,wholelist,onecomb,start+1,pick);
		 
	 }
	 public static List<List<Integer>> subsets(int[] S) {
		 
		    List<List<Integer>> result = new ArrayList<List<Integer>>();
		    List<Integer> onecomb = new ArrayList<Integer>();
		    List<Integer> wholelist = new ArrayList<Integer>();
		    
		    for (int i = 0; i< S.length; i++)
		    	wholelist.add(S[i]);
		    
		    result.add(new ArrayList<Integer>());
		    for(int i = 1; i <= S.length; i++)
                    combine(result, wholelist, onecomb, 0, i);
		    	
		   
	        return result;
	    }
	 
	public static void main(String[] args)
	{
		int[] S ={1};
		
		List<List<Integer>> result = combinationSum2(S,1);

		for(List<Integer> item:result)
		{
			for(Integer ele:item)
			{
				System.out.print(ele+" ");
			}
			System.out.print("\n");
		}

	}

}
