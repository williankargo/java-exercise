package Compare;


import java.util.*;
import java.lang.Comparable;

/**
 * "Comparator"和“Comparable”的比較程式。 (01) "Comparable" 它是一個排序介面，只包含一個函式compareTo()。
 * 一個類實現了Comparable介面，就意味著“該類本身支援排序”，它可以直接通過Arrays.sort() 或 Collections.sort()進行排序。
 * <p>
 * (02) "Comparator" 它是一個比較器介面，包括兩個函式：compare() 和 equals()。 一個類實現了Comparator介面，那麼它就是一個“比較器”。其它的類，可以根據該比較器去排序。
 * <p>
 * 綜上所述：Comparable是內部比較器，而Comparator是外部比較器。 一個類本身實現了Comparable比較器，就意味著它本身支援排序；若它本身沒實現Comparable，也可以通過外部比較器Comparator進行排序。
 */
public class CompareComparatorAndComparableTest {

    public static void main(String[] args) {
// 新建ArrayList(動態陣列)
        ArrayList<Person> list = new ArrayList<>();

// 新增物件到ArrayList中
        list.add(new Person("ccc", 20));
        list.add(new Person("AAA", 30));
        list.add(new Person("bbb", 10));
        list.add(new Person("ddd", 40));

// 列印list的原始序列
        System.out.printf("Original sort, list:%s\n", list);
        System.out.println();//換行

// 對list進行排序
// 這裡會根據“Person實現的Comparable<String>介面”進行排序，即會根據“name”進行排序
        Collections.sort(list);  //一個類實現Comparable介面，意味著該類本身支援排序，可以用Arrays.sort/Collections.sort
        System.out.printf("Name sort, list:%s\n", list);
        System.out.println();//換行

// 通過“比較器(AscAgeComparator)”，對list進行排序
// AscAgeComparator的排序方式是：根據“age”的升序排序
        Collections.sort(list, new AscAgeComparator()); //使用比較器
        System.out.printf("Asc(age) sort, list:%s\n", list);
        System.out.println();//換行

// 通過“比較器(DescAgeComparator)”，對list進行排序
// DescAgeComparator的排序方式是：根據“age”的降序排序
        Collections.sort(list, new DescAgeComparator());
        System.out.printf("Desc(age) sort, list:%s\n", list);
        System.out.println();//換行

//name的排序
        Collections.sort(list, new NameSorter());
        System.out.printf("Name sort, list:%s\n", list);
        System.out.println();

// 判斷兩個person是否相等
        testEquals();
    }

    /**
     * @desc 測試兩個Person比較是否相等。 由於Person實現了equals()函式：若兩person的age、name都相等，則認為這兩個person相等。
     * 所以，這裡的p1和p2相等。
     * <p>
     * TODO：若去掉Person中的equals()函式，則p1不等於p2
     */
    private static void testEquals() {
        Person p1 = new Person("eee", 100);
        Person p2 = new Person("eee", 100);
        if (p1.equals(p2)) {
            System.out.printf("%s EQUAL %s\n", p1, p2);
        } else {
            System.out.printf("%s NOT EQUAL %s\n", p1, p2);
        }
    }

    /**
     * @desc Person類。 Person實現了Comparable介面，這意味著Person本身支援排序
     */
    private static class Person implements Comparable<Person> {

        int age;
        String name;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        /**
         * @desc 比較完後印出來，必須存在。
         */
        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }

        /**
         * @desc 實現 “Comparable<String>” 的介面，即重寫compareTo<T t>函式。 這裡是通過“person的名字”進行比較的
         */
        @Override
        public int compareTo(Person person) {
            return name.compareTo(person.name); //用String的compareTo
            //return this.name - person.name;  //string不能用減的
            //return this.age -person.age;     //或是比較age
        }

        /**
         * 比較兩個Person是否相等：若它們的name和age都相等，則認為它們相等
         */
        boolean equals(Person person) {
            if (this.age == person.age && this.name == person.name) {
                return true;
            }
            return false;
        }
    }


    /**
     * @desc AscAgeComparator比較器 它是“Person的age的升序比較器”
     */
    private static class AscAgeComparator implements Comparator<Person> {

        @Override
        public int compare(Person p1, Person p2) {
            return p1.getAge() - p2.getAge();
            //return p2.age.compareTo(p1.age);  int不能用compare的
        }
    }

    /**
     * @desc DescAgeComparator比較器 它是“Person的age的降序比較器”
     */
    private static class DescAgeComparator implements Comparator<Person> {

        @Override
        public int compare(Person p1, Person p2) {
            return p2.getAge() - p1.getAge();
        }
    }

    private static class NameSorter implements Comparator<Person> {

        @Override
        public int compare(Person p1, Person p2) {
            return p1.name.compareTo(p2.name);
        }
    }
}
