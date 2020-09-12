package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class Employee {
    String name;
    Integer age;

    public Employee(String n, Integer a) {
        name = n;
        age = a;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}

public class TestDemo {
    public static void testAge(List<Employee> list, Predicate<Employee> predicate) {
        for (Employee p : list) {
            if (predicate.test(p)) {
                System.out.println(p.name + " ");
            }
        }
    }

    public static void main(String[] args) {
        List<Employee> iList = Arrays.asList(new Employee("Duke", 45),
                new Employee("Jim", 40),
                new Employee("Jay", 38));
        testAge(iList, (Employee p) -> p.getAge() > 40);
        testAge(iList, p -> p.getAge() > 40);
    }
}
