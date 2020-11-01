package DesignPattern;

// Why Builder Pattern?
// 1. 保持類別屬性的不可變性（為final）
// 2. 保持建構時的彈性與可讀性
// https://matthung0807.blogspot.com/2019/09/design-pattern-builder-pattern.html

class Customer {

    private final String id;    // 必要
    private final String name;  // 必要

    private final String email; // 選填
    private final String phone; // 選填
    private final Integer age;  // 選填

    public Customer(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.email = builder.email;
        this.phone = builder.phone;
        this.age = builder.age;
    }

    public static Builder getBuilder(String id, String name) {
        return new Builder(id, name);
    }

    // getters...

    public static final class Builder {
        private String id;
        private String name;

        private String email;
        private String phone;
        private Integer age;

        public Builder(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setAge(Integer age) {
            this.age = age;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }  //回去Customer()

    }

    public String toString() {
        return this.getClass().getSimpleName() + ":{ "
                + "id:" + id + ", "
                + "name:" + name + ", "
                + "email:" + email + ", "
                + "phone:" + phone + ", "
                + "age:" + age
                + " }";
    }

}

public class BuilderPattern {
    public static void main(String[] args) {

        Customer customer1 = Customer.getBuilder("A0001", "Amber Wang").build();

        Customer customer2 = Customer.getBuilder("A0002", "May li")
                .setEmail("may-li@abc.com").build();

        Customer customer3 = Customer.getBuilder("A0003", "Ken Liu")
                .setEmail("ken-liu@abc.com")
                .setPhone("0917006740")
                .build();

        Customer customer4 = Customer.getBuilder("A0004", "Ray Chen")
                .setEmail("ray-chen@abc.com")
                .setPhone("0917006740")
                .setAge(22)
                .build();

        Customer customer5 = Customer.getBuilder("A0005", "Dan Hu")
                .setAge(33)
                .build();

        System.out.println(customer1);
        System.out.println(customer2);
        System.out.println(customer3);
        System.out.println(customer4);
        System.out.println(customer5);
    }
}