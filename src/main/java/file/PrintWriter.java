package file;

import java.io.FileNotFoundException;

public class PrintWriter {

    public static void main(String[] args) throws FileNotFoundException {
        java.io.File file = new java.io.File("fileText2.txt");  //File只能檢驗此file是否存在及存在下的相關特質
        if (file.exists()) {
            System.out.println("File already exists!");
            System.exit(0); //1:非正式退出程式, 0:正常結束程式
        }

        //printWriter: write
        try (java.io.PrintWriter output = new java.io.PrintWriter(file);) {

            output.print("John Lennon");
            output.print(864);

            //close the file
            output.close();      //關閉文件輸出入流，否則無法正確保存(可用try(){}取代）

        }
    }
}
