package Serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<Shirt> shirts = new ArrayList<>();
    static int staticField = 100;  //反序列化後印出本來的宣告值
    transient int transientField = 100; //反序列化後印出該型態的預設值

    public Order(Shirt... shirts) {
        for (Shirt s : shirts) {
            this.shirts.add(s);
        }
        staticField = 99;
        transientField = 99;
        System.out.println("--- Constructor is launched---");
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        Date now = new Date();
        oos.writeObject(now);
        System.out.println("\nSerialized at: " + now + "\n");
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        System.out.println("\nRestored from date: " + (Date) ois.readObject());
        System.out.println("Restored at: " + new Date() + "\n");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Order Summary === \n");
        for (Shirt s : shirts) {
            sb.append(s);
        }
        sb.append("staticField = " + staticField);
        sb.append("\ntransientField = " + transientField);
        sb.append("\n--------------------------------");
        return sb.toString();
    }
}

//為什麼可以用private readObject?
// ans: https://stackoverflow.com/questions/11238593/how-private-writeobject-method-of-serializable-object-called-by-object-of-object