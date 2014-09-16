
public class LeetcodeSearch {
	// For search a 2D matrix
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = searchMatrixrow(matrix, 0, matrix.length -1, target);
        //System.out.println(row);
        //return true;
       if(row < 0) return false;
       else 
    	   return searchMatrixaux(matrix, row,0,matrix[0].length -1,target);
        
    }
    
    public static int searchMatrixrow(int[][] matrix,int begin, int end, int target)
    {
    	int middle = (begin + end)/2;
    	
    	if(matrix[middle][0] <= target) 
    		if(middle == matrix.length - 1 || matrix[middle + 1][0] > target)
    			return middle;
    		else
    			return searchMatrixrow(matrix, middle + 1, end, target);
    	else
    		if(middle == 0 || matrix[middle - 1][0] <= target)
    			return middle -1;
    		else return searchMatrixrow(matrix, begin, middle - 1, target);
    		
    }
    
    public static boolean searchMatrixaux(int[][] matrix,int row,int begin,int end, int target)
    {
    	if(begin > end) return false;
    	int middle = (begin + end)/2;
    	
    	if (matrix[row][middle] == target)
    		return true;
   	
    	if(matrix[row][middle] < target)
    		return searchMatrixaux(matrix, row, middle+1,end, target);
    	else
    		return searchMatrixaux(matrix,row, begin, middle-1, target);
    }
	
	// For search insert position
   public static int searchInsert(int[] A, int target) {
	  
	   
	   return searchInsertaux(A, 0, A.length -1, target);
        
    }
   
   public static int searchInsertaux(int[] A, int begin, int end, int target)
   {
	   // warning: boundary condition!!!
	   
	   int middle = (begin + end)/2;
	   
	   if(A[middle] == target) return middle;
	   
	   if(A[middle] <target)
		    if(middle == A.length -1 || A[middle + 1] > target)
		    	return (middle + 1);
			else
				   return searchInsertaux(A, middle+1, end, target);
	   else
			if(middle ==0 || A[middle -1] < target)
				   return middle;
			else
				   return searchInsertaux(A, begin, middle -1,target);
	   

   }
	// For square root
	 public static int sqrt(int x) {

             return  sqrtaux(0, x,x);
	    }
	 
	 public static int sqrtaux(int begin, int end, int target){
		 		 
		 if (target == 0 || target == 1) return target;
		 int result = (begin + end) / 2;
		
		while(begin < end)
		{
			result = (begin + end) / 2;
		    double check_boundary = (double) result * (double) result;
		 
		    if(check_boundary > Integer.MAX_VALUE)
		    {
			    end = result;
			    continue;
		    }
		    
		    int check = result * result;
		    if(check == target)
		    {
		    	break;
		    }
		    
		    else if(check > target)
		    {
		    	if ((result -1) * (result -1) >= target)
		    	{
		    		end = result;
		    		continue;
		    	}
		    	else
		    	{
		    		result = result -1;
		    		break;
		    	}
		    }
		    else
		    {
		    	if((result +1) * (result +1) <= target)
		    	{
		    		begin = result + 1;
		    		continue;
		    	}
		    	else
		    	{
		    		break;
		    	}
		    }
		}
		return result;
	 }
	
	// For search in rotated array
    public static boolean search(int[] A, int target) {
        
    	return searchaux(A, target, 0, A.length - 1);
    }
    
    // For binary search in rotated array 2
    public static boolean searchaux(int[] A, int target, int begin, int end)
    {
    	if(begin > end) return false;
    	
    	int middle = (begin + end) /2;
    	
    	if(A[middle] == target) 
		{
	
		    return true;
		}
    	
        if(A[middle]>A[begin])
        {
            if(A[middle]>target && A[begin]<=target)
            {
               return searchaux(A, target, begin, middle - 1);
            }
            else
            {
            	return searchaux(A, target, middle + 1, end);
            }
        }
        else if(A[middle]<A[begin])
        {
            if(A[middle]<target && A[end]>=target)
            {
            	return searchaux(A, target, middle + 1, end);
            }
            else
            {
            	return searchaux(A, target, begin, middle - 1);
            }                
        }
        else
        {
        	return searchaux(A, target, begin + 1, end);
        }
    }
    
    public static int searchaux2(int[] A, int target, int begin, int end)
    {
    	//System.out.println(begin);
    	if(begin > end) return -1;
    	
    	int middle = (begin + end) /2;

    	//	System.out.println(middle);
    	if(A[middle] == target) 
    		{
    		//    System.out.println("hahah");
    		    return middle;
    		}
    	
    	if (A[end] > A[begin])
    		if(A[middle] > target)
    			return searchaux2(A, target, begin, middle - 1);
    		else
    			return searchaux2(A, target, middle + 1, end);
    	else if (A[begin] > A[end] && A[end] > A[middle])
    		if(A[middle] > target)
    			return searchaux2(A, target, begin, middle - 1);
    		else if (A[end] >= target)
    			return searchaux2(A, target, middle + 1, end);
    		else
    			return searchaux2(A, target, begin, middle - 1);
    	else 
    		if(A[middle] < target)
    			return searchaux2(A, target, middle + 1, end);
    		else if(A[begin] <= target)
    			return searchaux2(A, target, begin, middle - 1);
    		else
    			return searchaux2(A, target, middle + 1, end);
    	
//         if(A[middle] > target)
//         {
//        		 if(A[end] > A[begin])     			 
//        			 return searchaux(A, target, begin, middle - 1);
//
//        		 else
//        		 {
//        			 if (A[middle] < A[begin])
//        			   return searchaux(A, target, begin, middle - 1);
//        			 else if (A[begin] < target)
//        			   return searchaux(A,target,begin, middle - 1);
//        			 else 
//        			   return searchaux(A,target,middle + 1, end); 
//        		 }
//         }
//         else
//         {
//        	    if(A[end] > A[begin])
//        	    {
//        	    	return searchaux(A,target, middle + 1, end);
//        	    }
//        	    else
//        	    {
//       			    if (A[middle] > A[begin])
//      			       return searchaux(A, target, middle + 1, end);
//      			    else if(A[begin] > target)
//      			       return searchaux(A, target, middle + 1, end);
//      			    else
//      			    	return searchaux(A, target, begin, middle - 1);
//        	    }
//        	 
//        	 
//        	 
//         }
    	
    }
    
	
	// For finding median in sorted Arrays
    public static double findMedianSortedArrays(int A[], int B[]) {
       
       int total = A.length + B.length;
       if( total % 2 == 1)	
    	return findMedianaux(A, B,0, 0, A.length,B.length, total/2 + 1);
       else
    	 return (findMedianaux(A, B, 0,  0, A.length,B.length, total/2) + findMedianaux(A, B,0, 0, A.length,B.length, total/2 + 1)) / 2;
    }
	
    public static double findMedianaux(int A[], int B[], int A_begin, int B_begin, int m,int n,int k)
    {
       if(m > n)
    	   return findMedianaux(B,A, B_begin, A_begin,n,m, k);
       if (m == 0)
    	   return B[B_begin + k - 1];
       if (k == 1)
    	   return A[A_begin] > B[B_begin]? B[B_begin]:A[A_begin];
       
       int pa = k/2 > m ? m: k/2;
       int pb = k - pa;

       if (A[A_begin + pa - 1] < B[B_begin + pb - 1])
    	   return findMedianaux(A,B,A_begin + pa, B_begin, m - pa,n, k - pa);

       else if (A[A_begin + pa - 1] > B[B_begin + pb - 1])
    	   return findMedianaux(A,B,A_begin , B_begin + pb, m,n - pb, k - pb);
       else return A[A_begin + pa -1];
       
    	
    }
    // For search Range
    public static int[] searchRange(int[] A, int target) {
        
        int[] result = searchRangeaux(A,target,0,A.length - 1);

        return result;
    }
    
    public static int[] searchRangeaux(int[] A,int target,int begin,int end)
    {

    	  int[] result = new int[2];
    	  if(begin == end)
    	  {
    		  if(A[begin] == target)
    		  {
    		     result[0] = begin;
    		     result[1] = end;
    		     return result;
    		  }
    		  else
    		  {
    			  result[0] = -1;
    			  result[1] = -1;
    			  return result;
    		  }
    	  }
          int middle = (end - begin) / 2 + begin;
          if (A[middle] > target)
            	result = searchRangeaux(A,target,begin,middle);
          else if (A[middle] < target)
        	    result = searchRangeaux(A,target,middle + 1,end);
          else
          {
        	  int[] leftresult = searchRangeaux(A,target,begin,middle);
        	  int[] rightresult = {-1,-1};
        	  if(A[middle + 1] == target)
        	     rightresult = searchRangeaux(A,target,middle + 1,end);
        	  result[0] = leftresult[0];
        	  result[1] = leftresult[1];
        	  if(rightresult[1] != -1)
        	   result[1] = rightresult[1];
          }
          return result;
    }
	
	public static void main(String args[])
	{
//		int[] A = {5,5,5,5,5,5};
//		int[] result = searchRange(A,3);
//		
//		System.out.print(result[0] + " ");
//		System.out.print(result[1]);
		
		int[][] A = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		int[] B = {2,4,6};
		
		int[] C = {3,1,1};
		
		System.out.println(searchMatrix(A,2));
		
	}

}
