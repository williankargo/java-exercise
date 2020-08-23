package file;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class WebURL {

    public static void main(String[] args) {
        System.out.println("Enter a URL: ");
        String URLString = new Scanner(System.in).next();

        try {
            URL url = new URL(URLString);
            int count = 0;
            Scanner input = new Scanner(url.openStream());  //此時input是一個物件

            while (input.hasNext()) {
                String line = input.nextLine();
                count += line.length();
            }

            System.out.println("The file size is " + count + " characters.");

        } catch (MalformedURLException e) { //Invalid URL
            e.printStackTrace();
        } catch (IOException e) { //IO Errors
            e.printStackTrace();
        }


    }
}
