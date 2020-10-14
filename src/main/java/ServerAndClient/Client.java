package ServerAndClient;

import java.io.*;
import java.net.Socket;

public class Client {


    public static void main(String[] args) {

        BufferedWriter bw;
        try {
            Socket sk = new Socket("127.0.0.1", 5050);    //建立Socket物件，並設定ip(127.0.0.1是自己的主機)和埠號
            System.out.println("已連線Server");
            bw = new BufferedWriter(new OutputStreamWriter(sk.getOutputStream()));   //利用sk來取得輸出串流
            while (sk.isConnected()) {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  //透過輸入串流來取得Client的輸入
                System.out.print("client:");
                bw.write("Client:" + br.readLine() + "\n");   //寫入輸出串流
                bw.flush();                               //立即傳送
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
