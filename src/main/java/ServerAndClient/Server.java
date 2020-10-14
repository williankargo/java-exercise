package ServerAndClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    /**
     * 當Client端發出請求後，Server端的程式會建立一個Socket物件，並透過這個物件與Client端連線，以便進行資料的傳遞，
     * Socket可以說是程式與網路之間的一種介面，要把資訊傳送到網路，就必須透過Socket的幫忙。
     */

    public static void main(String[] args) {
        try {
            ServerSocket svs = new ServerSocket(5050);  //建立ServerSocket物件，並設定埠號5050
            System.out.println("waiting for client");
            Socket sk = svs.accept();                   //Client提出請求，accept()會傳回一個Socket物件，並讓sk指向它
            System.out.println("Clinet connected");
            while (sk.isConnected()) {                    //當Socket持續在連接時，就做下面的事
                BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
                String msg = br.readLine();
                if (msg == null) {                      //當Client disconnect時，readline會傳回null
                    break;
                }
                System.out.println(msg);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
