package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB_Main {
    private static Connection con;
    private static Statement st;
    private static ResultSet rs;

    public static void main(String[] args) {
        DB_Main main = new DB_Main();
    }

    public DB_Main() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SLEMS", "root", "root");
            st = con.createStatement();
            rs = st.executeQuery("SELECT * from SLEMS");
            while (rs.next()) {
                System.out.println(rs.getInt(1) +
                        " " + rs.getString(2) +
                        " " + rs.getString(3));
                con.close();
            }

        } catch (Exception var1) {
            var1.printStackTrace();
        }
    }
}
