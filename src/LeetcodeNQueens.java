import java.util.*;


public class LeetcodeNQueens {
    public static List<String[]> solveNQueens(int n) {
    	
    	List<String[]> finalresult = new ArrayList<String[]>();
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	List<Integer> rowcolums = new ArrayList<Integer>();

    	for(int i = 0; i < n; i++)
    		rowcolums.add(i+1);
    	
    	List<Integer> oneperm = new ArrayList<Integer>(rowcolums);
    	NQueensaux(result,rowcolums,oneperm, 0);
    	
    	for(int i = 0; i < result.size(); i++)
    	{
    		String[] solution = new String[n];
    		for(int j = 0; j < n; j++)
    		{
                char[] onerow = new char[n];
                for(int m = 0; m < n; m++)
                {
                	onerow[m] = '.';
                }
                onerow[result.get(i).get(j) - 1] = 'Q';
                String row = String.valueOf(onerow);
                
                solution[j] = row;

    		}
			finalresult.add(solution);
    	}
        return finalresult;
    }
    
    public static void NQueensaux(List<List<Integer>> result,List<Integer> rowcolums,List<Integer> oneperm,int begin)
    {
          if(begin >= rowcolums.size())
          {
        	  if(isEligible(oneperm))
        	  {
        	       result.add(new ArrayList<Integer>(oneperm));
        	  }
        	  return;
          }
          
          for(int i = begin; i < rowcolums.size();i++)
          {
        	  Integer buffer;
        	  buffer = oneperm.get(begin);
        	  oneperm.set(begin,oneperm.get(i));
        	  oneperm.set(i,buffer);
        	  
        	  NQueensaux(result,rowcolums,oneperm,begin+1);
        	  
        	  buffer = oneperm.get(begin);
        	  oneperm.set(begin,oneperm.get(i));
        	  oneperm.set(i,buffer);
          }
    }
    
    public static boolean isEligible(List<Integer> oneperm)
    {
    	for (int i = 0; i < oneperm.size(); i++)
    	{
    		for (int j = i + 1; j < oneperm.size(); j++)
        	{
        		if(oneperm.get(i) - oneperm.get(j) == i -j || oneperm.get(j) - oneperm.get(i) == i-j)
        		{
        			return false;
        		}
        	}
    	}
    	return true;
    }
    
    // For N-Queens II
    public static int totalNQueens(int n) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	List<Integer> rowcolums = new ArrayList<Integer>();

    	for(int i = 0; i < n; i++)
    		rowcolums.add(i+1);
    	
    	List<Integer> oneperm = new ArrayList<Integer>(rowcolums);
    	NQueensaux(result,rowcolums,oneperm, 0);
    	
        return result.size();
    }

	public static void main(String args[])
	{
		int result = totalNQueens(4);
		System.out.println(result);
//		List<String[]> result = solveNQueens(8);
//		for(String[] item:result)
//		{
//			for(String ele:item)
//			{
//				System.out.print(ele+" ");
//			}
//			System.out.print("\n");
//		}
	}
}
