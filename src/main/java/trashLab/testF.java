package trashLab;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class testF {
    public static void main(String[] args){
        SerializeCustomer();// 序列化 Customer 物件
        Customer customer = DeserializeCustomer();// 反序列 Customer 物件
        System.out.println(customer);
    }

    /**
     * MethodName: SerializeCustomer
     * Description: 序列化 Customer 物件
     */
    private static void SerializeCustomer(){
        Customer customer = new Customer("gacl",25);

        try(ObjectOutputStream oo = new ObjectOutputStream(
                new FileOutputStream(
                        new File("C:/JavaCode/Customer.txt")))){

            oo.writeObject(customer);
            oo.defaultWriteObject();
            System.out.println("Customer 物件 序列化成功！");

        }catch(FileNotFoundException e1){
            e1.printStackTrace();
        }catch(IOException e2){
            e2.printStackTrace();
        }
    }

    /**
     * MethodName: DeserializeCustomer
     * Description: 反序列 Customer 物件
     * @return
     */
    private static Customer DeserializeCustomer(){
        Customer customer = null;

        try(ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(
                        new File("C:/JavaCode/Customer.txt")))){

            customer = (Customer) ois.readObject();
            System.out.println("Customer 物件 反序列化成功！");

        }catch(IOException e1){
            e1.printStackTrace();
        }catch(Exception e2){
            e2.printStackTrace();
        }

        return customer;
    }
}

/**
 * ClassName: Customer
 * Description: Customer 實作 Serializable 介面，可以被序列化
 */
class Customer implements Serializable {
    //Customer 中沒有定義 serialVersionUID
    private String name;
    private int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /*
     * @MethodName toString
     * @Description 多載 Object 的 toString() 方法
     * @return string
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "name=" + name + ", age=" + age;
    }
}




