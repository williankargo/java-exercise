package file;

import java.io.File;

public class testFile {

    public static void main(String[] args) {
        //create a file instance
        File file = new File("fileText.txt");

        System.out.println(file.exists());
        System.out.println(file.length() + "bytes.");
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isDirectory()); //检查一个对象是否是文件夹
        System.out.println(file.isAbsolute());
        System.out.println(file.isHidden());
        System.out.println(file.getAbsolutePath());
        System.out.println(new java.util.Date(file.lastModified()));

    }
}
