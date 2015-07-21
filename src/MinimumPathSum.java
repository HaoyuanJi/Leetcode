
public class MinimumPathSum {
	
	public static int[][] minsum;
	
	public static int minPathSumaux(int[][] minsum, int[][] grid, int row, int column)
	{
		if(minsum[row][column] != -1) return minsum[row][column];
		
		if(row == 0 && column > 0)
		{
			int result = grid[row][column] + minPathSumaux(minsum,grid,row, column - 1);
			minsum[row][column] = result;
			return result;
		}
		if(column == 0 && row > 0)
		{
			int result = grid[row][column] + minPathSumaux(minsum,grid,row - 1, column);
			minsum[row][column] = result;
			return result;
		}
		else
		{
			int result = minPathSumaux(minsum,grid,row - 1, column) > minPathSumaux(minsum,grid,row, column - 1) ? grid[row][column] + minPathSumaux(minsum, grid,row, column - 1): grid[row][column] + minPathSumaux(minsum, grid,row - 1, column);
			minsum[row][column] = result;
		    return result;
		}
	}
	
    public static int minPathSum(int[][] grid) {
    	
    	if(grid.length == 0) return 0;
    	
    	int row = grid.length;
    	int column = grid[0].length;
    	
    	minsum = new int[row][column];
    	for(int i = 0; i< row; i++)
    		for(int j = 0; j < column; j++)
    			minsum[i][j] = -1;
        
    	minsum[0][0] = grid[0][0];
    	int result = minPathSumaux(minsum, grid, row - 1,column - 1);
    	minsum[row - 1][column - 1] = result;
    	
    	return result;
    }
	
	public static void main(String args[])
	{
		int[][] grid = {{3,5,8,2},{4,6,3,2},{5,4,3,3}};

		System.out.println(minPathSum(grid));
	}

}
