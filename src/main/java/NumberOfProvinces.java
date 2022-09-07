import java.util.ArrayList;
import java.util.HashMap;

public class NumberOfProvinces {

    public static void main(String[] args) {
        int[][] edges = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(edges));
    }

    public static int  findCircleNum(int[][] edges) {

        if (edges.length == 0) return 0;

        HashMap<Integer, ArrayList<Integer>> map = getIntegerArrayListHashMap(edges.length, edges);

        int[][] visited = new int[edges.length][edges[0].length];
        for (int i = 0; i < edges.length; i++)
            for (int j = 0; j < edges[i].length; j++) {

            }

        return findCircleNumForCity( visited ,edges );
    }

    private static HashMap<Integer, ArrayList<Integer>> getIntegerArrayListHashMap(int n, int[][] edges) {
        //create the map
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i ++){
            map.put(i, new ArrayList<>());
        }
        //fill the map
        for(int i = 0; i < edges.length ; i ++){
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        return map;
    }

    private static int findCircleNumForCity(int[][] visited, int[][] edges) {

/*
        if (i < 0 || i >= image.length  // rows
                || j <0 || j >= image[0].length //columns
                || image[i][j] != cellColor
                || visited[i][j] == 1)
            return ;*/


        return 1;

    }
}
