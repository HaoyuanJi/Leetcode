
public class Leetcode3 {
	
	private static final int VERTICAL = 3;
	private static final int NORMAL = 2;
	private static final int SAME = 1;
	
	class Point {
		      int x;
		      int y;
		      Point() { x = 0; y = 0; }
		      Point(int a, int b) { x = a; y = b; }
		  }
	
	static class Pointrelationship
	{
		double slope;
		int status;
		Pointrelationship() {slope = 0.0; status = NORMAL;}
	    Pointrelationship(double slope, int status) 
	   { this.slope = slope; this.status = status; }
	}
	
    public void merge(Pointrelationship[] input,int start, int split, int end)
    {
    	Pointrelationship[] copy = new Pointrelationship[end - start + 1];
    	int i = start;
    	int j = split+1;
    	int k = 0;
        while(i <= split && j<= end)
        {

        	if(input[i].slope == input[j].slope)
        	{
        		if (input[i].status == input[j].status)
        		{
        		  copy[k] = input[i];
        		  k++;
        		  copy[k] = input[j];
        		  k++;
        		  i++;
        		  j++;
        		}
        		else if (input[i].status < input[j].status)
        		{
        			copy[k] = input[i];
            		i++;
            		k++;       			
        		}
        		else
        		{
        			copy[k] = input[j];
            		j++;
            		k++;
        		}
        	}
        	else if (input[i].slope < input[j].slope)
        	{
        		copy[k] = input[i];
        		i++;
        		k++;
        	}
        	else if (input[i].slope > input[j].slope)
        	{
        		copy[k] = input[j];
        		j++;
        		k++;
        	}       	
        	
        }
        
        while (i<= split)
        {
        	copy[k] = input[i];
        	i++;
        	k++;
        }
        
        while (j<=end)
        {
        	copy[k] = input[j];
        	j++;
        	k++;
        }
        
        for(i = 0; i<copy.length;i++)
        {
        	input[start+i] = copy[i];
        }
    	
    	
    }
    
    
	public void mergesort(Pointrelationship[] input, int start, int end)
	{
      if(start < end)
      {
       int split = (end + start)/2;
       mergesort(input, start,split);
       mergesort(input, split+1, end);
       merge (input,start, split, end);            
      }
		
	}
	
	public int findmaxpoint(Pointrelationship[] target)
	{
		int maxpoints = 0;
		int countsame = -1;
		int countp = 0;
		Pointrelationship currentstate = target[0];
		Pointrelationship previousstate = currentstate;
        for (int i = 0 ; i< target.length;i++)
        {
        	if (target[i].status == SAME)
        	{
                  countsame++;
        	}
        	
        	else if (target[i].status == VERTICAL)
        	{
        		currentstate = target[i];
        		if (previousstate.status != currentstate.status)
        		{
        			countp = 0;
        		}
        		countp++;
        		if (countp > maxpoints)
        		{
        			maxpoints = countp;
        		}
        		previousstate = currentstate;
        	}
        	
        	else
        	{
        	currentstate = target[i];
    		if (previousstate.status != currentstate.status || previousstate.slope != currentstate.slope)
    		{
    			countp = 0;
    		}
    		countp++;
    		if (countp > maxpoints)
    		{
    			maxpoints = countp;
    		}
    		previousstate = currentstate;

        	}
        }

		return maxpoints + countsame +1;
	}
    public int maxPoints(Point[] points) {
    	int size = points.length;
    	Pointrelationship[][] prl = new Pointrelationship[size][size];
    	int maxpoint = 0;
    	
    	for (int i = 0; i<size; i++)
    	{
    		for (int j = 0; j< size;j++)
    		{
    			if (points[i].x == points[j].x && points[i].y == points[j].y)
    			{
    				prl [i][j] = new Pointrelationship(0.0, SAME);
    			}
    			else if (points[i].x == points[j].x)
    			{
    				prl [i][j] = new Pointrelationship(0.0, VERTICAL);
    			}
    			else 
    			{
    				double slope = (double)(points[j].y-points[i].y)/(double)(points[j].x-points[i].x);
    				prl [i][j] = new Pointrelationship(slope, NORMAL);
    				
    			} 			
    		}  
    		mergesort(prl[i],0,prl[i].length-1);
    	    int check = findmaxpoint(prl[i]);
            if (check > maxpoint) maxpoint = check;
    	  		  
    
    		
    		
    	}

        
        return maxpoint;
    }
    
    public static void main(String args[])
    {
    	Leetcode3.Point p1 = new Leetcode3().new Point(0,0);
//    	Leetcode3.Point p2 = new Leetcode3().new Point(4,1);
//    	Leetcode3.Point p3 = new Leetcode3().new Point(4,-1);
//    	Leetcode3.Point p4 = new Leetcode3().new Point(4,2);
//    	Leetcode3.Point p5 = new Leetcode3().new Point(4,3);
//    	Leetcode3.Point p6 = new Leetcode3().new Point(4,5);
//    	Leetcode3.Point p7 = new Leetcode3().new Point(4,6);
    	
    	Point[] points = {p1};
    	
    	
    	
    	int number = new Leetcode3().maxPoints(points);  
    	System.out.println(number);
    }
}
