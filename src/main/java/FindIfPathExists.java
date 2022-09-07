import java.util.ArrayList;
import java.util.HashMap;

public class FindIfPathExists {

    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{2,0}};
        int source = 0 ;
        int destination = 2;
        System.out.println(pathExists(3 ,edges,source ,destination ));
    }

    public static boolean pathExists(int n, int[][] edges, int source, int destination) {

        if(edges.length == 0 ) return true;

        HashMap<Integer, ArrayList<Integer>> map = getIntegerArrayListHashMap(n, edges);

        boolean visited[] = new boolean[n];

        return checkPathFromSourceToDestination(visited ,map , source ,map.get(source),destination);
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

    private static boolean checkPathFromSourceToDestination(boolean[] visited,
                                                            HashMap<Integer, ArrayList<Integer>> map,
                                                            int source, ArrayList<Integer> nodes,
                                                            int destination) {

        if(nodes.contains(destination)) return true;

        visited[source] = true ;

        for(int i =0  ; i < nodes.size() ; i++){

            if(visited[nodes.get(i)] ==true )
                continue;

            if(checkPathFromSourceToDestination(visited, map , nodes.get(i), map.get(nodes.get(i)) ,destination))
                return true;
        }

        return false;

    }


}
