package Serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Shirt implements Serializable {
    private static final long serialVersionUID = 1L;
    private String brand;
    private int quantity;
    private double cost;
    private transient double price;

    public Shirt(String brand, int quantity, double cost) {
        this.brand = brand;
        this.quantity = quantity;
        this.cost = cost;
        this.price = 2 * cost;
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        this.price = this.cost + 50;  //price不能被序列化，因此如果沒有這個步驟，price會以int = 0印出
    }

    public String toString() {
        return "Shirt: " + this.brand + "\n"
                + "Quantity: " + this.quantity + "\n"
                + "Cost: " + this.cost + "\n"
                + "Price: " + this.price + "\n"
                + "---------\n";
    }
}
