package IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamDemo {

    public static void main(String[] args) throws IOException {
        try (FileOutputStream output = new FileOutputStream("temp.dat")) {
            for (int i = 1; i <= 10; i++) {
                output.write(i);
            }//此檔為二進制(以bit構成)，無法以文本打開
        }//在java內部打開
        try (FileInputStream input = new FileInputStream("temp.dat")) {
            int value;
            while ((value = input.read()) != -1) {
                System.out.println(value + " ");
            }
        }
    }
}
