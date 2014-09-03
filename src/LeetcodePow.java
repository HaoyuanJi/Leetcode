
public class LeetcodePow {
	
	// Time complexity is very very very important. Must be this.
    public static double pow(double x, int n) {
        
        if(x == 0) return 0;
        if(x == 1 || n == 0) return 1;  
        if(n == 1) return x;
        
       
        double result;
        if(n < 0)
        	result = 1/ powaux(x,-n);
        else
        	result = powaux(x,n);

        return result;      
    }
    
    public static double powaux(double x,int n)
    {
    	if (n == 0) return 1;
    	
        double result;
        double v = powaux(x, n/2);
    	if (n %2 == 0)
    		result = v * v;
    	else
    		result = v * v * x;         
    	return result;
    }
    
    public static void main(String args[])
    {
    	double result = pow(0.00001, 2147483647);
    	System.out.println(result);
    }
}
