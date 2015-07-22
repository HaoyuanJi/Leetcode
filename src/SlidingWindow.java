import java.util.*;

public class SlidingWindow {
	
	public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = {};
        if(nums.length == 0) return result;
        result = new int[nums.length - k + 1];
        List<Integer> working_list = IntStream.of(nums).map(Integer::valueOf).boxed().collect(Collectors.toList());
        int max;
        for (int i = 0; i < nums.length - k + 1; i++)
        {
            List<Integer> window = working_list.subList(i,i+k);
            max = Collections.max(window);
            result[i] = max;
        }
        return result;
    }
	
	public static void main(String[] args)
	{
		int[] nums = {1,2,3};
		int[] result = SlidingWindow.maxSlidingWindow(nums, 2);
		System.out.println(result.length);
		for(int i = 0; i < result.length; i++)
		{
			System.out.println(result[i]);
		}
	}

}
