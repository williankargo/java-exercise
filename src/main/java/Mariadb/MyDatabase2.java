package Mariadb;

import java.sql.*;

public class MyDatabase2 {
    public static void main(String[] args) {
        String url = "jdbc:mariadb://localhost:3306/mydatabase?allowPublicKeyRetrieval=true";
        String user = "my_user";
        String pass = "my_password";

        //加載驅動
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Connection -> Statement -> execute

        String str = "select * from mydatabase.member Where name like '%e%'";  //%表示任意長度
        try (   //獲取與資料庫的連接
                Connection conn = DriverManager.getConnection(url, user, pass);
                //獲取用於向資料庫發送SQL語法的Statement
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                // ResultSet: 數據中查詢結果返回的一種物件(用以存儲查詢結果)，另外它還具有操縱數據的功能，可能可以對數據更新
                ResultSet rs = stmt.executeQuery(str)) {

            System.out.println("連線資料庫成功");
            // 記得，連線前要先啟動Mariadb喔！


            // 使用 Ieterator
            while (rs.next()) {
                System.out.println("第" + rs.getRow() + "筆");
                System.out.print(rs.getInt("id") + "\t");
                System.out.print(rs.getString("name") + "\t");
                System.out.println(rs.getString("sex") + "\t");
            }
            /*
            while(rs.next()){
                System.out.println("第" + rs.getRow() + "筆");
                System.out.print(rs.getInt(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.println(rs.getString(3) + "\t");
            }
            */


            //可滾動的ResultSet
            // 移到資料庫結尾
            rs.last();
            if (rs.isLast()) {
                System.out.println("資料庫結尾");
            }

            // 移到資料庫開頭
            rs.first();
            if (rs.isFirst()) {
                System.out.println("資料庫開頭");
            }

            // 移到資料庫第二筆
            rs.absolute(2);
            System.out.println(rs.getString("name") + "\t");
            System.out.println();


            //資料庫的索引編號是從1開始！
            // 取得欄位數量
            int columns = rs.getMetaData().getColumnCount();
            for (int i = 1; i <= columns; i++) {
                System.out.print(rs.getMetaData().getColumnName(i) + " : "); //取得欄位名稱
                System.out.println(rs.getMetaData().getColumnTypeName(i)); //取得欄位資料型別
            }

        } catch (SQLException ex) {
            System.out.println("SQL");
            System.out.println(ex.getMessage());
        }
    }
}

