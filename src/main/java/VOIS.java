import java.util.ArrayList;
import java.util.List;

public class VOIS {

    public static void main(String[] args) {

        String s = "abbabbaaa";
        char[] arr = s.toCharArray();
        List<String> list = new ArrayList<>();
        StringBuilder x = new StringBuilder();
        x.append(arr[0]);
        for(int i =1 ; i < arr.length ; i++){
            System.out.println(arr[i]);
           if (arr[i] == arr [i-1]) {
               x.append(arr[i]);
           }
           else {
               list.add(x.toString());
               x = new StringBuilder();
               x.append(arr[i]);
           }
        }
        list.add(x.toString());
        int max = list.get(0).length();
        for(int i = 1 ; i < list.size() ; i++) {
            if(list.get(i).length() > max) max = list.get(i).length() ;
        }

        int num = 0 ;
        for(int i = 0 ; i < list.size() ; i++) {
            num = num  +  (max - list.get(i).length());
        }

        System.out.println(list);
    }
}
