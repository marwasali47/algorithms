import java.util.*;

public class PureStorage {

    public static void main(String[] args) {
        System.out.println("hello workd");
        List<List<Integer>> x = new ArrayList<>();
        List<Integer> x1 = new ArrayList<>();
        x1.add(0,2001);
        x1.add(1,1001);
        x1.add(2,2);

        List<Integer> x2 = new ArrayList<>();
        x2.add(0,2001);
        x2.add(1,1002);
        x2.add(2,3);

        x.add(0 , x1);
        x.add(1 , x2);
        print_classification(x);
    }

    public static void print_classification(List<List<Integer>> raw_data) {

        int[] points = {10 , 6 , 4 , 3 , 2, 1 } ;

        Map<Integer,Integer> map = new HashMap<>();

        for(int i =0 ; i < raw_data.size(); i++){
            Integer race = raw_data.get(i).get(0);
            Integer racer = raw_data.get(i).get(1);
            Integer position = raw_data.get(i).get(2);
            int racerPoints = 0;
            if(position < 6)
                racerPoints = points[position];
            if(!map.containsKey(racer)){
                map.put(racer, racerPoints );
            }else {
                racerPoints = map.get(racer) + racerPoints ;
                map.put(racer, racerPoints);
            }
        }

        Map.Entry<Integer, Integer> maxEntry = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue()
                    .compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        System.out.println(maxEntry.getKey()+ "  " + maxEntry.getValue());
    }


    public static int count_invalid_boxes(List<List<String>> box_template_list) {

        int count = 0;
        for(int i =0 ; i < box_template_list.size() ; i++){
            String str1= box_template_list.get(i).get(0);
            String str2= box_template_list.get(i).get(1);
            char[] char1 = str1.toCharArray();
            char[] char2 = str2.toCharArray();
            Arrays.sort(char1);
            Arrays.sort(char2);
            if(!Arrays.equals(char1, char2)) count++;

        }





        return count;
    }
}
