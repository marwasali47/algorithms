import java.util.*;

public class courseSchedule {

    public static void main(String[] args) {
       // int[][] courses =  {{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}};
        int[][] courses = new int[][]{{1,0}};
        System.out.println( "canFinish : " + canFinish(2 ,courses ).toString());
    }


    private static boolean canFinishDFS(HashMap<Integer,ArrayList<Integer>> map
            , int[] visit
            , int [] order
            , int i
            , int[] seq ){

        if(visit[i]==-1)
            return false;

        if(visit[i]==1)
            return true;

        visit[i]=-1;
        if(map.containsKey(i)){
            for(int j: map.get(i)){
                if(!canFinishDFS(map, visit, order , j ,seq))
                    return false;
            }
        }
        //keda el node tamam no cycles for this course
        visit[i]=1;
        order[seq[0]--] = i ;
        return true;
    }

    public  static int[] canFinish(int numCourses, int[][] prerequisites) {
        
        //create the map
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < numCourses ; i ++){
            map.put(i, new ArrayList<>());
        }

        //fill the map
        for(int i =0 ; i < prerequisites.length ; i ++){
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        //track visited courses , -1 = vistites , 1 ok , 0 not vistied
        int[] visit = new int[numCourses];
        int[] order = new int[numCourses];
        int[]  seq  = new int[]{numCourses - 1};
        for(int i=0; i<numCourses; i++){
            if(!canFinishDFS(map, visit, order , i ,seq))
                return new int[]{};
        }
        return order;
    }


}
