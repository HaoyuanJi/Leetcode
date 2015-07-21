
public class DivdeWIthoutDivide {

	public static int divide(int dividend, int divisor) throws Exception
	{
		if(divisor == 0) throw new ArithmeticException();
		long a = Math.abs(dividend);
		long b = Math.abs(divisor);
		
		int result = 0;
		while(a>=b)
		{
		    long t = b;
			for(int i = 1; t<=a; t = t << 1, i = i << 1)
			{
				result += i;
				a-=t;
			}
						
		}
		return ((dividend<0)^(divisor<0))? -result:result;
	}
	
	
	public static void main(String args[]) throws Exception
	{
		System.out.println(divide(3,0));
	}
}
