
public class MaxsubArray {
	 public static int maxSubArray(int[] A) {
	        if(A.length == 1) return A[0];
	        int start = 0;
	        int sum = A[0];
	        int max = A[0];
	        if(sum < 0)
	          sum = 0;
	          
	        
	        for(int i =1; i < A.length; i++)
	        {
	            
	            sum = sum + A[i];
	            if(sum > max)
	            {
	                max = sum;
	            }
	            if(sum < 0) 
	            {
	                start = i + 1;
	                sum = 0;
	            }
	            
	        }
	        return max;
	        
	    }
	 
	   public static void main(String[] args)
	   {
		   int[] A = {-2,1};
		   System.out.println(maxSubArray(A));
	   }
}
