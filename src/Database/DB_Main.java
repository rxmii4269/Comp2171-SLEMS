package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB_Main {
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public static void main(String[] args) {
    }

    public DB_Main() {
    }

    public static Connection getConnection() throws Exception {
        try {
            String var0 = "com.mysql.jdbc.Driver";
        } catch (Exception var1) {
            var1.printStackTrace();
        }

        return null;
    }
}
