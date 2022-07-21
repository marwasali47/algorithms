import java.util.*;
import java.util.stream.Collectors;

public class MusalaLists {

    public static void main(String[] args) {

        List<List<String>> items = new ArrayList<>();
        int sortParameter= 0 ; int sortOrder= 0 ;int X = 2 ;

        HashMap<Integer,String> map = new HashMap<>();

        for ( int i = 0 ; i < items.size() ; i++){
            map.put(i,items.get(i).get(sortParameter));
        }

        LinkedHashMap<Integer, String> sortedMap = new LinkedHashMap<>();

        if(sortOrder == 0)
            map.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue())
                    .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
        else
            map.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        List<String> list = sortedMap.keySet()
                .stream()
                .map(index -> items.get(index).get(0))
                .collect(Collectors.toList());
        String s = "" ;

        System.out.println(list);
    }
}
