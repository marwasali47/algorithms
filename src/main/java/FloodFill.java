public class FloodFill {



    public static void main(String[] args) {
        int[][]  image = new int[][]{{1,1,1} ,{1,1,0} , {1,0,1}};

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("****************************************************");

        int [][] visited = new int[image.length][image[0].length];
        DFSFloodFill(image , 1,1,2 , image[1][1] ,visited);


        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void DFSFloodFill(int[][] image , int i , int j , int color , int cellColor ,int[][] visited) {

        if (i < 0 || i >= image.length  // rows
                || j <0 || j >= image[0].length //columns
                || image[i][j] != cellColor
                || visited[i][j] == 1)
            return ;

        visited[i][j] = 1 ;
        image[i][j] = color;
        DFSFloodFill(image , i+ 1 ,j, color,cellColor ,visited) ;
        DFSFloodFill(image , i- 1 ,j, color,cellColor ,visited) ;
        DFSFloodFill(image , i  ,j + 1, color,cellColor ,visited);
        DFSFloodFill(image , i  ,j - 1, color,cellColor ,visited);


    }
}






