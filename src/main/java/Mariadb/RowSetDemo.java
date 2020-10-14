package Mariadb;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

public class RowSetDemo {
    public static void main(String[] args) {


        String url = "jdbc:mariadb://localhost:3306/mydatabase?allowPublicKeyRetrieval=true";
        String user = "my_user";
        String pass = "my_password";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {

            // RowSet默認可以處理Read後的資料，但記憶體用量比ResultSet高
            // 使用靜態方法取得 JdbcRowSet 物件實例
            JdbcRowSet jdrs = RowSetProvider.newFactory().createJdbcRowSet();

            // 設定 RowSet 連接資料庫的資料，並取得查詢結果
            jdrs.setUrl(url);
            jdrs.setUsername(user);
            jdrs.setPassword(pass);
            jdrs.setCommand("select * from mydatabase.member");
            jdrs.execute();

            System.out.println("連接資料庫成功，並取得查詢結果");

            while (jdrs.next()) {
                System.out.println(
                        jdrs.getInt(1) + "\t" +
                                jdrs.getString(2) + "\t" +
                                jdrs.getString(3)
                );
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
