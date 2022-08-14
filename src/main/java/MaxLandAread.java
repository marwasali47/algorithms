import java.util.List;

public class MaxLandAread {



    public static void main(String[] args) {
        int[][]  grid = new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0}
        ,{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0}
        ,{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0}
        ,{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int [][] visited = new int[grid.length][grid[0].length];

        int area = 0 ;
        for(int i = 0 ; i < grid.length ; i++)
            for(int j = 0 ; j < grid[i].length ; j++)
            {
                if(grid[i][j] == 1)
                    area = Math.max (area ,DFSMaxLandArea(grid , i , j , visited));

            }
        System.out.println("area = " +  area);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {

        return image;
    }

    public static int DFSMaxLandArea(int[][] grid , int i , int j , int[][] visited) {

        if (i < 0 || i >= grid.length  // rows
                || j <0 || j >= grid[0].length //columns
                || grid[i][j] == 0
                || visited[i][j] == 1
           )
            return 0;

        visited[i][j] = 1 ;
        return 1 + DFSMaxLandArea(grid , i+ 1 ,j, visited)
                                  +  DFSMaxLandArea(grid , i- 1 ,j, visited)
                                   +  DFSMaxLandArea(grid , i  ,j + 1, visited)
                                     +  DFSMaxLandArea(grid , i  ,j - 1, visited);


    }
}






