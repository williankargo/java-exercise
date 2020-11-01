package Optional;

// Why Optional?
// (1) 為值的容器，不是有值就是沒值
// (2) 目的是作為null的替代方案，因為null太語意含糊不清
// (3) 有速錯的功能，可以讓開發者立即發現錯誤 ex: optional.orElse()...
// http://blog.tonycube.com/2015/10/java-java8-4-optional.html

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

public class demo {
}

class User {
    public int id;
    public String name;

    User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //==== 不使用 Optional ====
    private List<User> getUsers() {
        //假裝從資料庫取值
        List<User> users = asList(new User(1, "Tony"),
                new User(2, "John"),
                new User(3, "Emma"));
        return users;//有可能 null
    }

    private User findUserByName(String name) {
        List<User> users = getUsers();
        if (users != null) {//很好，有檢查 null
            for (User u : users) {
                if (u.name.equals(name)) {
                    return u;
                }
            }
        }
        return null;//可能找不到而返回 null
    }

    private void optionalDemo() {
        User user = findUserByName("Amy");
        if (user != null) {//很好，有檢查 null
            System.out.println(user.name + " id is " + user.id);
        } else {
            System.out.println("User not found.");
        }
    }

    //==== 使用 Optional ====
    private Optional<List<User>> getUsers2() {
        //假裝從資料庫取值
        List<User> users = asList(new User(1, "Tony"),
                new User(2, "John"),
                new User(3, "Emma"));
        return Optional.ofNullable(users);  // ofNullable() 可放可能為null的東西
    }

    private Optional<User> findUserByName2(String name) {
        Optional<List<User>> users = getUsers2();
        //對要使用的資料檢查，參數也要
        if (users.isPresent() &&
                Optional.ofNullable(name).isPresent()) {
            //使用 stream 取代 foreach 迴圈
            //findFirst()回傳的是 Optional
            return users.get().stream().filter(u -> u.name.equals(name)).findFirst();
        }
        return Optional.empty();
    }

    private void optionalDemo2() {
        Optional<User> user = findUserByName2("Amy");
        //使用 isPresent() 有點冗長
        if (user.isPresent()) {
            System.out.println(user.get().name + " id is " + user.get().id);
        } else {
            System.out.println("User not found.");
        }

        //改用 ifPresent 只要一行，但是無值時不做任何回應
        user.ifPresent(u -> System.out.println(u.name + " id is " + u.id));
    }
}