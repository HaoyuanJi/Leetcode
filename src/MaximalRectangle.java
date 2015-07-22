import java.util.*;

public class MaximalRectangle {
	public static int largestRectangleArea(int[] height) {
		
		Stack<Integer> index_store = new Stack<Integer>();
		int[] new_h = Arrays.copyOf(height, height.length+1);
		int maxArea = 0;
		int i = 0;
		while(i < new_h.length)
		{
			if(index_store.isEmpty() || new_h[index_store.peek()] <= new_h[i])
			{
				index_store.push(i);
				i++;
			}
			else
			{
				int t = index_store.pop();
				maxArea = Math.max(maxArea,new_h[t] * (index_store.isEmpty()? i : i - 1 - index_store.peek()));
			}
		}
        
        return maxArea;
    }
	
	public static void main(String args[])
	{
		int[] height = {2,1,5,6,2,3};
		System.out.println(MaximalRectangle.largestRectangleArea(height));
	}

}
