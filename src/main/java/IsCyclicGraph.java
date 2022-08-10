import java.util.ArrayList;
import java.util.HashMap;

public class IsCyclicGraph {

    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{1,2},{2,0},{2,3},{3,3}};
        //int[][] edges = {{4,3},{1,4},{4,8},{1,7},{6,4},{4,2},{7,4},{4,0},{0,9},{5,4}};n=10
        System.out.println(isCyclic(4, getIntegerArrayListHashMap(10,edges)));
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
           // map.get(edges[i][1]).add(edges[i][0]);
        }
        return map;
    }

    private static boolean isCyclic(int n , HashMap<Integer, ArrayList<Integer>> map )
    {

        // Mark all the vertices as not visited and  not part of recursion stack
        boolean[] visited = new boolean[n];
        boolean[] recStack = new boolean[n];


        // Call the recursive helper function to
        // detect cycle in different DFS trees
        for (int i = 0; i < n; i++)
            if (isCyclicUtil(i, visited, recStack ,map))
                return true;

        return false;
    }

    private static boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack , HashMap<Integer, ArrayList<Integer>> map)
    {

        // Mark the current node as visited and part of recursion stack
        if (recStack[i])
            return true;

        if (visited[i])
            return false;

        visited[i] = true;
        recStack[i] = true;

        for (Integer c: map.get(i))
            if (isCyclicUtil(c, visited, recStack,map))
                return true;

        recStack[i] = false;
        return false;
    }
}
