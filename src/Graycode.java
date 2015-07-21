import java.util.*;

public class Graycode {
    public static List<Integer> grayCode(int n) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        
        grayCodehelper(n,results);
        
        return results;
    }
    
    public static void grayCodehelper(int n,ArrayList<Integer> results)
    {
        if(n == 1) 
        {
            results.add(0);
            results.add(1);
            return;
        }
        
        grayCodehelper(n - 1, results);
        
        int original_size = results.size();
        for(int i = 0; i < original_size; i++)
        {
            int highestbit = 0 << (n-1);
            results.add(highestbit + results.get(i));
        }
        
        for(int i = original_size - 1; i >= 0; i--)
        {
        	int highestbit = 1 << (n-1);
            results.add(highestbit + results.get(i));
        }
        for(int i = 0; i < original_size; i++)
        	results.remove(0);
    }
    
    public static boolean nextgraycode(byte a, byte b)
    {
        
    	return false;
    }
    public static void main(String args[])
    {
    	List<Integer> results= grayCode(3);
    	
    	for(Integer item:results)
    		
    	    System.out.println(Integer.toBinaryString(item));
    }

}
