package dataStructure.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TreeMapExample2 {

    public static void main(String[] args) {
        String text = "I love java programming and I want to marry to Java !";
        //<內放類型:key,value>
        Map<String, Integer> map = new HashMap<>();

        String words[] = text.split(" ");

        for (int i = 0; i < words.length; i++) {
            String key = words[i].toLowerCase();

            if (key.length() > 0) {
                if (!map.containsKey(key)) {  //! 為非的意思
                    map.put(key, 1);
                } else {
                    int value = map.get(key);
                    value += 1;
                    map.put(key, value);

                }
            }
        }
        System.out.println(map);

    }
}

class Sorter3 implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}
