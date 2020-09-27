package Serialization;

import java.io.*;

public class SerializeOrder {
    public static void main(String[] args) {

        String output = "/Users/pinkuan/IdeaProjects/java-exercise/src/main/java/Serialization/Order.ser";

        serialization(output);

        System.out.println("\n--------------------------------\n");

        deSerialization(output);
    }

    private static void serialization(String output) {
        Shirt s1 = new Shirt("Brand1", 100, 100);
        Shirt s2 = new Shirt("Brand2", 100, 200);
        Shirt s3 = new Shirt("Brand3", 100, 300);
        Order o = new Order(s1, s2, s3);

        Order.staticField = 22;
        try (FileOutputStream fos = new FileOutputStream(output);
             ObjectOutputStream out = new ObjectOutputStream(fos)) {
            out.writeObject(o);
        } catch (IOException i) {
            i.printStackTrace();
        }
        System.out.println("=== Before Serialized, " + o);
    }

    private static void deSerialization(String output) {
        try (FileInputStream fis = new FileInputStream(output);
             ObjectInputStream in = new ObjectInputStream(fis)) {
            Order restoreOrder = (Order) in.readObject();
            System.out.println("=== After Serialized, " + restoreOrder);
        } catch (ClassNotFoundException | IOException i) {
            i.printStackTrace();
        }
    }
}
