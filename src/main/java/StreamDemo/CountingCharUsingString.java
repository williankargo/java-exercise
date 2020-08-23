package StreamDemo;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountingCharUsingString {

    private static int count = 0;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = input.nextLine();

        System.out.println("The occurrences of each letter are: ");

        Stream.of(toCharacterArray(s.toCharArray())).filter(e -> Character.isLetter(e))
                .map(e -> Character.toUpperCase(e))
                .collect(Collectors.groupingBy(e -> e, TreeMap::new, Collectors.counting()))
                .forEach((k, v) -> {
                    System.out.print(k + ":" + v + " ");
                });
    }

    //因為stream的of只接受原始類型，所以要進行轉換
    public static Character[] toCharacterArray(char[] list) {
        Character[] result = new Character[list.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = list[i];
        }
        return result;
    }


}
