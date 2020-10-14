package Mariadb;

//https://ethan-imagination.blogspot.com/2018/12/javase-gettingstarted-023.html


// https://www.itread01.com/content/1543921458.html
// cmd:
// mysql.server start
// mysql -u root -p -> 輸入8486peter連線

import java.sql.*;

public class MyDatabase {
    public static void main(String[] args) {
        String url = "jdbc:mariadb://localhost:3306/mydatabase?allowPublicKeyRetrieval=true";
        String user = "my_user";
        String pass = "my_password";

        //加載驅動 (JDBC4.0後就會自動加載了)
//        try {
//            Class.forName("org.mariadb.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }


        try (   //獲取與資料庫的連接
                Connection conn = DriverManager.getConnection(url, user, pass);
                //獲取用於向資料庫發送SQL語法的Statement
                Statement stmt = conn.createStatement()) {

            System.out.println("連線資料庫成功");
            // 記得，連線前要先啟動Mariadb喔！


            // create table
            String str = "create table member (" //member: 資料表名稱
                    + "id integer primary key,"  // id:欄位名稱 integer:整數,資料型別 primary key:設定主鍵
                    + "name varchar(10),"        // name:第二個欄位名稱 varchar(10):字串,長度10(含中文)
                    + "sex varchar(1))";         // sex:第三個欄位名稱 varchar(1):字串,長度1(含中文)

            stmt.execute(str);
            System.out.println("member 資料表已建立");



            //insert data
            String[] str2 = {
                    "insert into mydatabase.member(id,name,sex) values(1,\"Tom\",\"男\")",
                    "insert into mydatabase.member(id,name,sex) values(2,\"Mary\",\"女\")",
                    "insert into mydatabase.member(id,name,sex) values(3,\"Helen\",\"女\")",
            };
            int count = 0;
            for (String tmp : str2) {
                count = stmt.executeUpdate(tmp);
                System.out.println("新增:" + count + "筆");
            }


        } catch (SQLException ex) {
            System.out.println("SQL");
            System.out.println(ex.getMessage());
        }
    }
}
