package Mariadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.*;


public class PreparedStatementDemo {

    public static void main(String[] args) {
        String url = "jdbc:mariadb://localhost:3306/mydatabase?allowPublicKeyRetrieval=true";
        String user = "my_user";
        String pass = "my_password";

//        try {
//            Class.forName("org.mariadb.jdbc.Driver");
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        String str = "insert into mydatabase.member (id,name,sex) values (?,?,?)";

        // Connection -> Statement -> execute

        try (Connection conn = DriverManager.getConnection(url, user, pass);

             // 獲取用於向資料庫發送SQL預處理語句的PreparedStatement
             PreparedStatement pstmt = conn.prepareStatement(str)) {

            System.out.println("連線資料庫成功");

            // 動態設定參數值
            pstmt.setInt(1, 4);
            pstmt.setString(2, "Ben");
            pstmt.setString(3, "男");

            int count = pstmt.executeUpdate();

            System.out.println("新增" + count + " 筆");


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
