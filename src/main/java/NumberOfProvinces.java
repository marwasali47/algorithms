import java.util.ArrayList;
import java.util.HashMap;

public class NumberOfProvinces {

    public static void main(String[] args) {
        int[][] edges = {{4,3},{1,4},{4,8},{1,7},{6,4},{4,2},{7,4},{4,0},{0,9},{5,4}};
        int source = 5 ;
        int destination = 9;
        System.out.println(validPath(10 ,edges,source ,destination ));

       /* int[][] edges = {{0,7},{0,8},{6,1},{2,0},{0,4},{5,8},{4,7},{1,3},{3,5},{6,5}};
        int source = 7 ;
        int destination = 5;
        System.out.println(validPath(10 ,edges,source ,destination ));*/
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {

        //create the map
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < n ; i ++){
            map.put(i, new ArrayList<>());
        }

        //fill the map
        for(int i =0 ; i < edges.length ; i ++){
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }

        boolean visited[] = new boolean[n];

        return checkPathFromSourceToDestination(visited ,map , source ,map.get(source),destination);
    }

    private static boolean checkPathFromSourceToDestination(boolean[] visited,
                                                            HashMap<Integer, ArrayList<Integer>> map,
                                                            int source, ArrayList<Integer> nodes,
                                                            int destination) {

        if(nodes.contains(destination)) return true;

        visited[source] = true ;

        for(int i =0  ; i < nodes.size() ; i++){
            if(visited[nodes.get(i)] ==true ) continue;
            if(checkPathFromSourceToDestination(visited, map , nodes.get(i), map.get(nodes.get(i)) ,destination))
                    return true;
        }

        return false;

    }


}
