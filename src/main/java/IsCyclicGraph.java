import java.util.ArrayList;
import java.util.HashMap;

public class IsCyclicGraph {

    private boolean isCyclic()
    {

        int n = 10;
        // Mark all the vertices as not visited and  not part of recursion stack
        boolean[] visited = new boolean[n];
        boolean[] recStack = new boolean[n];

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        // Call the recursive helper function to
        // detect cycle in different DFS trees
        for (int i = 0; i < n; i++)
            if (isCyclicUtil(i, visited, recStack ,map))
                return true;

        return false;
    }

    private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack , HashMap<Integer, ArrayList<Integer>> map)
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
